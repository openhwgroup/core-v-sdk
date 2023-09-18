/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ashling.riscfree.debug.opxd.emf.devices.AshlingProcessorDataBaseType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.ProcessorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ashling Processor Data Base Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.AshlingProcessorDataBaseTypeImpl#getProcessor <em>Processor</em>}</li>
 *   <li>{@link Devices.impl.AshlingProcessorDataBaseTypeImpl#getDate <em>Date</em>}</li>
 *   <li>{@link Devices.impl.AshlingProcessorDataBaseTypeImpl#getFamily <em>Family</em>}</li>
 *   <li>{@link Devices.impl.AshlingProcessorDataBaseTypeImpl#getSubSet <em>Sub Set</em>}</li>
 *   <li>{@link Devices.impl.AshlingProcessorDataBaseTypeImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AshlingProcessorDataBaseTypeImpl extends MinimalEObjectImpl.Container implements AshlingProcessorDataBaseType {
	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessorType> processor;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected String family = FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubSet() <em>Sub Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSet()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubSet() <em>Sub Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSet()
	 * @generated
	 * @ordered
	 */
	protected String subSet = SUB_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final short VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected short version = VERSION_EDEFAULT;

	/**
	 * This is true if the Version attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean versionESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AshlingProcessorDataBaseTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.ASHLING_PROCESSOR_DATA_BASE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessorType> getProcessor() {
		if (processor == null) {
			processor = new EObjectContainmentEList<ProcessorType>(ProcessorType.class, this, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR);
		}
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(XMLGregorianCalendar newDate) {
		XMLGregorianCalendar oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamily(String newFamily) {
		String oldFamily = family;
		family = newFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubSet() {
		return subSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubSet(String newSubSet) {
		String oldSubSet = subSet;
		subSet = newSubSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET, oldSubSet, subSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(short newVersion) {
		short oldVersion = version;
		version = newVersion;
		boolean oldVersionESet = versionESet;
		versionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION, oldVersion, version, !oldVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVersion() {
		short oldVersion = version;
		boolean oldVersionESet = versionESet;
		version = VERSION_EDEFAULT;
		versionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION, oldVersion, VERSION_EDEFAULT, oldVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVersion() {
		return versionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR:
				return ((InternalEList<?>)getProcessor()).basicRemove(otherEnd, msgs);
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
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR:
				return getProcessor();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE:
				return getDate();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY:
				return getFamily();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET:
				return getSubSet();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION:
				return getVersion();
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
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR:
				getProcessor().clear();
				getProcessor().addAll((Collection<? extends ProcessorType>)newValue);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE:
				setDate((XMLGregorianCalendar)newValue);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY:
				setFamily((String)newValue);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET:
				setSubSet((String)newValue);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION:
				setVersion((Short)newValue);
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
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR:
				getProcessor().clear();
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY:
				setFamily(FAMILY_EDEFAULT);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET:
				setSubSet(SUB_SET_EDEFAULT);
				return;
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION:
				unsetVersion();
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
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR:
				return processor != null && !processor.isEmpty();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY:
				return FAMILY_EDEFAULT == null ? family != null : !FAMILY_EDEFAULT.equals(family);
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET:
				return SUB_SET_EDEFAULT == null ? subSet != null : !SUB_SET_EDEFAULT.equals(subSet);
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION:
				return isSetVersion();
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
		result.append(" (date: ");
		result.append(date);
		result.append(", family: ");
		result.append(family);
		result.append(", subSet: ");
		result.append(subSet);
		result.append(", version: ");
		if (versionESet) result.append(version); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AshlingProcessorDataBaseTypeImpl
