/**
 */
package org.sidiff.historymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.historymodel.HistoryModelFactory
 * @model kind="package"
 * @generated
 */
public interface HistoryModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "historymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/history/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "historymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HistoryModelPackage eINSTANCE = org.sidiff.historymodel.impl.HistoryModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.HistoryImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getHistory()
	 * @generated
	 */
	int HISTORY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__VERSIONS = 1;

	/**
	 * The feature id for the '<em><b>All Validation Errors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__ALL_VALIDATION_ERRORS = 2;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Precessor Revisions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_PRECESSOR_REVISIONS__VERSION = 0;

	/**
	 * The operation id for the '<em>Get Successor Revisions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_SUCCESSOR_REVISIONS__VERSION = 1;

	/**
	 * The operation id for the '<em>Get Validation Errors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN = 2;

	/**
	 * The operation id for the '<em>Get Unique Validation Errors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY___GET_UNIQUE_VALIDATION_ERRORS = 3;

	/**
	 * The number of operations of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.VersionImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 1;

	/**
	 * The feature id for the '<em><b>Validation Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__VALIDATION_ERRORS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL_URI = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MODEL = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Repository Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__REPOSITORY_VERSION = 5;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION___GET_ELEMENT__STRING = 0;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.ValidationErrorImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getValidationError()
	 * @generated
	 */
	int VALIDATION_ERROR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Introduced In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INTRODUCED_IN = 1;

	/**
	 * The feature id for the '<em><b>Resolved In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__RESOLVED_IN = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SEVERITY = 5;

	/**
	 * The feature id for the '<em><b>Introduced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INTRODUCED = 6;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__RESOLVED = 7;

	/**
	 * The feature id for the '<em><b>Prec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__PREC = 8;

	/**
	 * The feature id for the '<em><b>Succ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__SUCC = 9;

	/**
	 * The feature id for the '<em><b>Invalid Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__INVALID_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__CONTEXT = 11;

	/**
	 * The feature id for the '<em><b>Resolved By Undo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__RESOLVED_BY_UNDO = 12;

	/**
	 * The feature id for the '<em><b>Change Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR__CHANGE_SETS = 13;

	/**
	 * The number of structural features of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Validation Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_ERROR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.impl.ChangeSetImpl <em>Change Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.impl.ChangeSetImpl
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getChangeSet()
	 * @generated
	 */
	int CHANGE_SET = 3;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__CHANGES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET__NAME = 1;

	/**
	 * The number of structural features of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.ValidationSeverity <em>Validation Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.ValidationSeverity
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getValidationSeverity()
	 * @generated
	 */
	int VALIDATION_SEVERITY = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.historymodel.ModelStatus
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
	 * @generated
	 */
	int MODEL_STATUS = 5;

	/**
	 * The meta object id for the '<em>Resource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 6;

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see org.sidiff.historymodel.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.History#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.History#getName()
	 * @see #getHistory()
	 * @generated
	 */
	EAttribute getHistory_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.History#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.sidiff.historymodel.History#getVersions()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_Versions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.historymodel.History#getAllValidationErrors <em>All Validation Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Validation Errors</em>'.
	 * @see org.sidiff.historymodel.History#getAllValidationErrors()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_AllValidationErrors();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getPrecessorRevisions(org.sidiff.historymodel.Version) <em>Get Precessor Revisions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Precessor Revisions</em>' operation.
	 * @see org.sidiff.historymodel.History#getPrecessorRevisions(org.sidiff.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetPrecessorRevisions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getSuccessorRevisions(org.sidiff.historymodel.Version) <em>Get Successor Revisions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Successor Revisions</em>' operation.
	 * @see org.sidiff.historymodel.History#getSuccessorRevisions(org.sidiff.historymodel.Version)
	 * @generated
	 */
	EOperation getHistory__GetSuccessorRevisions__Version();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getValidationErrors(boolean, boolean) <em>Get Validation Errors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Validation Errors</em>' operation.
	 * @see org.sidiff.historymodel.History#getValidationErrors(boolean, boolean)
	 * @generated
	 */
	EOperation getHistory__GetValidationErrors__boolean_boolean();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.History#getUniqueValidationErrors() <em>Get Unique Validation Errors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Unique Validation Errors</em>' operation.
	 * @see org.sidiff.historymodel.History#getUniqueValidationErrors()
	 * @generated
	 */
	EOperation getHistory__GetUniqueValidationErrors();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.sidiff.historymodel.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.Version#getValidationErrors <em>Validation Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validation Errors</em>'.
	 * @see org.sidiff.historymodel.Version#getValidationErrors()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ValidationErrors();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.Version#getName()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getModelURI <em>Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model URI</em>'.
	 * @see org.sidiff.historymodel.Version#getModelURI()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_ModelURI();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see org.sidiff.historymodel.Version#getModel()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Model();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.sidiff.historymodel.Version#getStatus()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.Version#getRepositoryVersion <em>Repository Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Version</em>'.
	 * @see org.sidiff.historymodel.Version#getRepositoryVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_RepositoryVersion();

	/**
	 * Returns the meta object for the '{@link org.sidiff.historymodel.Version#getElement(java.lang.String) <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element</em>' operation.
	 * @see org.sidiff.historymodel.Version#getElement(java.lang.String)
	 * @generated
	 */
	EOperation getVersion__GetElement__String();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.ValidationError <em>Validation Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Error</em>'.
	 * @see org.sidiff.historymodel.ValidationError
	 * @generated
	 */
	EClass getValidationError();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getName()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Name();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.ValidationError#getIntroducedIn <em>Introduced In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Introduced In</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getIntroducedIn()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_IntroducedIn();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.ValidationError#getResolvedIn <em>Resolved In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved In</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getResolvedIn()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_ResolvedIn();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getMessage()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getSource()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getSeverity()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#isIntroduced <em>Introduced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Introduced</em>'.
	 * @see org.sidiff.historymodel.ValidationError#isIntroduced()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Introduced();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.historymodel.ValidationError#isResolved()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_Resolved();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.ValidationError#getPrec <em>Prec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prec</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getPrec()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Prec();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.ValidationError#getSucc <em>Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Succ</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getSucc()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Succ();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.historymodel.ValidationError#getInvalidElement <em>Invalid Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invalid Element</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getInvalidElement()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_InvalidElement();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.historymodel.ValidationError#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getContext()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ValidationError#isResolvedByUndo <em>Resolved By Undo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved By Undo</em>'.
	 * @see org.sidiff.historymodel.ValidationError#isResolvedByUndo()
	 * @see #getValidationError()
	 * @generated
	 */
	EAttribute getValidationError_ResolvedByUndo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.ValidationError#getChangeSets <em>Change Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Sets</em>'.
	 * @see org.sidiff.historymodel.ValidationError#getChangeSets()
	 * @see #getValidationError()
	 * @generated
	 */
	EReference getValidationError_ChangeSets();

	/**
	 * Returns the meta object for class '{@link org.sidiff.historymodel.ChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Set</em>'.
	 * @see org.sidiff.historymodel.ChangeSet
	 * @generated
	 */
	EClass getChangeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.historymodel.ChangeSet#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changes</em>'.
	 * @see org.sidiff.historymodel.ChangeSet#getChanges()
	 * @see #getChangeSet()
	 * @generated
	 */
	EReference getChangeSet_Changes();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.historymodel.ChangeSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.historymodel.ChangeSet#getName()
	 * @see #getChangeSet()
	 * @generated
	 */
	EAttribute getChangeSet_Name();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.historymodel.ValidationSeverity <em>Validation Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validation Severity</em>'.
	 * @see org.sidiff.historymodel.ValidationSeverity
	 * @generated
	 */
	EEnum getValidationSeverity();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Status</em>'.
	 * @see org.sidiff.historymodel.ModelStatus
	 * @generated
	 */
	EEnum getModelStatus();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource</em>'.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @model instanceClass="org.eclipse.emf.ecore.resource.Resource"
	 * @generated
	 */
	EDataType getResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HistoryModelFactory getHistoryModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.HistoryImpl <em>History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.HistoryImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getHistory()
		 * @generated
		 */
		EClass HISTORY = eINSTANCE.getHistory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HISTORY__NAME = eINSTANCE.getHistory_Name();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__VERSIONS = eINSTANCE.getHistory_Versions();

		/**
		 * The meta object literal for the '<em><b>All Validation Errors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__ALL_VALIDATION_ERRORS = eINSTANCE.getHistory_AllValidationErrors();

		/**
		 * The meta object literal for the '<em><b>Get Precessor Revisions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_PRECESSOR_REVISIONS__VERSION = eINSTANCE.getHistory__GetPrecessorRevisions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Successor Revisions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_SUCCESSOR_REVISIONS__VERSION = eINSTANCE.getHistory__GetSuccessorRevisions__Version();

		/**
		 * The meta object literal for the '<em><b>Get Validation Errors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN = eINSTANCE.getHistory__GetValidationErrors__boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Get Unique Validation Errors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HISTORY___GET_UNIQUE_VALIDATION_ERRORS = eINSTANCE.getHistory__GetUniqueValidationErrors();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.VersionImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Validation Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__VALIDATION_ERRORS = eINSTANCE.getVersion_ValidationErrors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__NAME = eINSTANCE.getVersion_Name();

		/**
		 * The meta object literal for the '<em><b>Model URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MODEL_URI = eINSTANCE.getVersion_ModelURI();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MODEL = eINSTANCE.getVersion_Model();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__STATUS = eINSTANCE.getVersion_Status();

		/**
		 * The meta object literal for the '<em><b>Repository Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__REPOSITORY_VERSION = eINSTANCE.getVersion_RepositoryVersion();

		/**
		 * The meta object literal for the '<em><b>Get Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERSION___GET_ELEMENT__STRING = eINSTANCE.getVersion__GetElement__String();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.ValidationErrorImpl <em>Validation Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.ValidationErrorImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getValidationError()
		 * @generated
		 */
		EClass VALIDATION_ERROR = eINSTANCE.getValidationError();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__NAME = eINSTANCE.getValidationError_Name();

		/**
		 * The meta object literal for the '<em><b>Introduced In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__INTRODUCED_IN = eINSTANCE.getValidationError_IntroducedIn();

		/**
		 * The meta object literal for the '<em><b>Resolved In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__RESOLVED_IN = eINSTANCE.getValidationError_ResolvedIn();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__MESSAGE = eINSTANCE.getValidationError_Message();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__SOURCE = eINSTANCE.getValidationError_Source();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__SEVERITY = eINSTANCE.getValidationError_Severity();

		/**
		 * The meta object literal for the '<em><b>Introduced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__INTRODUCED = eINSTANCE.getValidationError_Introduced();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__RESOLVED = eINSTANCE.getValidationError_Resolved();

		/**
		 * The meta object literal for the '<em><b>Prec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__PREC = eINSTANCE.getValidationError_Prec();

		/**
		 * The meta object literal for the '<em><b>Succ</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__SUCC = eINSTANCE.getValidationError_Succ();

		/**
		 * The meta object literal for the '<em><b>Invalid Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__INVALID_ELEMENT = eINSTANCE.getValidationError_InvalidElement();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__CONTEXT = eINSTANCE.getValidationError_Context();

		/**
		 * The meta object literal for the '<em><b>Resolved By Undo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_ERROR__RESOLVED_BY_UNDO = eINSTANCE.getValidationError_ResolvedByUndo();

		/**
		 * The meta object literal for the '<em><b>Change Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_ERROR__CHANGE_SETS = eINSTANCE.getValidationError_ChangeSets();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.impl.ChangeSetImpl <em>Change Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.impl.ChangeSetImpl
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getChangeSet()
		 * @generated
		 */
		EClass CHANGE_SET = eINSTANCE.getChangeSet();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_SET__CHANGES = eINSTANCE.getChangeSet_Changes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_SET__NAME = eINSTANCE.getChangeSet_Name();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.ValidationSeverity <em>Validation Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.ValidationSeverity
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getValidationSeverity()
		 * @generated
		 */
		EEnum VALIDATION_SEVERITY = eINSTANCE.getValidationSeverity();

		/**
		 * The meta object literal for the '{@link org.sidiff.historymodel.ModelStatus <em>Model Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.historymodel.ModelStatus
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getModelStatus()
		 * @generated
		 */
		EEnum MODEL_STATUS = eINSTANCE.getModelStatus();

		/**
		 * The meta object literal for the '<em>Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.sidiff.historymodel.impl.HistoryModelPackageImpl#getResource()
		 * @generated
		 */
		EDataType RESOURCE = eINSTANCE.getResource();

	}

} //HistoryModelPackage
