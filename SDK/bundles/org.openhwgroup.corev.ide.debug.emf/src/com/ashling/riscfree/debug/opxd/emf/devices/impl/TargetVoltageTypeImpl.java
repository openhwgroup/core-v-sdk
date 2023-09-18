/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.TargetVoltageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Voltage Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.TargetVoltageTypeImpl#getSupplyType <em>Supply Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetVoltageTypeImpl extends MinimalEObjectImpl.Container implements TargetVoltageType {
	/**
	 * The default value of the '{@link #getSupplyType() <em>Supply Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplyType()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPLY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSupplyType() <em>Supply Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplyType()
	 * @generated
	 * @ordered
	 */
	protected String supplyType = SUPPLY_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetVoltageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.TARGET_VOLTAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupplyType() {
		return supplyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplyType(String newSupplyType) {
		String oldSupplyType = supplyType;
		supplyType = newSupplyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.TARGET_VOLTAGE_TYPE__SUPPLY_TYPE, oldSupplyType, supplyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.TARGET_VOLTAGE_TYPE__SUPPLY_TYPE:
				return getSupplyType();
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
			case devicesPackage.TARGET_VOLTAGE_TYPE__SUPPLY_TYPE:
				setSupplyType((String)newValue);
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
			case devicesPackage.TARGET_VOLTAGE_TYPE__SUPPLY_TYPE:
				setSupplyType(SUPPLY_TYPE_EDEFAULT);
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
			case devicesPackage.TARGET_VOLTAGE_TYPE__SUPPLY_TYPE:
				return SUPPLY_TYPE_EDEFAULT == null ? supplyType != null : !SUPPLY_TYPE_EDEFAULT.equals(supplyType);
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
		result.append(" (supplyType: ");
		result.append(supplyType);
		result.append(')');
		return result.toString();
	}

} //TargetVoltageTypeImpl
