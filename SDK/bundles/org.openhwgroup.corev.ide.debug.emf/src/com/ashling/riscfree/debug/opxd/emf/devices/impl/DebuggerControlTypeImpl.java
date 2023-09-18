/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.DebuggerControlType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debugger Control Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.DebuggerControlTypeImpl#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DebuggerControlTypeImpl extends MinimalEObjectImpl.Container implements DebuggerControlType {
	/**
	 * The default value of the '{@link #getMaxJtagFrequencyKhz() <em>Max Jtag Frequency Khz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJtagFrequencyKhz()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_JTAG_FREQUENCY_KHZ_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxJtagFrequencyKhz() <em>Max Jtag Frequency Khz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJtagFrequencyKhz()
	 * @generated
	 * @ordered
	 */
	protected long maxJtagFrequencyKhz = MAX_JTAG_FREQUENCY_KHZ_EDEFAULT;

	/**
	 * This is true if the Max Jtag Frequency Khz attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxJtagFrequencyKhzESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebuggerControlTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.DEBUGGER_CONTROL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxJtagFrequencyKhz() {
		return maxJtagFrequencyKhz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxJtagFrequencyKhz(long newMaxJtagFrequencyKhz) {
		long oldMaxJtagFrequencyKhz = maxJtagFrequencyKhz;
		maxJtagFrequencyKhz = newMaxJtagFrequencyKhz;
		boolean oldMaxJtagFrequencyKhzESet = maxJtagFrequencyKhzESet;
		maxJtagFrequencyKhzESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ, oldMaxJtagFrequencyKhz, maxJtagFrequencyKhz, !oldMaxJtagFrequencyKhzESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxJtagFrequencyKhz() {
		long oldMaxJtagFrequencyKhz = maxJtagFrequencyKhz;
		boolean oldMaxJtagFrequencyKhzESet = maxJtagFrequencyKhzESet;
		maxJtagFrequencyKhz = MAX_JTAG_FREQUENCY_KHZ_EDEFAULT;
		maxJtagFrequencyKhzESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ, oldMaxJtagFrequencyKhz, MAX_JTAG_FREQUENCY_KHZ_EDEFAULT, oldMaxJtagFrequencyKhzESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxJtagFrequencyKhz() {
		return maxJtagFrequencyKhzESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ:
				return getMaxJtagFrequencyKhz();
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
			case devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ:
				setMaxJtagFrequencyKhz((Long)newValue);
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
			case devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ:
				unsetMaxJtagFrequencyKhz();
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
			case devicesPackage.DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ:
				return isSetMaxJtagFrequencyKhz();
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
		result.append(" (maxJtagFrequencyKhz: ");
		if (maxJtagFrequencyKhzESet) result.append(maxJtagFrequencyKhz); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DebuggerControlTypeImpl
