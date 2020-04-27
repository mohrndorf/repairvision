/**
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Closure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure#getElement <em>Element</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getGetClosure()
 * @model
 * @generated
 */
public interface GetClosure extends Term
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getGetClosure_Element()
   * @model containment="true"
   * @generated
   */
  Term getElement();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(Term value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(EStructuralFeature)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getGetClosure_Feature()
   * @model
   * @generated
   */
  EStructuralFeature getFeature();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(EStructuralFeature value);

} // GetClosure
