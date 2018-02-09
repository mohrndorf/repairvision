package org.sidiff.repair.ui.peo.ruleselection;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.controls.basic.BasicRepairViewerUI;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;
import org.sidiff.repair.ui.controls.basic.ModelVersionsDropWidget;
import org.sidiff.repair.ui.peo.Activator;
import org.sidiff.repair.validation.ui.widgets.ValidationWidget;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;

public class RuleSelectionRepairUI extends BasicRepairViewerUI<RuleSelectionRepairApplication> {

	/**
	 * Shows the abstract repairs.
	 */
	private ValidationWidget validationWidget;

	/**
	 * Drop target to create a rulebase.
	 */
	private ModelDropWidget editRules;
	
	/**
	 * Drop target for the model versions
	 */
	private ModelVersionsDropWidget modelVersions;
	
	/**
	 * Debug the current session.
	 */
	protected Action startDebugger;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		
		// Sash-Form:
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// Repair viewer:
		super.createPartControls(sashForm, site);
		
		// Validation-Viewer:
		validationWidget = new ValidationWidget();
		validationWidget.createControls(sashForm);
		
		validationWidget.getViewer().addCheckStateListener(new ICheckStateListener() {
			
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				
				if (event.getElement() instanceof Validation) {
					
					// Clear selection:
					validationWidget.getViewer().setCheckedElements(new Object[0]);
					
					// Start repair calculation:
					if (event.getChecked()) {
						validationWidget.getViewer().setChecked(event.getElement(), event.getChecked());
						
						// Get inconsistency that should be repaired:
						Validation inconsistency = (Validation) event.getElement();
						application.setInconsistency(inconsistency);
						
						// Search for repairs:
						application.calculateRepairs();
					}
				} else {
					// Ignore other selections:
					validationWidget.getViewer().setChecked(event.getElement(), false);
				}
			}
		});

		// Edit-Rules:
		Composite composite_editrules = new Composite(sashForm, SWT.BORDER);
		composite_editrules.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		editRules = new ModelDropWidget(composite_editrules, "Please drop the edit-rule(s) here!") {

			@Override
			protected IResource removeModel(IResource selection) {
				return application.removeEditRule(selection);
			}

			@Override
			protected IResource addModel(IResource element) {
				return application.addEditRule(element);
			}
		};
		
		// Model version input:
		modelVersions = new ModelVersionsDropWidget(getApplication());
		modelVersions.createModelAControls(sashForm);
		modelVersions.createModelBControls(sashForm);

		// Setup Sash-Form:
		sashForm.setWeights(new int[] {100, 32, 10, 10, 10});
	}
	
	@Override
	protected void makeActions(IWorkbenchPartSite site) {
		super.makeActions(site);
		
		// start debugging session:
		startDebugger = new Action() {
			public void run() {
				WorkbenchUtil.showView("org.sidiff.repair.ui.peo.debugger.EditRuleMatcherDebugger");
				
				application.setDebugging(true);
				application.calculateRepairs();
			}
		};
		startDebugger.setText("Debug");
		startDebugger.setToolTipText("Start Debugging Session");
		startDebugger.setImageDescriptor(Activator.getImageDescriptor("icons/debug_exc.gif"));
	}
	
	@Override
	public void createLocalPullDown(IMenuManager manager) {
		super.createLocalPullDown(manager);
		manager.add(startDebugger);
		manager.add(new Separator());
	}
	
	@Override
	protected void refreshActionStates() {
		super.refreshActionStates();
		startDebugger.isEnabled();
	}
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		assert (repairJob  == application.getRepairJob());
		
		super.resultChanged(repairJob);
		validationWidget.setInput(application.getValidations());
		
		application.setDebugging(false);
	}

	@Override
	public void clear() {
		super.clear();
		validationWidget.clear();
		editRules.clear();
		modelVersions.clear();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		validationWidget.dispose();
	}
}
