/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.VJTAGType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VJTAG Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.VJTAGTypeImpl#getNodeIndex <em>Node Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VJTAGTypeImpl extends MinimalEObjectImpl.Container implements VJTAGType {
	/**
	 * The default value of the '{@link #getNodeIndex() <em>Node Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short NODE_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNodeIndex() <em>Node Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeIndex()
	 * @generated
	 * @ordered
	 */
	protected short nodeIndex = NODE_INDEX_EDEFAULT;

	/**
	 * This is true if the Node Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nodeIndexESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VJTAGTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.VJTAG_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getNodeIndex() {
		return nodeIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeIndex(short newNodeIndex) {
		short oldNodeIndex = nodeIndex;
		nodeIndex = newNodeIndex;
		boolean oldNodeIndexESet = nodeIndexESet;
		nodeIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.VJTAG_TYPE__NODE_INDEX, oldNodeIndex, nodeIndex, !oldNodeIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNodeIndex() {
		short oldNodeIndex = nodeIndex;
		boolean oldNodeIndexESet = nodeIndexESet;
		nodeIndex = NODE_INDEX_EDEFAULT;
		nodeIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.VJTAG_TYPE__NODE_INDEX, oldNodeIndex, NODE_INDEX_EDEFAULT, oldNodeIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNodeIndex() {
		return nodeIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.VJTAG_TYPE__NODE_INDEX:
				return getNodeIndex();
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
			case devicesPackage.VJTAG_TYPE__NODE_INDEX:
				setNodeIndex((Short)newValue);
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
			case devicesPackage.VJTAG_TYPE__NODE_INDEX:
				unsetNodeIndex();
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
			case devicesPackage.VJTAG_TYPE__NODE_INDEX:
				return isSetNodeIndex();
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
		result.append(" (nodeIndex: ");
		if (nodeIndexESet) result.append(nodeIndex); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //VJTAGTypeImpl
