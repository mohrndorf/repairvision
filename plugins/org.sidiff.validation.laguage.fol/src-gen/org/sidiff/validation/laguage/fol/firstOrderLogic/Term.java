/**
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getElement <em>Element</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getLeft <em>Left</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getRight <em>Right</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getString <em>String</em>}</li>
 * </ul>
 *
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends Formula
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm_Element()
   * @model containment="true"
   * @generated
   */
  Term getElement();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(Term value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' attribute.
   * @see #setFeature(String)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm_Feature()
   * @model
   * @generated
   */
  String getFeature();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getFeature <em>Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' attribute.
   * @see #getFeature()
   * @generated
   */
  void setFeature(String value);

  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm_Left()
   * @model containment="true"
   * @generated
   */
  Term getLeft();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Term value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm_Right()
   * @model containment="true"
   * @generated
   */
  Term getRight();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Term value);

  /**
   * Returns the value of the '<em><b>String</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' containment reference.
   * @see #setString(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getTerm_String()
   * @model containment="true"
   * @generated
   */
  Term getString();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Term#getString <em>String</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' containment reference.
   * @see #getString()
   * @generated
   */
  void setString(Term value);

} // Term
