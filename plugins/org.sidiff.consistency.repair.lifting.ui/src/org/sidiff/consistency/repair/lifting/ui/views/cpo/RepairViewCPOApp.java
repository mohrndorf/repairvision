package org.sidiff.consistency.repair.lifting.ui.views.cpo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.sidiff.consistency.common.ui.WorkbenchUtil;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.cpo.CPORepairFacade;
import org.sidiff.consistency.repair.lifting.ui.views.ModelDropWidget;
import org.sidiff.consistency.repair.lifting.ui.views.RepairViewBasicApp;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

public class RepairViewCPOApp extends RepairViewBasicApp {
	
	private Collection<IResource> subEditRuleFiles = new ArrayList<>();

	private Collection<IResource> cpEditRuleFiles = new ArrayList<>();
	
	private RepairJob repairJob;
	
	public RepairViewCPOApp(TreeViewer viewer_repairs) {
		super(viewer_repairs);
	}

	@Override
	public void calculateRepairs() {
		
		Job repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Matching-Settings:
				DifferenceSettings settings = getMatchingSettings();
				
				// Load edit-rules:
				Collection<Rule> subEditRules = loadEditRules(subEditRuleFiles);
				Collection<Rule> cpEditRules = loadEditRules(cpEditRuleFiles);
				
				// Calculate repairs:
				if (!subEditRules.isEmpty() && !cpEditRules.isEmpty()) {
					URI uriModelA = ModelDropWidget.getURI(modelAFile);
					URI uriModelB = ModelDropWidget.getURI(modelBFile);
					
					repairJob = CPORepairFacade.getRepairs(
							uriModelA, uriModelB, 
							subEditRules, cpEditRules, 
							documentType, settings);
					
					// Update UI:
					Display.getDefault().syncExec(() -> {
						// Analyze results:
						SymmetricDifference difference =(SymmetricDifference) repairJob.getDifference().getContents().get(0);
						
						if (difference.getChangeSets().isEmpty()) {
							WorkbenchUtil.showMessage("No partially executed edit-operations found!");
						}
						
						// Show repairs:
						viewer_repairs.setInput(repairJob.getRepairs());
					});
				}
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}

	@Override
	public void applyRepair(Repair repair) {
		
		// Apply repair:
		repair.apply();
		
		// Save model
		try {
			repairJob.getModelB().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean removeSubEditRule(IResource selection) {
		subEditRuleFiles.remove(selection);
		return true;
	}

	public boolean addSubEditRule(IResource element) {
		if (element.getFileExtension().equalsIgnoreCase("henshin")) {
			subEditRuleFiles.add(element);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeCPEditRule(IResource selection) {
		cpEditRuleFiles.remove(selection);
		return true;
	}

	public boolean addCPEditRule(IResource element) {
		if (element.getFileExtension().equalsIgnoreCase("henshin")) {
			cpEditRuleFiles.add(element);
			return true;
		} else {
			return false;
		}
	}
}
