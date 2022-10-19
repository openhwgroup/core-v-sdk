/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.CoreType;
import com.ashling.riscfree.debug.opxd.emf.devices.DAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.MemoryType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType;
import com.ashling.riscfree.debug.opxd.emf.devices.VJTAGType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.CoreTypeImpl#getDAP <em>DAP</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getTap <em>Tap</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getVJTAG <em>VJTAG</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getDebugBaseAddress <em>Debug Base Address</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getMemory <em>Memory</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getGDBRegFile <em>GDB Reg File</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getFamily <em>Family</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link Devices.impl.CoreTypeImpl#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CoreTypeImpl extends MinimalEObjectImpl.Container implements CoreType {
	/**
	 * The cached value of the '{@link #getDAP() <em>DAP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDAP()
	 * @generated
	 * @ordered
	 */
	protected DAPType dAP;

	/**
	 * The cached value of the '{@link #getTap() <em>Tap</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTap()
	 * @generated
	 * @ordered
	 */
	protected TapType tap;

	/**
	 * The cached value of the '{@link #getVJTAG() <em>VJTAG</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVJTAG()
	 * @generated
	 * @ordered
	 */
	protected VJTAGType vJTAG;

	/**
	 * The default value of the '{@link #getDebugBaseAddress() <em>Debug Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String DEBUG_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebugBaseAddress() <em>Debug Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String debugBaseAddress = DEBUG_BASE_ADDRESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemory() <em>Memory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemory()
	 * @generated
	 * @ordered
	 */
	protected MemoryType memory;

	/**
	 * The default value of the '{@link #getGDBRegFile() <em>GDB Reg File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGDBRegFile()
	 * @generated
	 * @ordered
	 */
	protected static final String GDB_REG_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGDBRegFile() <em>GDB Reg File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGDBRegFile()
	 * @generated
	 * @ordered
	 */
	protected String gDBRegFile = GDB_REG_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String ARCHITECTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected String architecture = ARCHITECTURE_EDEFAULT;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	protected CoreTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.CORE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DAPType getDAP() {
		return dAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDAP(DAPType newDAP, NotificationChain msgs) {
		DAPType oldDAP = dAP;
		dAP = newDAP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__DAP, oldDAP, newDAP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDAP(DAPType newDAP) {
		if (newDAP != dAP) {
			NotificationChain msgs = null;
			if (dAP != null)
				msgs = ((InternalEObject)dAP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__DAP, null, msgs);
			if (newDAP != null)
				msgs = ((InternalEObject)newDAP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__DAP, null, msgs);
			msgs = basicSetDAP(newDAP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__DAP, newDAP, newDAP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapType getTap() {
		return tap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTap(TapType newTap, NotificationChain msgs) {
		TapType oldTap = tap;
		tap = newTap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__TAP, oldTap, newTap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTap(TapType newTap) {
		if (newTap != tap) {
			NotificationChain msgs = null;
			if (tap != null)
				msgs = ((InternalEObject)tap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__TAP, null, msgs);
			if (newTap != null)
				msgs = ((InternalEObject)newTap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__TAP, null, msgs);
			msgs = basicSetTap(newTap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__TAP, newTap, newTap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VJTAGType getVJTAG() {
		return vJTAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVJTAG(VJTAGType newVJTAG, NotificationChain msgs) {
		VJTAGType oldVJTAG = vJTAG;
		vJTAG = newVJTAG;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__VJTAG, oldVJTAG, newVJTAG);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVJTAG(VJTAGType newVJTAG) {
		if (newVJTAG != vJTAG) {
			NotificationChain msgs = null;
			if (vJTAG != null)
				msgs = ((InternalEObject)vJTAG).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__VJTAG, null, msgs);
			if (newVJTAG != null)
				msgs = ((InternalEObject)newVJTAG).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__VJTAG, null, msgs);
			msgs = basicSetVJTAG(newVJTAG, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__VJTAG, newVJTAG, newVJTAG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDebugBaseAddress() {
		return debugBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugBaseAddress(String newDebugBaseAddress) {
		String oldDebugBaseAddress = debugBaseAddress;
		debugBaseAddress = newDebugBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__DEBUG_BASE_ADDRESS, oldDebugBaseAddress, debugBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType getMemory() {
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemory(MemoryType newMemory, NotificationChain msgs) {
		MemoryType oldMemory = memory;
		memory = newMemory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__MEMORY, oldMemory, newMemory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemory(MemoryType newMemory) {
		if (newMemory != memory) {
			NotificationChain msgs = null;
			if (memory != null)
				msgs = ((InternalEObject)memory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__MEMORY, null, msgs);
			if (newMemory != null)
				msgs = ((InternalEObject)newMemory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.CORE_TYPE__MEMORY, null, msgs);
			msgs = basicSetMemory(newMemory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__MEMORY, newMemory, newMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGDBRegFile() {
		return gDBRegFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGDBRegFile(String newGDBRegFile) {
		String oldGDBRegFile = gDBRegFile;
		gDBRegFile = newGDBRegFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__GDB_REG_FILE, oldGDBRegFile, gDBRegFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecture(String newArchitecture) {
		String oldArchitecture = architecture;
		architecture = newArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__ARCHITECTURE, oldArchitecture, architecture));
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
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.CORE_TYPE__NUMBER, oldNumber, number, !oldNumberESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.CORE_TYPE__NUMBER, oldNumber, NUMBER_EDEFAULT, oldNumberESet));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.CORE_TYPE__DAP:
				return basicSetDAP(null, msgs);
			case devicesPackage.CORE_TYPE__TAP:
				return basicSetTap(null, msgs);
			case devicesPackage.CORE_TYPE__VJTAG:
				return basicSetVJTAG(null, msgs);
			case devicesPackage.CORE_TYPE__MEMORY:
				return basicSetMemory(null, msgs);
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
			case devicesPackage.CORE_TYPE__DAP:
				return getDAP();
			case devicesPackage.CORE_TYPE__TAP:
				return getTap();
			case devicesPackage.CORE_TYPE__VJTAG:
				return getVJTAG();
			case devicesPackage.CORE_TYPE__DEBUG_BASE_ADDRESS:
				return getDebugBaseAddress();
			case devicesPackage.CORE_TYPE__MEMORY:
				return getMemory();
			case devicesPackage.CORE_TYPE__GDB_REG_FILE:
				return getGDBRegFile();
			case devicesPackage.CORE_TYPE__ARCHITECTURE:
				return getArchitecture();
			case devicesPackage.CORE_TYPE__FAMILY:
				return getFamily();
			case devicesPackage.CORE_TYPE__NAME:
				return getName();
			case devicesPackage.CORE_TYPE__NUMBER:
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
			case devicesPackage.CORE_TYPE__DAP:
				setDAP((DAPType)newValue);
				return;
			case devicesPackage.CORE_TYPE__TAP:
				setTap((TapType)newValue);
				return;
			case devicesPackage.CORE_TYPE__VJTAG:
				setVJTAG((VJTAGType)newValue);
				return;
			case devicesPackage.CORE_TYPE__DEBUG_BASE_ADDRESS:
				setDebugBaseAddress((String)newValue);
				return;
			case devicesPackage.CORE_TYPE__MEMORY:
				setMemory((MemoryType)newValue);
				return;
			case devicesPackage.CORE_TYPE__GDB_REG_FILE:
				setGDBRegFile((String)newValue);
				return;
			case devicesPackage.CORE_TYPE__ARCHITECTURE:
				setArchitecture((String)newValue);
				return;
			case devicesPackage.CORE_TYPE__FAMILY:
				setFamily((String)newValue);
				return;
			case devicesPackage.CORE_TYPE__NAME:
				setName((String)newValue);
				return;
			case devicesPackage.CORE_TYPE__NUMBER:
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
			case devicesPackage.CORE_TYPE__DAP:
				setDAP((DAPType)null);
				return;
			case devicesPackage.CORE_TYPE__TAP:
				setTap((TapType)null);
				return;
			case devicesPackage.CORE_TYPE__VJTAG:
				setVJTAG((VJTAGType)null);
				return;
			case devicesPackage.CORE_TYPE__DEBUG_BASE_ADDRESS:
				setDebugBaseAddress(DEBUG_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.CORE_TYPE__MEMORY:
				setMemory((MemoryType)null);
				return;
			case devicesPackage.CORE_TYPE__GDB_REG_FILE:
				setGDBRegFile(GDB_REG_FILE_EDEFAULT);
				return;
			case devicesPackage.CORE_TYPE__ARCHITECTURE:
				setArchitecture(ARCHITECTURE_EDEFAULT);
				return;
			case devicesPackage.CORE_TYPE__FAMILY:
				setFamily(FAMILY_EDEFAULT);
				return;
			case devicesPackage.CORE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case devicesPackage.CORE_TYPE__NUMBER:
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
			case devicesPackage.CORE_TYPE__DAP:
				return dAP != null;
			case devicesPackage.CORE_TYPE__TAP:
				return tap != null;
			case devicesPackage.CORE_TYPE__VJTAG:
				return vJTAG != null;
			case devicesPackage.CORE_TYPE__DEBUG_BASE_ADDRESS:
				return DEBUG_BASE_ADDRESS_EDEFAULT == null ? debugBaseAddress != null : !DEBUG_BASE_ADDRESS_EDEFAULT.equals(debugBaseAddress);
			case devicesPackage.CORE_TYPE__MEMORY:
				return memory != null;
			case devicesPackage.CORE_TYPE__GDB_REG_FILE:
				return GDB_REG_FILE_EDEFAULT == null ? gDBRegFile != null : !GDB_REG_FILE_EDEFAULT.equals(gDBRegFile);
			case devicesPackage.CORE_TYPE__ARCHITECTURE:
				return ARCHITECTURE_EDEFAULT == null ? architecture != null : !ARCHITECTURE_EDEFAULT.equals(architecture);
			case devicesPackage.CORE_TYPE__FAMILY:
				return FAMILY_EDEFAULT == null ? family != null : !FAMILY_EDEFAULT.equals(family);
			case devicesPackage.CORE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case devicesPackage.CORE_TYPE__NUMBER:
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
		result.append(" (debugBaseAddress: ");
		result.append(debugBaseAddress);
		result.append(", gDBRegFile: ");
		result.append(gDBRegFile);
		result.append(", architecture: ");
		result.append(architecture);
		result.append(", family: ");
		result.append(family);
		result.append(", name: ");
		result.append(name);
		result.append(", number: ");
		if (numberESet) result.append(number); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CoreTypeImpl
