package org.sidiff.validation.constraint.impact;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class NegativePotentialImpactAnalysis extends PositivePotentialImpactAnalysis {

	public NegativePotentialImpactAnalysis(RepairActionIndex repairActions) {
		super(repairActions);
	}

	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onDelete(sourceContextType, reference, strict);
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		return super.onCreate(sourceContextType, reference, strict);
	}

}
