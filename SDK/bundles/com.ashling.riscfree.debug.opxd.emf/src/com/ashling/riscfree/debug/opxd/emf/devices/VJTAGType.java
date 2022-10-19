/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VJTAG Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.VJTAGType#getNodeIndex <em>Node Index</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getVJTAGType()
 * @model extendedMetaData="name='VJTAG_._type' kind='elementOnly'"
 * @generated
 */
public interface VJTAGType extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Index</em>' attribute.
	 * @see #isSetNodeIndex()
	 * @see #unsetNodeIndex()
	 * @see #setNodeIndex(short)
	 * @see devicesPackage.DevicesPackage#getVJTAGType_NodeIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='element' name='NodeIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getNodeIndex();

	/**
	 * Sets the value of the '{@link Devices.VJTAGType#getNodeIndex <em>Node Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Index</em>' attribute.
	 * @see #isSetNodeIndex()
	 * @see #unsetNodeIndex()
	 * @see #getNodeIndex()
	 * @generated
	 */
	void setNodeIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.VJTAGType#getNodeIndex <em>Node Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNodeIndex()
	 * @see #getNodeIndex()
	 * @see #setNodeIndex(short)
	 * @generated
	 */
	void unsetNodeIndex();

	/**
	 * Returns whether the value of the '{@link Devices.VJTAGType#getNodeIndex <em>Node Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Node Index</em>' attribute is set.
	 * @see #unsetNodeIndex()
	 * @see #getNodeIndex()
	 * @see #setNodeIndex(short)
	 * @generated
	 */
	boolean isSetNodeIndex();

} // VJTAGType
