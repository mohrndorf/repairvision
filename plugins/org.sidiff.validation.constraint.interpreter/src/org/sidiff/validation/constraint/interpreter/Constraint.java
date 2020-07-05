package org.sidiff.validation.constraint.interpreter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.validation.constraint.interpreter.decisiontree.Alternative;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.Sequence;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairAction.RepairType;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.terms.Variable;

public class Constraint extends NamedElement implements IConstraint {

	private EClass contextType;
	
	private Variable context;
	
	private Formula formula;
	
	private String message;
	
	public Constraint(EClass contextType, Variable context, Formula formula) {
		super();
		this.contextType = contextType;
		this.context = context;
		this.formula = formula;
	}
	
	@Override
	public boolean evaluate(EObject contextElement) {
		return evaluate(contextElement, IScopeRecorder.DUMMY);
	}
	
	@Override
	public boolean evaluate(EObject contextElement, IScopeRecorder scope) {
		this.context.assign(contextElement);
		return formula.evaluate(scope, true);
	}
	
	@Override
	public IDecisionBranch required() {
		formula.evaluate(IScopeRecorder.DUMMY, false);
		
		IDecisionBranch rootNode= new Sequence();
		ScopeNode.getScopeNode(rootNode).addElement(getContext());
		
		if (getResult() == true) {
			formula.required(rootNode, true);
		}
		
		return rootNode;
	}

	@Override
	public IDecisionBranch repair() {
		formula.evaluate(IScopeRecorder.DUMMY, false);
		
		if (getResult() != true) {
			IDecisionBranch repairTree = createRootRepairDecision();
			formula.repair(repairTree, true);
			return repairTree;
		} else {
			return new Alternative();
		}
	}
	
	protected IDecisionBranch createRootRepairDecision() {
		IDecisionBranch repairTreeRoot = new Alternative();
		
		// Repair which deletes the root element:
		if (getContext().eContainmentFeature() != null) {
			if (getContext().eContainmentFeature().getEOpposite() != null) {
				// Use container reference:
				repairTreeRoot.appendChildDecisions(new RepairAction(
						RepairType.DELETE, getContext(),  getContext().eContainmentFeature().getEOpposite()));
			} else {
				// Use containment reference (as cross-reference):
				repairTreeRoot.appendChildDecisions(new RepairAction(
						RepairType.DELETE, getContext(),  getContext().eContainmentFeature()));
			}
		}
		
		return repairTreeRoot;
	}
	
	@Override
	public boolean getResult() {
		return formula.getResult();
	}

	@Override
	public EClass getContextType() {
		return contextType;
	}

	@Override
	public void setContextType(EClass contextType) {
		this.contextType = contextType;
	}

	@Override
	public EObject getContext() {
		return (EObject) context.getValue();
	}

	@Override
	public void setContext(EObject contextElement) {
		this.context.assign(contextElement);
	}

	@Override
	public Formula getFormula() {
		return formula;
	}

	@Override
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
}
