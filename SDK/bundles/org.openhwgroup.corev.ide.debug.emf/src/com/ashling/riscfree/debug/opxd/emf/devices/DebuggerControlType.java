/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debugger Control Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.DebuggerControlType#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getDebuggerControlType()
 * @model extendedMetaData="name='DebuggerControl_._type' kind='elementOnly'"
 * @generated
 */
public interface DebuggerControlType extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Jtag Frequency Khz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Jtag Frequency Khz</em>' attribute.
	 * @see #isSetMaxJtagFrequencyKhz()
	 * @see #unsetMaxJtagFrequencyKhz()
	 * @see #setMaxJtagFrequencyKhz(long)
	 * @see devicesPackage.DevicesPackage#getDebuggerControlType_MaxJtagFrequencyKhz()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='element' name='MaxJtagFrequencyKhz' namespace='##targetNamespace'"
	 * @generated
	 */
	long getMaxJtagFrequencyKhz();

	/**
	 * Sets the value of the '{@link Devices.DebuggerControlType#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Jtag Frequency Khz</em>' attribute.
	 * @see #isSetMaxJtagFrequencyKhz()
	 * @see #unsetMaxJtagFrequencyKhz()
	 * @see #getMaxJtagFrequencyKhz()
	 * @generated
	 */
	void setMaxJtagFrequencyKhz(long value);

	/**
	 * Unsets the value of the '{@link Devices.DebuggerControlType#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxJtagFrequencyKhz()
	 * @see #getMaxJtagFrequencyKhz()
	 * @see #setMaxJtagFrequencyKhz(long)
	 * @generated
	 */
	void unsetMaxJtagFrequencyKhz();

	/**
	 * Returns whether the value of the '{@link Devices.DebuggerControlType#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Jtag Frequency Khz</em>' attribute is set.
	 * @see #unsetMaxJtagFrequencyKhz()
	 * @see #getMaxJtagFrequencyKhz()
	 * @see #setMaxJtagFrequencyKhz(long)
	 * @generated
	 */
	boolean isSetMaxJtagFrequencyKhz();

} // DebuggerControlType
