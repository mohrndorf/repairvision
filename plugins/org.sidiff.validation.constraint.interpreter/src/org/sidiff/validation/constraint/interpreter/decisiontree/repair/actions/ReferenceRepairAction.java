package org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.common.utilities.java.NameUtil;

public class ReferenceRepairAction extends StructuralFeatureRepairAction {
	
	protected EObject target;

	public ReferenceRepairAction(RepairType type, EObject context, EReference reference) {
		super(type, context, reference);
	}
	
	public ReferenceRepairAction(RepairType type, EObject context, EReference reference, EObject target) {
		super(type, context, reference);
	}
	
	public EReference getReference() {
		return (EReference) feature;
	}
	
	public EObject getTarget() {
		return target;
	}
	
	@Override
	public boolean isAbstract() {
		return (target == null);
	}
	
	public boolean match(RepairType type, EObject context, EStructuralFeature feature, EObject target) {
		if (isAbstract()) {
			return match(type, context, feature);
		} else {
			return this.target.equals(target) && match(type, context, feature);
		}
	}

	@Override
	public IDecisionNode deepCopy() {
		return new ReferenceRepairAction(type, context, getReference(), target);
	}

	@Override
	public String toString() {
		return "ReferenceRepairAction [type=" + type + ", context=" + context + ", feature=" + feature + ", target=" + target + "]";
	}
	
	@Override
	public String getRepairLabel() {
		if (isAbstract()) {
			return type + ", " + NameUtil.getName(context) + ", " + feature.getName();
		} else {
			return type + ", " + context + ", =" + feature.getName() + ", " + target;
		}
	}
}