/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGScanChainType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JTAG Scan Chain Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.JTAGScanChainTypeImpl#getTap <em>Tap</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JTAGScanChainTypeImpl extends MinimalEObjectImpl.Container implements JTAGScanChainType {
	/**
	 * The cached value of the '{@link #getTap() <em>Tap</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTap()
	 * @generated
	 * @ordered
	 */
	protected EList<TapType1> tap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JTAGScanChainTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.JTAG_SCAN_CHAIN_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TapType1> getTap() {
		if (tap == null) {
			tap = new EObjectContainmentEList<TapType1>(TapType1.class, this, devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP);
		}
		return tap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP:
				return ((InternalEList<?>)getTap()).basicRemove(otherEnd, msgs);
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
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP:
				return getTap();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP:
				getTap().clear();
				getTap().addAll((Collection<? extends TapType1>)newValue);
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
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP:
				getTap().clear();
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
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE__TAP:
				return tap != null && !tap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JTAGScanChainTypeImpl
