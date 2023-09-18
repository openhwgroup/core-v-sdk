/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Voltage Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.TargetVoltageType#getSupplyType <em>Supply Type</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getTargetVoltageType()
 * @model extendedMetaData="name='TargetVoltage_._type' kind='empty'"
 * @generated
 */
public interface TargetVoltageType extends EObject {
	/**
	 * Returns the value of the '<em><b>Supply Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supply Type</em>' attribute.
	 * @see #setSupplyType(String)
	 * @see devicesPackage.DevicesPackage#getTargetVoltageType_SupplyType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='SupplyType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSupplyType();

	/**
	 * Sets the value of the '{@link Devices.TargetVoltageType#getSupplyType <em>Supply Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supply Type</em>' attribute.
	 * @see #getSupplyType()
	 * @generated
	 */
	void setSupplyType(String value);

} // TargetVoltageType
