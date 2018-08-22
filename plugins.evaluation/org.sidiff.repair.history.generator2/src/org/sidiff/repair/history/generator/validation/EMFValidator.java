package org.sidiff.repair.history.generator.validation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.sidiff.history.analysis.validation.BasicValidation;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;

/**
 * Delegates the validation
 * 
 * to the EMF validation framework.
 * 
 * @author kehrer, cpietsch
 */
public class EMFValidator extends BasicValidation {
	
	private static final int DOCTYPE_UML = 1;
	
	private static final int DOCTYPE_ECORE = 2;
	
	private int docType = 0;
	
	@Override
	public Collection<Problem> validate(Resource resource) {
		docType = getDocumentTyp(resource);
		assert (docType != 0);
		
		Collection<Problem> inconsistencies = new ArrayList<Problem>();

		for (EObject rootElement : resource.getContents()) {
			validate(rootElement, inconsistencies);
		}
		
		return inconsistencies;
	}
	
	private void validate(EObject rootElement, Collection<Problem> inconsistencies) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootElement);
		
		for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
			if ((childDiagnostic.getSeverity() == Diagnostic.ERROR)
					|| (childDiagnostic.getSeverity() == Diagnostic.WARNING)) {
				
				Problem validationError = HistoryModelFactory.eINSTANCE.createProblem();
				validationError.setMessage(childDiagnostic.getMessage());
				
				if (childDiagnostic.getSeverity() == Diagnostic.ERROR) {
					validationError.setSeverity(ProblemSeverity.ERROR);
				} else if (childDiagnostic.getSeverity() == Diagnostic.WARNING) {
					validationError.setSeverity(ProblemSeverity.WARNING);
				} else {
					validationError.setSeverity(ProblemSeverity.UNKNOWN);
				}
				
				String name = childDiagnostic.getMessage().replaceAll("'.*?'", "").trim();
				name = name.replaceAll("\\s.[^\\s]*@.*?\\s", "");
				
				while (name.contains(" ")) {
					int index = name.indexOf(" ");
					name = name.replace(name.substring(index, index + 2),
							name.substring(index + 1, index + 2).toUpperCase());
				}
				name = name.replaceAll("[^\\p{Alpha}]", "");
				validationError.setName(name);
				
				for (Object obj : childDiagnostic.getData()) {
					if (obj instanceof EObject) {
						validationError.getInvalidElements().add((EObject) obj);
					}
				}
				
				validationError.setContextElement(getContextElement(validationError));
				inconsistencies.add(validationError);
			}
		}
	}
	
	private int getDocumentTyp(Resource resource) {
		if (resource instanceof UMLResource) {
			return DOCTYPE_UML;
		}
		if (resource.getURI().lastSegment().endsWith("ecore")) {
			return DOCTYPE_ECORE;
		}
		return 0;
	}
	
	@Override
	public boolean matchValidationError(Problem validationErrorA, Problem validationErrorB) {
		return super.matchValidationError(validationErrorA, validationErrorB);
	}
	
	@Override
	public EObject getContextElement(Problem validationError) {
		
		if (validationError.getContextElement() == null) {
			
			// Only one invalid element:
			EObject context = validationError.getInvalidElements().get(0);
			
			// Filter meta-features:
			for (EObject invalidElement : validationError.getInvalidElements()) {
				if ((invalidElement != context) && (context.eResource() == invalidElement.eResource())) {
					context = null;
					break;
				}
			}
			
			if (context != null) {
				return context;
			}
			
			// Configure context element:
			if (docType == DOCTYPE_ECORE) {
				switch (validationError.getName()) {
					case "AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated":
						return validationError.getInvalidElements().get(0); // EReference containment
					case "ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature":
						return validationError.getInvalidElements().get(1); // EOperation operation
					case "ThereMayNotBeTwoClassifiersNamed":
						return validationError.getInvalidElements().get(1); // EClassifier duplicated
					case "TheGenericTypeIsNotAValidSubstitutionForTypeParameter":
						return validationError.getInvalidElements().get(1); // EGenericType typeSubstitution
					case "TheFeaturesAndCannotBothBeIDs":
						return validationError.getInvalidElements().get(1); // EAttribute duplicatedID
					case "ThereMayNotBeTwoFeaturesNamed":
						return validationError.getInvalidElements().get(2); // EStructuralFeature duplicated
					case "ThereShouldNotBeAFeatureNamedAsWellAFeatureNamed":
						return validationError.getInvalidElements().get(1); // EStructuralFeature duplicated (e.g. a, A, A_)
					case "ThereMayNotBeTwoOperationsAndWithTheSameSignature":
						return validationError.getInvalidElements().get(1); // EOperation duplicated
					case "ThereMayNotBeTwoEnumeratorsNamed":
						return validationError.getInvalidElements().get(1); // EEnum duplicated
					case "ThereShouldNotBeAnEnumeratorNamedAsWellAnEnumeratorNamed":
						return validationError.getInvalidElements().get(1); // EEnum duplicated (e.g. a, A, A_)
					case "ThereMayNotBeTwoEnumeratorsWithLiteralValue":
						return validationError.getInvalidElements().get(1); // EEnumLiteral duplicated
					case "ThereMayNotBeTwoParametersNamed":
						return validationError.getInvalidElements().get(1); // EParameter duplicated
					case "ThereMayNotBeTwoTypeParametersNamed":
						return validationError.getInvalidElements().get(1); // ETypeParameter duplicated
					case "ThereMayNotBeTwoPackagesNamed":
						return validationError.getInvalidElements().get(1); // EPackage duplicated
					case "ThereMayNotBeTwoPackagesWithNamespaceURI":
						return validationError.getInvalidElements().get(0); // EPackage duplicated
					case "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne":
						return validationError.getInvalidElements().get(0); // EReference reference
					case "TheOppositeMustBeAFeatureOfTheReferencesType":
						return validationError.getInvalidElements().get(0); // EReference reference
					case "TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving":
						return validationError.getInvalidElements().get(0); // EReference reference
					case "TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference":
						return validationError.getInvalidElements().get(0); // EReference reference
					case "TheGenericSuperTypesAtIndexAndMustNotBeDuplicates":
						return validationError.getInvalidElements().get(1); // EGenericType duplicated
					case "TheGenericSuperTypesInstantiateInconsistently":
						return validationError.getInvalidElements().get(1); // EGenericType inconsistent
					
					case "TheFeatureOfContainsAnUnresolvedProxy":
						return validationError.getInvalidElements().get(0); // ?
					case "TheFeatureHasAMapEntryAtIndexWithAKeyThatCollidesWithThatOfTheMapEntryAtIndex":
						return validationError.getInvalidElements().get(0); // ?
					case "TheKeyMustBeFeatureOfTheReferencesType":
						return validationError.getInvalidElements().get(0); // ?
					default:
						throw new RuntimeException(
								"Please configure the context element of the consistency rule!\n" 
										+ printProblem(validationError));
				}	
			}
			
			return validationError.getInvalidElements().get(0);
		} else {
			return validationError.getContextElement();
		}
	}
	
	private String printProblem(Problem validationError) {
		StringBuffer string = new StringBuffer();
		string.append(validationError.getName() + ":\n");
		
		for (EObject invalidElement : validationError.getInvalidElements()) {
			string.append(getObjectID(invalidElement) + ": ");
			string.append(invalidElement + "\n");
		}
		
		return string.toString();
	}
}
