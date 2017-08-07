package org.sidiff.repair.ui.controls.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.DrillDownAdapter;
import org.sidiff.consistency.common.ui.util.NameUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.integration.editor.highlighting.EditorHighlighting;
import org.sidiff.integration.editor.highlighting.ISelectionHighlightingAdapter;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.Activator;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.repair.ui.provider.RepairContentProvider;
import org.sidiff.repair.ui.provider.RepairLabelProvider;
import org.sidiff.repair.ui.provider.model.Change;

public class BasicRepairViewerUI<A extends IRepairApplication<?, ?>> extends BasicRepairUI<A> {

	protected TreeViewer viewer_repairs;
	
	protected ISelectionHighlightingAdapter highlightingAdapter;
	
	private DrillDownAdapter drillDownAdapter;
	
	protected Action openConfiguration;
	
	protected Action calculateRepairs;
	
	protected Action applyRepairs;
	
	protected Action undoRepairs;
	
	protected Action clearSetup;
	
	@Override
	public void createPartControls(Composite parent, IWorkbenchPartSite site) {
		createRepairViewer(parent, site);
		makeActions(site);
	}
	
	protected void createRepairViewer(Composite parent, IWorkbenchPartSite site) {
		
		// Repair-Viewer:
		viewer_repairs = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_repairs.setContentProvider(new RepairContentProvider());
		viewer_repairs.setLabelProvider(new RepairLabelProvider());

		// Setup editor highlighting:
		highlightingAdapter = new ISelectionHighlightingAdapter() {
			
			@Override
			public Iterator<? extends EObject> getElements(ISelection selection) {
				Object selectedElement = ISelectionHighlightingAdapter.getFirstElement(selection);
				
				if (selectedElement instanceof IRepairPlan) {
					return ((IRepairPlan) selectedElement).getRepairPreMatch()
							.getMatch().getNodeTargets().iterator();
				}
				
				else if (selectedElement instanceof Change) {
					// FIXME: Needs a XMI-ID copy for the complement-rule!
					return Collections.singletonList(((Change) selectedElement).graphElement).iterator();
				}
				
				return ISelectionHighlightingAdapter.EMPTY_ITERATOR;
			}
		};
		
		EditorHighlighting.getInstance().registerAdapter(highlightingAdapter);
		viewer_repairs.addSelectionChangedListener(
				EditorHighlighting.getInstance().getSelectionChangedListener());
		
		// Workbench selection:
		site.setSelectionProvider(viewer_repairs);
		
		// Expand / Collapse on double click:
		viewer_repairs.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				
				try {
					if (viewer_repairs.getExpandedState(item)) {

						// Collapse:
						viewer_repairs.collapseToLevel(item, TreeViewer.ALL_LEVELS);
					} else {
						
						// Expand:
						if (item instanceof IRepairPlan) {
							viewer_repairs.expandToLevel(item, 3);
						} else {
							viewer_repairs.expandToLevel(item, 1);
						}
					}
				} catch (Exception e) {
				}
			}
		});
	}
	
	protected void makeActions(IWorkbenchPartSite site) {
		
		this.drillDownAdapter = new DrillDownAdapter(viewer_repairs);

		// Open configuration:
		openConfiguration = new Action() {
			public void run() {
				PreferenceDialog configurationPage = PreferencesUtil.createPreferenceDialogOn(
						site.getShell(), RepairPreferencePage.ID, null, null);
				
				if (configurationPage != null) {
					configurationPage.open();
				}
			}
		};
		openConfiguration.setText("Configuration");
		openConfiguration.setToolTipText("Open Configuration");
		openConfiguration.setImageDescriptor(Activator.getImageDescriptor("icons/configuration.png"));
		
		// Calculate repairs:
		calculateRepairs = new Action() {
			public void run() {
				application.calculateRepairs();
			}
		};
		calculateRepairs.setText("Search Repairs");
		calculateRepairs.setToolTipText("Search Repairs");
		calculateRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/bulb.png"));
		
		// Apply repair:
		applyRepairs = new Action() {
			@SuppressWarnings("unchecked")
			public void run() {
				ISelection selection = viewer_repairs.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					List<IRepairPlan> selectedRepairs = new ArrayList<>();
					
					((IStructuredSelection)selection).iterator().forEachRemaining(o -> {
						if (o instanceof IRepairPlan) {
							selectedRepairs.add((IRepairPlan) o);
						}
					});
					
					if (!selectedRepairs.isEmpty()) {
						if (application.applyRepairs(selectedRepairs)) {
							
							// TODO: Ask the user what to do!
							// Recalculate repairs:
							application.recalculateRepairs();
							
							WorkbenchUtil.showMessage("Repair successfully applied!");
						} else {
							WorkbenchUtil.showMessage("Repair could not be applied!");
						}
						return;
					}
				}
				
				WorkbenchUtil.showMessage("Please select a repair operation!");
			}
		};
		applyRepairs.setText("Apply Repair");
		applyRepairs.setToolTipText("Apply Repair");
		applyRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/apply.png"));
		
		// Undo repair:
		undoRepairs = new Action() {
			public void run() {
				List<RuleApplication> lastRepairs = application.undoLastRepairs();
				
				if (lastRepairs != null) {
					
					// TODO: Ask the user what to do!
					// Recalculate repairs:
					application.recalculateRepairs();
					
					// Show user message:
					String rules = "";
					
					for (RuleApplication lastRepair : lastRepairs) {
						rules += NameUtil.beautifyName(lastRepair.getRule().getName());
					}
					
					WorkbenchUtil.showMessage("Repair ("+ rules +") successfully undone!");
				} else {
					WorkbenchUtil.showMessage("Repair could not be undone!");
				}
			}
		};
		undoRepairs.setText("Undo Repair");
		undoRepairs.setToolTipText("Undo Repair");
		undoRepairs.setImageDescriptor(Activator.getImageDescriptor("icons/undo.png"));
		
		// Clear setup:
		clearSetup = new Action() {
			public void run() {
				application.clear();
				clear();
			}
		};
		clearSetup.setText("Clear");
		clearSetup.setToolTipText("Clear");
		clearSetup.setImageDescriptor(Activator.getImageDescriptor("icons/clear.png"));
	}
	
	@Override
	public void createLocalToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(applyRepairs);
		manager.add(undoRepairs);
		manager.add(new Separator());
		manager.add(clearSetup);
		manager.add(openConfiguration);
		manager.add(new Separator());
		
		drillDownAdapter.addNavigationActions(manager);
	}

	@Override
	public void createLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(calculateRepairs);
		manager.add(new Separator());
	}

	@Override
	public void createContextMenu(IMenuManager manager) {
		
		manager.add(new Separator());
		manager.add(applyRepairs);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);
	}
	
	@Override
	public void hookContextMenu(MenuManager manager) {
		
		// Hook menu to repair viewer:
		Menu menu = manager.createContextMenu(viewer_repairs.getControl());
		viewer_repairs.getControl().setMenu(menu);
	}
	
	@Override
	public void resultChanged(RepairJob<?> repairJob) {
		
		// NOTE: Unset old comparator:
		// - set input triggers compare -> new data with old comparator
		// - set comparator triggers compare -> new comparator with old data
		viewer_repairs.setComparator(null); 
		viewer_repairs.setInput(repairJob);
		
		viewer_repairs.setComparator(new ViewerComparator() {
			
			@Override
			public int compare(Viewer viewer, Object o1, Object o2) {
				return repairJob.getRanking().compare(o1, o2);
			}
		});
	}
	
	@Override
	public ISelectionProvider getSelectionProvider() {
		return viewer_repairs;
	}
	
	@Override
	public void clear() {
		viewer_repairs.setInput(null);
	}
	
	@Override
	public void setFocus() {
		viewer_repairs.getControl().setFocus();
	}

	@Override
	public void dispose() {
		EditorHighlighting.getInstance().deregisterAdapter(highlightingAdapter);
	}
}
