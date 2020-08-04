package org.sidiff.validation.constraint.interpreter.formulas.predicates.integers;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.Comparison;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class IsSmaller extends Comparison {

	public IsSmaller(Term left, Term right) {
		super("isSmaller", left, right);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		Integer left_value = (Integer) left.getValue();
		Integer right_value = (Integer) right.getValue();
		result = left_value < right_value;
		
		return result;
	}

	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		if (expected && !getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.DELETE);
			right.repair(newRepairAlternative, RepairType.CREATE);
		} 
		
		else if (!expected && getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.CREATE);
			right.repair(newRepairAlternative, RepairType.DELETE);
		}
	}
}
