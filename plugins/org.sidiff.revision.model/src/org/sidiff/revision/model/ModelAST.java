package org.sidiff.revision.model;

import java.util.Iterator;

/**
 * A view on an abstract syntax tree (AST) of a model.
 * 
 * @author Manuel Ohrndorf
 */
public interface ModelAST {

	/**
	 * @param element A model element.
	 * @return The child elements of the given element in the abstract syntax tree.
	 */
	Iterator<? extends Object> children(Object element);

	/**
	 * @param element A model element.
	 * @return The container element of the given element in the abstract syntax
	 *         tree; or <code>null</code> if there is no parent model element.
	 */
	Object container(Object element);
}
