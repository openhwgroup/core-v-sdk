/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDMAP Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.MDMAPType#getBaseAddress <em>Base Address</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getMDMAPType()
 * @model extendedMetaData="name='MDMAP_._type' kind='empty'"
 * @generated
 */
public interface MDMAPType extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Address</em>' attribute.
	 * @see #setBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getMDMAPType_BaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='BaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.MDMAPType#getBaseAddress <em>Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Address</em>' attribute.
	 * @see #getBaseAddress()
	 * @generated
	 */
	void setBaseAddress(String value);

} // MDMAPType
