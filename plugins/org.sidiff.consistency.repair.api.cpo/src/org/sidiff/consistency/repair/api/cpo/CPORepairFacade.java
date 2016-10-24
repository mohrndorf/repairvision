package org.sidiff.consistency.repair.api.cpo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.api.IRepair;
import org.sidiff.consistency.repair.api.IRepairFacade;
import org.sidiff.consistency.repair.api.cpo.lifting.BasicCPOLifting;
import org.sidiff.consistency.repair.api.cpo.util.StatisticUtil;
import org.sidiff.consistency.repair.api.matching.EditOperationMatching;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.cpo.matching.ComplementFinder;
import org.sidiff.consistency.repair.complement.repair.RepairOperation;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacade implements IRepairFacade<CPORepairJob, CPORepairSettings> {
	
	private BasicCPOLifting lifting;
	
	public CPORepairFacade(BasicCPOLifting lifting) {
		this.lifting = lifting;
	}
	
	@Override
	public CPORepairJob getRepairs(URI uriModelA, URI uriModelB, CPORepairSettings settings) {
		
		// Load models:
		long startLoadModels = System.currentTimeMillis();
		
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Loading Models: " + (System.currentTimeMillis() - startLoadModels) + "ms");
		}
		
		return getRepairs(modelA, modelB, settings);
	}
	
	@Override
	public CPORepairJob getRepairs(Resource modelA, Resource modelB, CPORepairSettings settings) {
		
		long repairJobTime = System.currentTimeMillis();
		
		// Initialize:
		assert (modelA.getResourceSet() == modelB.getResourceSet());
		ResourceSet differenceRSS = modelA.getResourceSet(); 
		
		// TODO: Create fresh resource set!?
		// [Workaround] (Cleanup) Remove old difference:
		for (Iterator<Resource> it = differenceRSS.getResources().iterator(); it.hasNext();) {
			Resource res = it.next();
			
			if (res instanceof SymmetricDifference) {
				it.remove();
			}
		}
		
		// Calculate difference:
		lifting.findSubEditRules(modelA, modelB, settings);
		
		SymmetricDifference difference = lifting.getDifference();
		IRecognitionEngine recognitionEngine = lifting.getRecognitionEngine();
		ILiftingRuleBase rulebases_sub = lifting.getRulebasesSub();
		
		// TODO: if (difference.getChangeSets().size() > 0) 
			
		// TODO: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI(""));
		differenceResource.getContents().add(difference);
		
		// Repair application:
		EngineImpl henshinEngine = new EngineImpl();
		
		// Use the graph of the recognition engine or with merged imports!
		EGraph modelBGraph = recognitionEngine.getGraphModelB();
		
		// Calculate repairs:
		long calculateComplements = System.currentTimeMillis();
		
		ComplementFinder complementFinder = new ComplementFinder(
				recognitionEngine.getRecognitionRuleApplications(), rulebases_sub,
				settings.getSubEditRules(), settings.getCPOEditRules(), 
				difference, modelBGraph);
		
		Map<Rule, List<IRepair>> repairs = new LinkedHashMap<>();
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Complement Calculation: " + (System.currentTimeMillis() - calculateComplements) + "ms");
		}
		
		long calculateRepairs = System.currentTimeMillis();
		
		for (Rule cpEditRule : complementFinder.getSourceRules()) {
			List<IRepair> repairsPerRule = new ArrayList<>();

			for(ComplementRule complement : complementFinder.getComplementRules(cpEditRule)) {
				if (complement.getComplementingChanges().size() > 0) {
					for (EditOperationMatching preMatch : complement.getComplementMatches()) {
						repairsPerRule.add(new RepairOperation(complement, preMatch));
					}
					complement.initialize(henshinEngine, modelBGraph);
				}
			}

			if (!repairsPerRule.isEmpty()) {
				repairs.put(cpEditRule, repairsPerRule);
			}
		}

		// Create repair job:
		CPORepairJob repairJob = new CPORepairJob();
		repairJob.setDifference(differenceResource);
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		// repairJob.setValidations(); // TODO: Add a common interface...

		if (DebugUtil.statistic) {
			System.out.println("#DONE# Calculate Repairs: " + (System.currentTimeMillis() - calculateRepairs) + "ms");
			System.out.println("#DONE# Full Repair Job: " + (System.currentTimeMillis() - repairJobTime) + "ms");
			
			StatisticUtil.analyzeSetup(settings.getSubEditRules(), settings.getCPOEditRules(), difference);
		}
		
		return repairJob;
	}
}
