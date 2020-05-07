package org.sidiff.revision.repair.history.evaluation.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.utilities.monitor.LogTable;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.generic.matcher.uuid.UUIDMatcher;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.util.TechnicalDifferenceBuilderUtil;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.repair.api.IRepairFacade;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.peo.PEORepairJob;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.history.evaluation.driver.HistoryEvaluationDriver;
import org.sidiff.revision.repair.history.evaluation.driver.InconsistencyEvaluationDriver;
import org.sidiff.revision.repair.history.evaluation.driver.PrintHistoryInfoDriver;
import org.sidiff.revision.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.revision.repair.history.evaluation.util.EvaluationUtil;
import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.app.IResultChangedListener;
import org.sidiff.revision.repair.ui.config.RepairPreferencePage;

public class HistoryRepairApplication implements IRepairApplication<PEORepairJob, PEORepairSettings> {

	protected IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;
	
	protected List<IResultChangedListener<PEORepairJob>> listeners = new ArrayList<>();

	protected Collection<IResource> editRuleFiles = new ArrayList<>();
	
	protected Job calculation;
	
	protected HistoryInfo history;
	
	protected PEORepairJob repairJob;
	
	public void setHistory(History history) {
		this.history = new HistoryInfo(history);
		PrintHistoryInfoDriver.printHistoryInfo(this.history);
	}
	
	public Object getValidations() {
		return EvaluationUtil.toEObjectList(history
				.getSupportedIntroducedAndResolvedUniqueInconsistencies(), "History");
	}
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}
	
	@Override
	public void addResultChangedListener(IResultChangedListener<PEORepairJob> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(IResultChangedListener<PEORepairJob> listener) {
		listeners.remove(listener);
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getRepairJob()));
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	@Override
	public void validation() {
		
		calculation = new Job("Evaluate History") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				HistoryEvaluationDriver.calculateRepairs(repairFacade, history, getEditRules(), getMatchingSettings());
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	@Override
	public void calculateRepairs() {
	}
	
	@Override
	public void recalculateRepairs() {
	}
	
	public void repairInconsistency(Problem selection) {
		
		calculation = new Job("Calculate Repairs") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// Initialize:
				InconsistencyTrace repaired = InconsistencyTrace.createRepairedInconsistency(selection, true);
				
				LogTable inconsistenciesLog = new LogTable();
				LogTable runtimeComplexityLog = new LogTable();

				// Calculate repairs:
				repairJob = InconsistencyEvaluationDriver.calculateRepairs(
						true, true, false, history, repairFacade, repaired, 
						getEditRules(), getMatchingSettings(),
						inconsistenciesLog, runtimeComplexityLog);
				
				// Save CSV logs:
				String timestamp = EvaluationUtil.getTimestamp();
				
				EvaluationUtil.saveLog(history, inconsistenciesLog, 
						timestamp, "inconsistency_" + repaired.getName());
				EvaluationUtil.saveLog(history, runtimeComplexityLog, 
						timestamp, "runtime_" + repaired.getName());
				EvaluationUtil.updateProject(history);

				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Show results:
					fireResultChangeListener();

					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});

				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
	
	public IResource addEditRule(IResource element) {
		element = RulebaseUtil.getEditRule(element);
		
		if ((element != null) && !editRuleFiles.contains(element)) {
			editRuleFiles.add(element);
			return element;
		}

		return null;
	}
	
	@Override
	public boolean applyRepair(IRepairPlan repair, Match match) {
		return repairJob.applyRepair(repair, match, true);
	}
	
	@Override
	public boolean undoRepair() {
		
		if (repairJob == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return true;
		}
		
		if (calculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return true;
		}
		
		return repairJob.undoRepair(true);
	}
	
	@Override
	public boolean rollbackInconsistencyInducingChanges(IRepairPlan repair) {
		return repairJob.rollbackInconsistencyInducingChanges(repair, true);
	}

	public IResource removeEditRule(IResource selection) {
		editRuleFiles.remove(selection);
		return selection;
	}
	
	public Collection<Rule> getEditRules() {
		return RulebaseUtil.loadEditRules(editRuleFiles, false, false);
	}

	@Override
	public PEORepairJob getRepairJob() {
		return repairJob;
	}
	
	public void populateSettings(Resource modelA, Resource modelB) {
		RepairPreferencePage.populateSettings(modelB);
	}
	
	public DifferenceSettings getMatchingSettings() {
		DifferenceSettings settings = RepairPreferencePage.getMatchingSettings();
		settings.setMatcher(new UUIDMatcher());
		settings.setTechBuilder(TechnicalDifferenceBuilderUtil.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
	public String getDoumentType() {
		return RepairPreferencePage.getDoumentType();
	}
	
	@Override
	public void clear() {
		editRuleFiles.clear();
		clearCalculation();
	}
	
	public void clearCalculation() {
		calculation = null;
		history = null;
		repairJob = null;
	}
}
