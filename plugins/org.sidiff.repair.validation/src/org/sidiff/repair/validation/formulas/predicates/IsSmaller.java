package org.sidiff.repair.validation.formulas.predicates;

import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class IsSmaller extends Comparison {

	public IsSmaller(Term left, Term right) {
		super("isSmaller", left, right);
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		Integer left_value = (Integer) left.getValue();
		Integer right_value = (Integer) right.getValue();
		result = left_value < right_value;
		
		return result;
	}

	@Override
	public void repair(IRepairDecision parent, boolean expected, IScopeRecorder scope) {
		
		if (expected && !getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.DELETE, scope);
			right.repair(newRepairAlternative, RepairType.CREATE, scope);
		} 
		
		else if (!expected && getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.CREATE, scope);
			right.repair(newRepairAlternative, RepairType.DELETE, scope);
		}
	}
}
