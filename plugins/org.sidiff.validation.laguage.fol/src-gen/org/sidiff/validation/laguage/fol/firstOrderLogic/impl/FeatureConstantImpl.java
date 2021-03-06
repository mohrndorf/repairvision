/**
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sidiff.validation.laguage.fol.firstOrderLogic.FeatureConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.FeatureConstantImpl#getConstant <em>Constant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureConstantImpl extends MinimalEObjectImpl.Container implements FeatureConstant
{
  /**
   * The cached value of the '{@link #getConstant() <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstant()
   * @generated
   * @ordered
   */
  protected EStructuralFeature constant;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureConstantImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FirstOrderLogicPackage.Literals.FEATURE_CONSTANT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EStructuralFeature getConstant()
  {
    if (constant != null && constant.eIsProxy())
    {
      InternalEObject oldConstant = (InternalEObject)constant;
      constant = (EStructuralFeature)eResolveProxy(oldConstant);
      if (constant != oldConstant)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT, oldConstant, constant));
      }
    }
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EStructuralFeature basicGetConstant()
  {
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConstant(EStructuralFeature newConstant)
  {
    EStructuralFeature oldConstant = constant;
    constant = newConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT, oldConstant, constant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT:
        if (resolve) return getConstant();
        return basicGetConstant();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT:
        setConstant((EStructuralFeature)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT:
        setConstant((EStructuralFeature)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.FEATURE_CONSTANT__CONSTANT:
        return constant != null;
    }
    return super.eIsSet(featureID);
  }

} //FeatureConstantImpl
