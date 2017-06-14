/**
 */
package org.sidiff.repair.historymodel;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getValidationErrors <em>Validation Errors</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getId2Element <em>Id2 Element</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getModelURI <em>Model URI</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.Version#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Validation Errors</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.historymodel.ValidationError}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Errors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Errors</em>' containment reference list.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_ValidationErrors()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValidationError> getValidationErrors();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.Version#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id2 Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id2 Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id2 Element</em>' attribute.
	 * @see #setId2Element(Map)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_Id2Element()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, EObject> getId2Element();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.Version#getId2Element <em>Id2 Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id2 Element</em>' attribute.
	 * @see #getId2Element()
	 * @generated
	 */
	void setId2Element(Map<String, EObject> value);

	/**
	 * Returns the value of the '<em><b>Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model URI</em>' attribute.
	 * @see #setModelURI(String)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_ModelURI()
	 * @model
	 * @generated
	 */
	String getModelURI();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.Version#getModelURI <em>Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model URI</em>' attribute.
	 * @see #getModelURI()
	 * @generated
	 */
	void setModelURI(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(Resource)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_Model()
	 * @model dataType="org.sidiff.repair.historymodel.Resource" transient="true" derived="true"
	 * @generated
	 */
	Resource getModel();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.Version#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Resource value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"UNKNOWN"</code>.
	 * The literals are from the enumeration {@link org.sidiff.repair.historymodel.ModelStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.sidiff.repair.historymodel.ModelStatus
	 * @see #setStatus(ModelStatus)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getVersion_Status()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	ModelStatus getStatus();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.Version#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.sidiff.repair.historymodel.ModelStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ModelStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getElement(String id);

} // Version
