/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tap Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.TapType1Impl#getIRlength <em>IRlength</em>}</li>
 *   <li>{@link Devices.impl.TapType1Impl#getBypassInst <em>Bypass Inst</em>}</li>
 *   <li>{@link Devices.impl.TapType1Impl#getId <em>Id</em>}</li>
 *   <li>{@link Devices.impl.TapType1Impl#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TapType1Impl extends MinimalEObjectImpl.Container implements TapType1 {
	/**
	 * The default value of the '{@link #getIRlength() <em>IRlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRlength()
	 * @generated
	 * @ordered
	 */
	protected static final short IRLENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIRlength() <em>IRlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRlength()
	 * @generated
	 * @ordered
	 */
	protected short iRlength = IRLENGTH_EDEFAULT;

	/**
	 * This is true if the IRlength attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean iRlengthESet;

	/**
	 * The default value of the '{@link #getBypassInst() <em>Bypass Inst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassInst()
	 * @generated
	 * @ordered
	 */
	protected static final String BYPASS_INST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBypassInst() <em>Bypass Inst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassInst()
	 * @generated
	 * @ordered
	 */
	protected String bypassInst = BYPASS_INST_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final short ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected short id = ID_EDEFAULT;

	/**
	 * This is true if the Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idESet;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final short NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected short number = NUMBER_EDEFAULT;

	/**
	 * This is true if the Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numberESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TapType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.TAP_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getIRlength() {
		return iRlength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIRlength(short newIRlength) {
		short oldIRlength = iRlength;
		iRlength = newIRlength;
		boolean oldIRlengthESet = iRlengthESet;
		iRlengthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.TAP_TYPE1__IRLENGTH, oldIRlength, iRlength, !oldIRlengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIRlength() {
		short oldIRlength = iRlength;
		boolean oldIRlengthESet = iRlengthESet;
		iRlength = IRLENGTH_EDEFAULT;
		iRlengthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.TAP_TYPE1__IRLENGTH, oldIRlength, IRLENGTH_EDEFAULT, oldIRlengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIRlength() {
		return iRlengthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBypassInst() {
		return bypassInst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBypassInst(String newBypassInst) {
		String oldBypassInst = bypassInst;
		bypassInst = newBypassInst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.TAP_TYPE1__BYPASS_INST, oldBypassInst, bypassInst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(short newId) {
		short oldId = id;
		id = newId;
		boolean oldIdESet = idESet;
		idESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.TAP_TYPE1__ID, oldId, id, !oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId() {
		short oldId = id;
		boolean oldIdESet = idESet;
		id = ID_EDEFAULT;
		idESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.TAP_TYPE1__ID, oldId, ID_EDEFAULT, oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId() {
		return idESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(short newNumber) {
		short oldNumber = number;
		number = newNumber;
		boolean oldNumberESet = numberESet;
		numberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.TAP_TYPE1__NUMBER, oldNumber, number, !oldNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumber() {
		short oldNumber = number;
		boolean oldNumberESet = numberESet;
		number = NUMBER_EDEFAULT;
		numberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.TAP_TYPE1__NUMBER, oldNumber, NUMBER_EDEFAULT, oldNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumber() {
		return numberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.TAP_TYPE1__IRLENGTH:
				return getIRlength();
			case devicesPackage.TAP_TYPE1__BYPASS_INST:
				return getBypassInst();
			case devicesPackage.TAP_TYPE1__ID:
				return getId();
			case devicesPackage.TAP_TYPE1__NUMBER:
				return getNumber();
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
			case devicesPackage.TAP_TYPE1__IRLENGTH:
				setIRlength((Short)newValue);
				return;
			case devicesPackage.TAP_TYPE1__BYPASS_INST:
				setBypassInst((String)newValue);
				return;
			case devicesPackage.TAP_TYPE1__ID:
				setId((Short)newValue);
				return;
			case devicesPackage.TAP_TYPE1__NUMBER:
				setNumber((Short)newValue);
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
			case devicesPackage.TAP_TYPE1__IRLENGTH:
				unsetIRlength();
				return;
			case devicesPackage.TAP_TYPE1__BYPASS_INST:
				setBypassInst(BYPASS_INST_EDEFAULT);
				return;
			case devicesPackage.TAP_TYPE1__ID:
				unsetId();
				return;
			case devicesPackage.TAP_TYPE1__NUMBER:
				unsetNumber();
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
			case devicesPackage.TAP_TYPE1__IRLENGTH:
				return isSetIRlength();
			case devicesPackage.TAP_TYPE1__BYPASS_INST:
				return BYPASS_INST_EDEFAULT == null ? bypassInst != null : !BYPASS_INST_EDEFAULT.equals(bypassInst);
			case devicesPackage.TAP_TYPE1__ID:
				return isSetId();
			case devicesPackage.TAP_TYPE1__NUMBER:
				return isSetNumber();
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
		result.append(" (iRlength: ");
		if (iRlengthESet) result.append(iRlength); else result.append("<unset>");
		result.append(", bypassInst: ");
		result.append(bypassInst);
		result.append(", id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(", number: ");
		if (numberESet) result.append(number); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TapType1Impl
