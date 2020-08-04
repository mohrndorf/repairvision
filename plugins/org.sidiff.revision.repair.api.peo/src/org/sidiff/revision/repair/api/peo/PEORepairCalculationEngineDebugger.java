package org.sidiff.revision.repair.api.peo;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderRecorder;

public class PEORepairCalculationEngineDebugger extends PEORepairCalculationEngine {

	protected ComplementFinderRecorder lastComplementFinderMonitor;
	
	public PEORepairCalculationEngineDebugger(PEORepairSettings settings, Resource modelA, Resource modelB) {
		super(settings, modelA, modelB);
	}
	
	@Override
	protected PEORepairCaculation createRepairCalculation(
			Rule editRule, IRevision revision, 
			ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes,
			ComplementFinderEngine complementFinderEngine) {
		
		PEORepairCaculation repairCaculation = super.createRepairCalculation(
				editRule, revision, historicalImpactAnalyzes, currentImpactAnalyzes, complementFinderEngine);
		
		lastComplementFinderMonitor = new ComplementFinderRecorder(repairCaculation.getComplementFinder());
		lastComplementFinderMonitor.setMatchingPathRecording(true);
		
		return repairCaculation;
	}
	
	public ComplementFinderRecorder getLastComplementFinderMonitor() {
		return lastComplementFinderMonitor;
	}
}
