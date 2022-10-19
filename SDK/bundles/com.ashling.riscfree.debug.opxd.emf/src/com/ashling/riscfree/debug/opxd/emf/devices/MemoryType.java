/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.MemoryType#getMemArea <em>Mem Area</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getMemoryType()
 * @model extendedMetaData="name='Memory_._type' kind='elementOnly'"
 * @generated
 */
public interface MemoryType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mem Area</b></em>' containment reference list.
	 * The list contents are of type {@link Devices.MemAreaType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mem Area</em>' containment reference list.
	 * @see devicesPackage.DevicesPackage#getMemoryType_MemArea()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='MemArea' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<MemAreaType> getMemArea();

} // MemoryType
