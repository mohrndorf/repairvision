package org.sidiff.validation.constraint.interpreter.formulas.predicates;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Constant;
import org.sidiff.validation.constraint.interpreter.terms.Term;
import org.sidiff.validation.constraint.interpreter.terms.functions.Get;

public class Equality extends Comparison {

	public Equality(Term left, Term right) {
		super("equality", left, right);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean evaluate(IScopeRecorder scope, boolean optimize) {
		left.evaluate(scope);
		right.evaluate(scope);
		
		if ((left.getValue() != null) && (right.getValue() != null)) {
			result = left.getValue().equals(right.getValue());
		} else {
			result = left.getValue() == right.getValue();
		}
		
		return result;
	}

	public Term getTermA() {
		return left;
	}

	public void setTermA(Term termA) {
		this.left = termA;
	}

	public Term getTermB() {
		return right;
	}

	public void setTermB(Term termB) {
		this.right = termB;
	}
	
	@Override
	public void required(IDecisionBranch parent, boolean expected) {
		
		// Record constant attribute equality tests:
		if (expected) {
			if (getTermA() instanceof Get) {
				EStructuralFeature feature = ((Get) getTermA()).getFeature();
				Object context = ((Get) getTermA()).getContext().getValue();
				
				if ((feature instanceof EAttribute) && (context instanceof EObject)) {
					if (getTermB() instanceof Constant) {
						Sequence sequence = Sequence.nextSequence(parent);
						ScopeNode scope = ScopeNode.getScopeNode(sequence);
//						scope.addEqualityTest((EObject) context, getTermB().getValue(), (EAttribute) feature);
						scope.addEqualityTest((EObject) context, ((EObject) context).eGet(feature), (EAttribute) feature);
					}
				}
			}
		}
		
		super.required(parent, expected);
	}
	
	@Override
	public void repair(IDecisionBranch parent, boolean expected) {
		
		if (expected != getResult()) {
			Alternative newRepairAlternative = Alternative.nextAlternative(parent);

			left.repair(newRepairAlternative, RepairType.MODIFY);
			right.repair(newRepairAlternative, RepairType.MODIFY);
		}
	}
}
