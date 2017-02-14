/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IRepair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.IRepair#getRepairOperation <em>Repair Operation</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getIRepair()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IRepair extends EObject {
	/**
	 * Returns the value of the '<em><b>Repair Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.RepairOperation#getRepairs <em>Repairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Operation</em>' container reference.
	 * @see #setRepairOperation(RepairOperation)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getIRepair_RepairOperation()
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getRepairs
	 * @model opposite="repairs" transient="false"
	 * @generated
	 */
	RepairOperation getRepairOperation();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.IRepair#getRepairOperation <em>Repair Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair Operation</em>' container reference.
	 * @see #getRepairOperation()
	 * @generated
	 */
	void setRepairOperation(RepairOperation value);

} // IRepair
