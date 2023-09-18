/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARC Emulator Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.ARCEmulatorType#getTargetVoltage <em>Target Voltage</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getARCEmulatorType()
 * @model extendedMetaData="name='ARCEmulator_._type' kind='elementOnly'"
 * @generated
 */
public interface ARCEmulatorType extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Voltage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Voltage</em>' containment reference.
	 * @see #setTargetVoltage(TargetVoltageType)
	 * @see devicesPackage.DevicesPackage#getARCEmulatorType_TargetVoltage()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='TargetVoltage' namespace='##targetNamespace'"
	 * @generated
	 */
	TargetVoltageType getTargetVoltage();

	/**
	 * Sets the value of the '{@link Devices.ARCEmulatorType#getTargetVoltage <em>Target Voltage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Voltage</em>' containment reference.
	 * @see #getTargetVoltage()
	 * @generated
	 */
	void setTargetVoltage(TargetVoltageType value);

} // ARCEmulatorType
