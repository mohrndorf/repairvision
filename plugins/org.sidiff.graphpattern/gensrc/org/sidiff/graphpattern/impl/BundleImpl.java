/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.BundleImpl#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.BundleImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.BundleImpl#getDomains <em>Domains</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BundleImpl extends PatternElementImpl implements Bundle {
	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<Pattern> patterns;

	/**
	 * The cached value of the '{@link #getProfiles() <em>Profiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfiles()
	 * @generated
	 * @ordered
	 */
	protected EList<Profile> profiles;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> domains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new EObjectContainmentEList<Pattern>(Pattern.class, this, GraphpatternPackage.BUNDLE__PATTERNS);
		}
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Profile> getProfiles() {
		if (profiles == null) {
			profiles = new EObjectResolvingEList<Profile>(Profile.class, this, GraphpatternPackage.BUNDLE__PROFILES);
		}
		return profiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getDomains() {
		if (domains == null) {
			domains = new EObjectResolvingEList<EPackage>(EPackage.class, this, GraphpatternPackage.BUNDLE__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.BUNDLE__PATTERNS:
				return ((InternalEList<?>)getPatterns()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.BUNDLE__PATTERNS:
				return getPatterns();
			case GraphpatternPackage.BUNDLE__PROFILES:
				return getProfiles();
			case GraphpatternPackage.BUNDLE__DOMAINS:
				return getDomains();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.BUNDLE__PATTERNS:
				getPatterns().clear();
				getPatterns().addAll((Collection<? extends Pattern>)newValue);
				return;
			case GraphpatternPackage.BUNDLE__PROFILES:
				getProfiles().clear();
				getProfiles().addAll((Collection<? extends Profile>)newValue);
				return;
			case GraphpatternPackage.BUNDLE__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends EPackage>)newValue);
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
			case GraphpatternPackage.BUNDLE__PATTERNS:
				getPatterns().clear();
				return;
			case GraphpatternPackage.BUNDLE__PROFILES:
				getProfiles().clear();
				return;
			case GraphpatternPackage.BUNDLE__DOMAINS:
				getDomains().clear();
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
			case GraphpatternPackage.BUNDLE__PATTERNS:
				return patterns != null && !patterns.isEmpty();
			case GraphpatternPackage.BUNDLE__PROFILES:
				return profiles != null && !profiles.isEmpty();
			case GraphpatternPackage.BUNDLE__DOMAINS:
				return domains != null && !domains.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BundleImpl
