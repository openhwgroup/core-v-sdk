/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JTAG Scan Chain Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.JTAGScanChainType#getTap <em>Tap</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getJTAGScanChainType()
 * @model extendedMetaData="name='JTAGScanChain_._type' kind='elementOnly'"
 * @generated
 */
public interface JTAGScanChainType extends EObject {
	/**
	 * Returns the value of the '<em><b>Tap</b></em>' containment reference list.
	 * The list contents are of type {@link Devices.TapType1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tap</em>' containment reference list.
	 * @see devicesPackage.DevicesPackage#getJTAGScanChainType_Tap()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Tap' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TapType1> getTap();

} // JTAGScanChainType
