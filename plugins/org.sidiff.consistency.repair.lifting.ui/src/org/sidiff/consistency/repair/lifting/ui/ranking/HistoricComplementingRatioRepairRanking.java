package org.sidiff.consistency.repair.lifting.ui.ranking;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.sidiff.consistency.repair.lifting.api.Repair;

public class HistoricComplementingRatioRepairRanking extends ViewerSorter  {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		
		// Show the element with the greater ratio on top of the viewer:
		if ((e1 instanceof Repair) && (e2 instanceof Repair)) {
			double ratio1 = (double) ((Repair) e1).getHistoricChanges().size() / ((Repair) e1).getComplementingChanges().size();
			double ratio2 = (double) ((Repair) e2).getHistoricChanges().size() / ((Repair) e2).getComplementingChanges().size();
			double diff = (ratio1 - ratio2);
			
			if (diff != 0) {
				if (diff < 0) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		
		return 0;
	}
}
