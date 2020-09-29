/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.IndentBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indent Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl#getBricks <em>Bricks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndentBrickImpl extends BrickImpl implements IndentBrick {
	/**
	 * The default value of the '{@link #getBricks() <em>Bricks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected static final int BRICKS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getBricks() <em>Bricks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected int bricks = BRICKS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndentBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.INDENT_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBricks() {
		return bricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBricks(int newBricks) {
		int oldBricks = bricks;
		bricks = newBricks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.INDENT_BRICK__BRICKS, oldBricks, bricks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				return getBricks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				setBricks((Integer)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				setBricks(BRICKS_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				return bricks != BRICKS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bricks: ");
		result.append(bricks);
		result.append(')');
		return result.toString();
	}

} //IndentBrickImpl
