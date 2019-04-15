/**
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

/**
 * A sample validator interface for {@link org.sidiff.difference.symmetric.SymmetricDifference}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SymmetricDifferenceValidator {
	boolean validate();

	boolean validateChanges(EList<Change> value);
	boolean validateChangeSets(EList<SemanticChangeSet> value);
	boolean validateModelA(Resource value);
	boolean validateModelB(Resource value);
	boolean validateUriModelA(String value);
	boolean validateUriModelB(String value);
	boolean validateNotOverlappings(EList<SemanticChangeSet> value);
	boolean validateUnusedChangeSets(EList<SemanticChangeSet> value);
}