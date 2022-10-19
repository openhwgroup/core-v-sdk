/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Info Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.CoreInfoType#getCore <em>Core</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getCoreInfoType()
 * @model extendedMetaData="name='CoreInfo_._type' kind='elementOnly'"
 * @generated
 */
public interface CoreInfoType extends EObject {
	/**
	 * Returns the value of the '<em><b>Core</b></em>' containment reference list.
	 * The list contents are of type {@link Devices.CoreType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Core</em>' containment reference list.
	 * @see devicesPackage.DevicesPackage#getCoreInfoType_Core()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Core' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CoreType> getCore();

} // CoreInfoType
