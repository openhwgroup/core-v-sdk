/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tap Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.TapType#getRefid <em>Refid</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getTapType()
 * @model extendedMetaData="name='Tap_._type' kind='empty'"
 * @generated
 */
public interface TapType extends EObject {
	/**
	 * Returns the value of the '<em><b>Refid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refid</em>' attribute.
	 * @see #isSetRefid()
	 * @see #unsetRefid()
	 * @see #setRefid(short)
	 * @see devicesPackage.DevicesPackage#getTapType_Refid()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='attribute' name='refid' namespace='##targetNamespace'"
	 * @generated
	 */
	short getRefid();

	/**
	 * Sets the value of the '{@link Devices.TapType#getRefid <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refid</em>' attribute.
	 * @see #isSetRefid()
	 * @see #unsetRefid()
	 * @see #getRefid()
	 * @generated
	 */
	void setRefid(short value);

	/**
	 * Unsets the value of the '{@link Devices.TapType#getRefid <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefid()
	 * @see #getRefid()
	 * @see #setRefid(short)
	 * @generated
	 */
	void unsetRefid();

	/**
	 * Returns whether the value of the '{@link Devices.TapType#getRefid <em>Refid</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Refid</em>' attribute is set.
	 * @see #unsetRefid()
	 * @see #getRefid()
	 * @see #setRefid(short)
	 * @generated
	 */
	boolean isSetRefid();

} // TapType
