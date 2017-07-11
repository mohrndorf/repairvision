package org.sidiff.validation.constraint.interpreter.formulas.binary;

import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class If extends BinaryFormula {

	public If(Formula left, Formula right) {
		super(left, right);
		this.name = "implies";
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		
		if (optimize) {
			result = !left.evaluate(scope, optimize) || right.evaluate(scope, optimize);
		} else {
			left.evaluate(scope, optimize);
			right.evaluate(scope, optimize);
			result = !left.getResult() || right.getResult();
		}
		
		return result;
	}
	
	@Override
	public void required(IDecisionNode parent, boolean expected) {
		
		// A IMPLIES B = !A OR B:
		
		// A IMPLIES B = true:
		// t         t*  t*
		// t         f   f
		// f*        t*  t*
		// f*        f   t*
		// > Alternative

		// A IMPLIES B = false:
		// t         t   t
		// t*        f*  f*
		// f         t   t
		// f         f   t
		// > Sequence

		if (result == expected) {
			if (expected && left.getResult() && right.getResult()) {
				right.required(parent, left.getResult());
			}
			
			else if (expected && !left.getResult() && right.getResult()) {
				Alternative alternative = Alternative.nextAlternative(parent);
				left.required(alternative, left.getResult());
				right.required(parent, right.getResult());
			}
			
			else if (expected && !left.getResult() && !right.getResult()) {
				left.required(parent, left.getResult());
			}
			
			else if (!expected && left.getResult() && !right.getResult()) {
				Sequence sequence = Sequence.nextSequence(parent);
				left.required(sequence, left.getResult());
				right.required(sequence, right.getResult());
			}
		}
	}

	@Override
	public void repair(IDecisionNode parent, boolean expected) {
		
		// A IMPLIES B = !A OR B:
		
		// A IMPLIES B = true:
		// t         t   t
		// t*        f*  f*
		// f         t   t
		// f         f   t
		// > Alternative

		// A IMPLIES B = false:
		// t         t*  t*
		// t         f   f
		// f*        t*  t*
		// f*        f   t*
		// > Sequence
		
		if (getResult() != expected) {
			if (expected && left.getResult() && !right.getResult()) {
				Alternative newRepairAlternative = Alternative.nextAlternative(parent);
				left.repair(newRepairAlternative, !left.getResult());
				right.repair(newRepairAlternative, !right.getResult());
			}
			
			else if (!expected && left.getResult() && right.getResult()) {
				right.repair(parent, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && right.getResult()) {
				Sequence newRepairSequence = Sequence.nextSequence(parent);
				left.repair(newRepairSequence, !left.getResult());
				right.repair(newRepairSequence, !right.getResult());
			}
			
			else if (!expected && !left.getResult() && !right.getResult()) {
				left.repair(parent, !left.getResult());
			}
		}
	}
}
