package org.sidiff.csp.solver;

public interface IVariable<R, D> {

	R getSubject();
	
	void setCSP(IConstraintSatisfactionProblem<R, D> csp);
	
	int getIndex();

	void setIndex(int index);

	boolean isRemovable();

	void setRemovable(boolean removable);

	IDomain<D> getDomain();

	D getValue();

	boolean isAssignable();

	boolean assign(D value);

	void free();
	
	boolean applyRestrictions();

	void undoRestrictions();
	
}