package org.sidiff.repair.api.cpo.lifting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.debug.DebugUtil;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.settings.LiftingSettings.RecognitionEngineMode;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;
import org.sidiff.repair.api.cpo.CPORepairSettings;
import org.sidiff.repair.api.cpo.util.PostProcessingUtil;
import org.sidiff.repair.api.cpo.util.RulebaseUtil;

public class CompleteCPOLifting extends BasicCPOLifting {

	@Override
	public void findSubEditRules(Resource modelA, Resource modelB, CPORepairSettings settings) {
		
		try {
			
			// Create a (temporary) CPO rulebase:
			ILiftingRuleBase rulebase_cpo = RulebaseUtil.createRuleBase(settings.getCPOEditRules(), "CPOs"); 
			Set<ILiftingRuleBase> rulebases_cpos = new HashSet<>();
			rulebases_cpos.add(rulebase_cpo);
			
			// Create a (temporary) Sub-EO rulebase:
			rulebases_sub = RulebaseUtil.createRuleBase(settings.getSubEditRules(), "Sub-Rules"); 
			Set<ILiftingRuleBase> rulebases_subs = new HashSet<>();
			rulebases_subs.add(rulebases_sub);
			
			// Common-Lifting settings:
			LiftingSettings liftingSettings = new LiftingSettings(Collections.singleton(settings.getDocumentType()));
			liftingSettings.setMatcher(settings.getDifferenceSettings().getMatcher());
			liftingSettings.setTechBuilder(PipelineUtils.getDefaultTechnicalDifferenceBuilder(Collections.singleton(settings.getDocumentType())));
			liftingSettings.setCalculateEditRuleMatch(false);
			
			// Create technical difference:
			long calculateDifference = System.currentTimeMillis();
			
			difference = LiftingFacade.deriveTechnicalDifference(modelA, modelB, settings.getDifferenceSettings());
			
			if (DebugUtil.statistic) {
				System.out.println("#DONE# Calculate Difference: " + (System.currentTimeMillis() - calculateDifference) + "ms");
			}
			
			// CPO-Lifting:
			long cpoLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_cpos);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING); // no post-processing
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (CPO): " + difference.getChangeSets().size());
//				StatisticUtil.analyzeDifference(difference);
			}
			
			// Remove CPO change sets:
			// TODO: Parallelize this...
			for (SemanticChangeSet changeSet : difference.getChangeSets()) {
				for (Change change : changeSet.getChanges()) {
					difference.getChanges().remove(change);
				}
			}
			difference.getChangeSets().clear();
			difference.getUnusedChangeSets().clear();
			
			if (DebugUtil.statistic) {
				System.out.println("#DONE# Searching CPOs: " + (System.currentTimeMillis() - cpoLifting) + "ms");
			}
			
			// Sub-EO-Lifting (on reduced difference):
			long subLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_subs);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING); // no post-processing
			
			// TODO[Optimization]: Reuse of CPO recognition engine possible!?
			//                     At least modelA an B graph! 
			liftingSettings.setRecognitionEngine(null);
			
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);
			
			// Post processing:
			DifferenceAnalysisUtil.analyzeDifferenceStructure(difference);
			
			// Remove properly nested EOs (keep overlapping):
			PostProcessingUtil.removeSubChangeSets(difference);
			
			// TODO: How to deal with duplicates!?
			PostProcessingUtil.removeDuplicatedChangeSets(difference);
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (Sub-EOs): " + difference.getChangeSets().size());
				System.out.println("#DONE# Searching Sub-EOs: " + (System.currentTimeMillis() - subLifting) + "ms");
			}
			
			// Save used recognition engine:
			recognitionEngine = liftingSettings.getRecognitionEngine();
			
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
	}
}
