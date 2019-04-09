package org.sidiff.validation.constraint.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.decisiontree.DecisionTreeUtil;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;

public class RepairValidation extends Validation {
	
	protected IDecisionNode repair;
	
	public RepairValidation(
			IConstraint rule, boolean result, 
			EClass contextType, EObject context,
			IDecisionNode repair) {
		
		super(rule, result, contextType, context);
		this.repair = repair;
	}
	
	public IDecisionNode getRepair() {
		return repair;
	}
	
	public void cleanUpRepairTree() {
		repair = DecisionTreeUtil.cleanup(repair);
	}
}
