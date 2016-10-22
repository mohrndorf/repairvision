package org.sidiff.consistency.repair.lifting.ui.decoration;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.ui.provider.RepairContentProvider.Change;

public class SelectionAdapter {

	public static List<EObject> getElements(ISelection selection) {
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			
			if (selectedElement instanceof EObject) {
				return Collections.singletonList(((EObject) selectedElement));
			}
			
			else if (selectedElement instanceof Repair) {
				return Collections.unmodifiableList(((Repair) selectedElement)
						.getRepairPreMatch().getMatch().getNodeTargets());
			}
			
			else if (selectedElement instanceof Change) {
				// FIXME: Needs a XMI-ID copy for the complement-rule!
				return Collections.singletonList(((Change) selectedElement).graphElement);
			}
		}
		
		return Collections.emptyList();
	}
}
