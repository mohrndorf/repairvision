package org.sidiff.validation.constraint.library;

import java.util.List;

import org.sidiff.repair.validation.IConstraint;

public interface IConstraintLibrary {

	/**
	 * @return The document type of this constraint library.
	 */
	String getDocumentType();
	
	/**
	 * @return All constraints of this library.
	 */
	List<IConstraint> getConstraints();
	
	/**
	 * @param name
	 *            The identifier of a constraint.
	 * @return The corresponding constraint.
	 */
	IConstraint getConstraint(String name);
}
