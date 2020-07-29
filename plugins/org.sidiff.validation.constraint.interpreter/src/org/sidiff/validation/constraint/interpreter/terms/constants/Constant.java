package org.sidiff.validation.constraint.interpreter.terms.constants;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.analyze.ConstraintConstant;
import org.sidiff.validation.constraint.interpreter.decisiontree.analyze.ConstraintAction.ConstraintType;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Term;

public class Constant extends Term {
	
	public Constant(Object constant) {
		this.value = constant;
	}
	
	@Override
	public EClassifier getType() {
		if (value instanceof Boolean) {
			return EcorePackage.eINSTANCE.getEBoolean();
		} else if (value instanceof String) {
			return EcorePackage.eINSTANCE.getEString();
		} else if (value instanceof Integer) {
			return EcorePackage.eINSTANCE.getEInt();
		}  else {
			EClassifier classifier = EcorePackage.eINSTANCE.getEClassifier("E" + value.getClass().getSimpleName());
			
			if (classifier != null) {
				return classifier;
			} else {
				return EcorePackage.eINSTANCE.getEJavaObject();
			}
		}
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Object evaluate(IScopeRecorder scope) {
		return value;
	}
	
	@Override
	public void generate(IDecisionBranch parent, ConstraintType type) {
		parent.appendChildDecisions(new ConstraintConstant(type, getType(), value));
	}
	
	@Override
	public void required(IDecisionBranch parent) {
		ScopeNode.getScopeNode(parent).addElement(value);
	}

	@Override
	public void repair(IDecisionBranch parent, RepairType type) {
		// Nothing to do...
	}
}
