/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.MDMAPType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDMAP Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.MDMAPTypeImpl#getBaseAddress <em>Base Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MDMAPTypeImpl extends MinimalEObjectImpl.Container implements MDMAPType {
	/**
	 * The default value of the '{@link #getBaseAddress() <em>Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseAddress() <em>Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String baseAddress = BASE_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MDMAPTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.MDMAP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseAddress() {
		return baseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseAddress(String newBaseAddress) {
		String oldBaseAddress = baseAddress;
		baseAddress = newBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.MDMAP_TYPE__BASE_ADDRESS, oldBaseAddress, baseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.MDMAP_TYPE__BASE_ADDRESS:
				return getBaseAddress();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case devicesPackage.MDMAP_TYPE__BASE_ADDRESS:
				setBaseAddress((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case devicesPackage.MDMAP_TYPE__BASE_ADDRESS:
				setBaseAddress(BASE_ADDRESS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case devicesPackage.MDMAP_TYPE__BASE_ADDRESS:
				return BASE_ADDRESS_EDEFAULT == null ? baseAddress != null : !BASE_ADDRESS_EDEFAULT.equals(baseAddress);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (baseAddress: ");
		result.append(baseAddress);
		result.append(')');
		return result.toString();
	}

} //MDMAPTypeImpl
