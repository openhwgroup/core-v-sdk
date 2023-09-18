/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.ARCEmulatorType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.TargetVoltageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ARC Emulator Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.ARCEmulatorTypeImpl#getTargetVoltage <em>Target Voltage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ARCEmulatorTypeImpl extends MinimalEObjectImpl.Container implements ARCEmulatorType {
	/**
	 * The cached value of the '{@link #getTargetVoltage() <em>Target Voltage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVoltage()
	 * @generated
	 * @ordered
	 */
	protected TargetVoltageType targetVoltage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ARCEmulatorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.ARC_EMULATOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetVoltageType getTargetVoltage() {
		return targetVoltage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetVoltage(TargetVoltageType newTargetVoltage, NotificationChain msgs) {
		TargetVoltageType oldTargetVoltage = targetVoltage;
		targetVoltage = newTargetVoltage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE, oldTargetVoltage, newTargetVoltage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetVoltage(TargetVoltageType newTargetVoltage) {
		if (newTargetVoltage != targetVoltage) {
			NotificationChain msgs = null;
			if (targetVoltage != null)
				msgs = ((InternalEObject)targetVoltage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE, null, msgs);
			if (newTargetVoltage != null)
				msgs = ((InternalEObject)newTargetVoltage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE, null, msgs);
			msgs = basicSetTargetVoltage(newTargetVoltage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE, newTargetVoltage, newTargetVoltage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE:
				return basicSetTargetVoltage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE:
				return getTargetVoltage();
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
			case devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE:
				setTargetVoltage((TargetVoltageType)newValue);
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
			case devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE:
				setTargetVoltage((TargetVoltageType)null);
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
			case devicesPackage.ARC_EMULATOR_TYPE__TARGET_VOLTAGE:
				return targetVoltage != null;
		}
		return super.eIsSet(featureID);
	}

} //ARCEmulatorTypeImpl
