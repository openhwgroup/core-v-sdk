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
import com.ashling.riscfree.debug.opxd.emf.devices.MemAreaType;
import com.ashling.riscfree.debug.opxd.emf.devices.MemoryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.MemoryTypeImpl#getMemArea <em>Mem Area</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemoryTypeImpl extends MinimalEObjectImpl.Container implements MemoryType {
	/**
	 * The cached value of the '{@link #getMemArea() <em>Mem Area</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemArea()
	 * @generated
	 * @ordered
	 */
	protected EList<MemAreaType> memArea;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.MEMORY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemAreaType> getMemArea() {
		if (memArea == null) {
			memArea = new EObjectContainmentEList<MemAreaType>(MemAreaType.class, this, devicesPackage.MEMORY_TYPE__MEM_AREA);
		}
		return memArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.MEMORY_TYPE__MEM_AREA:
				return ((InternalEList<?>)getMemArea()).basicRemove(otherEnd, msgs);
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
			case devicesPackage.MEMORY_TYPE__MEM_AREA:
				return getMemArea();
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
			case devicesPackage.MEMORY_TYPE__MEM_AREA:
				getMemArea().clear();
				getMemArea().addAll((Collection<? extends MemAreaType>)newValue);
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
			case devicesPackage.MEMORY_TYPE__MEM_AREA:
				getMemArea().clear();
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
			case devicesPackage.MEMORY_TYPE__MEM_AREA:
				return memArea != null && !memArea.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MemoryTypeImpl
