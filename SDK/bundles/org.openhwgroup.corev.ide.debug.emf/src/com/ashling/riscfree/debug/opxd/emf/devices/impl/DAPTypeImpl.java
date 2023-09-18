/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.DAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGDPType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DAP Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.DAPTypeImpl#getJTAGDP <em>JTAGDP</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getSWDDP <em>SWDDP</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getDebugBaseAddress <em>Debug Base Address</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getCTIBaseAddress <em>CTI Base Address</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getPTMBaseAddress <em>PTM Base Address</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getETMBaseAddress <em>ETM Base Address</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getFunnelPortIndex <em>Funnel Port Index</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getDebugApIndex <em>Debug Ap Index</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getDebugPulpNPCAddr <em>Debug Pulp NPC Addr</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getDebugTransport <em>Debug Transport</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getMemoryApIndex <em>Memory Ap Index</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getJtagApIndex <em>Jtag Ap Index</em>}</li>
 *   <li>{@link Devices.impl.DAPTypeImpl#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DAPTypeImpl extends MinimalEObjectImpl.Container implements DAPType {
	/**
	 * The cached value of the '{@link #getJTAGDP() <em>JTAGDP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJTAGDP()
	 * @generated
	 * @ordered
	 */
	protected JTAGDPType jTAGDP;

	/**
	 * The cached value of the '{@link #getSWDDP() <em>SWDDP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSWDDP()
	 * @generated
	 * @ordered
	 */
	protected EObject sWDDP;

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
	 * The default value of the '{@link #getCTIBaseAddress() <em>CTI Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCTIBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CTI_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCTIBaseAddress() <em>CTI Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCTIBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cTIBaseAddress = CTI_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPTMBaseAddress() <em>PTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPTMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String PTM_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPTMBaseAddress() <em>PTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPTMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String pTMBaseAddress = PTM_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getETMBaseAddress() <em>ETM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getETMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ETM_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getETMBaseAddress() <em>ETM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getETMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String eTMBaseAddress = ETM_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFunnelPortIndex() <em>Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunnelPortIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short FUNNEL_PORT_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFunnelPortIndex() <em>Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunnelPortIndex()
	 * @generated
	 * @ordered
	 */
	protected short funnelPortIndex = FUNNEL_PORT_INDEX_EDEFAULT;

	/**
	 * This is true if the Funnel Port Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean funnelPortIndexESet;

	/**
	 * The default value of the '{@link #getDebugApIndex() <em>Debug Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugApIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short DEBUG_AP_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDebugApIndex() <em>Debug Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugApIndex()
	 * @generated
	 * @ordered
	 */
	protected short debugApIndex = DEBUG_AP_INDEX_EDEFAULT;

	/**
	 * This is true if the Debug Ap Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean debugApIndexESet;

	/**
	 * The default value of the '{@link #getDebugPulpNPCAddr() <em>Debug Pulp NPC Addr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugPulpNPCAddr()
	 * @generated
	 * @ordered
	 */
	protected static final String DEBUG_PULP_NPC_ADDR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebugPulpNPCAddr() <em>Debug Pulp NPC Addr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugPulpNPCAddr()
	 * @generated
	 * @ordered
	 */
	protected String debugPulpNPCAddr = DEBUG_PULP_NPC_ADDR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebugTransport() <em>Debug Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugTransport()
	 * @generated
	 * @ordered
	 */
	protected static final short DEBUG_TRANSPORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDebugTransport() <em>Debug Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebugTransport()
	 * @generated
	 * @ordered
	 */
	protected short debugTransport = DEBUG_TRANSPORT_EDEFAULT;

	/**
	 * This is true if the Debug Transport attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean debugTransportESet;

	/**
	 * The default value of the '{@link #getMemoryApIndex() <em>Memory Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryApIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short MEMORY_AP_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMemoryApIndex() <em>Memory Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryApIndex()
	 * @generated
	 * @ordered
	 */
	protected short memoryApIndex = MEMORY_AP_INDEX_EDEFAULT;

	/**
	 * This is true if the Memory Ap Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean memoryApIndexESet;

	/**
	 * The default value of the '{@link #getJtagApIndex() <em>Jtag Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJtagApIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short JTAG_AP_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getJtagApIndex() <em>Jtag Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJtagApIndex()
	 * @generated
	 * @ordered
	 */
	protected short jtagApIndex = JTAG_AP_INDEX_EDEFAULT;

	/**
	 * This is true if the Jtag Ap Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jtagApIndexESet;

	/**
	 * The default value of the '{@link #getUseMemApForMemAccess() <em>Use Mem Ap For Mem Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseMemApForMemAccess()
	 * @generated
	 * @ordered
	 */
	protected static final short USE_MEM_AP_FOR_MEM_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUseMemApForMemAccess() <em>Use Mem Ap For Mem Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseMemApForMemAccess()
	 * @generated
	 * @ordered
	 */
	protected short useMemApForMemAccess = USE_MEM_AP_FOR_MEM_ACCESS_EDEFAULT;

	/**
	 * This is true if the Use Mem Ap For Mem Access attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useMemApForMemAccessESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DAPTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.DAP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTAGDPType getJTAGDP() {
		return jTAGDP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJTAGDP(JTAGDPType newJTAGDP, NotificationChain msgs) {
		JTAGDPType oldJTAGDP = jTAGDP;
		jTAGDP = newJTAGDP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__JTAGDP, oldJTAGDP, newJTAGDP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJTAGDP(JTAGDPType newJTAGDP) {
		if (newJTAGDP != jTAGDP) {
			NotificationChain msgs = null;
			if (jTAGDP != null)
				msgs = ((InternalEObject)jTAGDP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.DAP_TYPE__JTAGDP, null, msgs);
			if (newJTAGDP != null)
				msgs = ((InternalEObject)newJTAGDP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.DAP_TYPE__JTAGDP, null, msgs);
			msgs = basicSetJTAGDP(newJTAGDP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__JTAGDP, newJTAGDP, newJTAGDP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSWDDP() {
		return sWDDP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSWDDP(EObject newSWDDP, NotificationChain msgs) {
		EObject oldSWDDP = sWDDP;
		sWDDP = newSWDDP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__SWDDP, oldSWDDP, newSWDDP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSWDDP(EObject newSWDDP) {
		if (newSWDDP != sWDDP) {
			NotificationChain msgs = null;
			if (sWDDP != null)
				msgs = ((InternalEObject)sWDDP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.DAP_TYPE__SWDDP, null, msgs);
			if (newSWDDP != null)
				msgs = ((InternalEObject)newSWDDP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.DAP_TYPE__SWDDP, null, msgs);
			msgs = basicSetSWDDP(newSWDDP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__SWDDP, newSWDDP, newSWDDP));
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
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__DEBUG_BASE_ADDRESS, oldDebugBaseAddress, debugBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCTIBaseAddress() {
		return cTIBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCTIBaseAddress(String newCTIBaseAddress) {
		String oldCTIBaseAddress = cTIBaseAddress;
		cTIBaseAddress = newCTIBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__CTI_BASE_ADDRESS, oldCTIBaseAddress, cTIBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPTMBaseAddress() {
		return pTMBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPTMBaseAddress(String newPTMBaseAddress) {
		String oldPTMBaseAddress = pTMBaseAddress;
		pTMBaseAddress = newPTMBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__PTM_BASE_ADDRESS, oldPTMBaseAddress, pTMBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getETMBaseAddress() {
		return eTMBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setETMBaseAddress(String newETMBaseAddress) {
		String oldETMBaseAddress = eTMBaseAddress;
		eTMBaseAddress = newETMBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__ETM_BASE_ADDRESS, oldETMBaseAddress, eTMBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getFunnelPortIndex() {
		return funnelPortIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunnelPortIndex(short newFunnelPortIndex) {
		short oldFunnelPortIndex = funnelPortIndex;
		funnelPortIndex = newFunnelPortIndex;
		boolean oldFunnelPortIndexESet = funnelPortIndexESet;
		funnelPortIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX, oldFunnelPortIndex, funnelPortIndex, !oldFunnelPortIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFunnelPortIndex() {
		short oldFunnelPortIndex = funnelPortIndex;
		boolean oldFunnelPortIndexESet = funnelPortIndexESet;
		funnelPortIndex = FUNNEL_PORT_INDEX_EDEFAULT;
		funnelPortIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX, oldFunnelPortIndex, FUNNEL_PORT_INDEX_EDEFAULT, oldFunnelPortIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFunnelPortIndex() {
		return funnelPortIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getDebugApIndex() {
		return debugApIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugApIndex(short newDebugApIndex) {
		short oldDebugApIndex = debugApIndex;
		debugApIndex = newDebugApIndex;
		boolean oldDebugApIndexESet = debugApIndexESet;
		debugApIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__DEBUG_AP_INDEX, oldDebugApIndex, debugApIndex, !oldDebugApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDebugApIndex() {
		short oldDebugApIndex = debugApIndex;
		boolean oldDebugApIndexESet = debugApIndexESet;
		debugApIndex = DEBUG_AP_INDEX_EDEFAULT;
		debugApIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__DEBUG_AP_INDEX, oldDebugApIndex, DEBUG_AP_INDEX_EDEFAULT, oldDebugApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDebugApIndex() {
		return debugApIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDebugPulpNPCAddr() {
		return debugPulpNPCAddr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugPulpNPCAddr(String newDebugPulpNPCAddr) {
		String oldDebugPulpNPCAddr = debugPulpNPCAddr;
		debugPulpNPCAddr = newDebugPulpNPCAddr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__DEBUG_PULP_NPC_ADDR, oldDebugPulpNPCAddr, debugPulpNPCAddr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getDebugTransport() {
		return debugTransport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugTransport(short newDebugTransport) {
		short oldDebugTransport = debugTransport;
		debugTransport = newDebugTransport;
		boolean oldDebugTransportESet = debugTransportESet;
		debugTransportESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__DEBUG_TRANSPORT, oldDebugTransport, debugTransport, !oldDebugTransportESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDebugTransport() {
		short oldDebugTransport = debugTransport;
		boolean oldDebugTransportESet = debugTransportESet;
		debugTransport = DEBUG_TRANSPORT_EDEFAULT;
		debugTransportESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__DEBUG_TRANSPORT, oldDebugTransport, DEBUG_TRANSPORT_EDEFAULT, oldDebugTransportESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDebugTransport() {
		return debugTransportESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getMemoryApIndex() {
		return memoryApIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryApIndex(short newMemoryApIndex) {
		short oldMemoryApIndex = memoryApIndex;
		memoryApIndex = newMemoryApIndex;
		boolean oldMemoryApIndexESet = memoryApIndexESet;
		memoryApIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__MEMORY_AP_INDEX, oldMemoryApIndex, memoryApIndex, !oldMemoryApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMemoryApIndex() {
		short oldMemoryApIndex = memoryApIndex;
		boolean oldMemoryApIndexESet = memoryApIndexESet;
		memoryApIndex = MEMORY_AP_INDEX_EDEFAULT;
		memoryApIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__MEMORY_AP_INDEX, oldMemoryApIndex, MEMORY_AP_INDEX_EDEFAULT, oldMemoryApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMemoryApIndex() {
		return memoryApIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getJtagApIndex() {
		return jtagApIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJtagApIndex(short newJtagApIndex) {
		short oldJtagApIndex = jtagApIndex;
		jtagApIndex = newJtagApIndex;
		boolean oldJtagApIndexESet = jtagApIndexESet;
		jtagApIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__JTAG_AP_INDEX, oldJtagApIndex, jtagApIndex, !oldJtagApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJtagApIndex() {
		short oldJtagApIndex = jtagApIndex;
		boolean oldJtagApIndexESet = jtagApIndexESet;
		jtagApIndex = JTAG_AP_INDEX_EDEFAULT;
		jtagApIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__JTAG_AP_INDEX, oldJtagApIndex, JTAG_AP_INDEX_EDEFAULT, oldJtagApIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJtagApIndex() {
		return jtagApIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getUseMemApForMemAccess() {
		return useMemApForMemAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseMemApForMemAccess(short newUseMemApForMemAccess) {
		short oldUseMemApForMemAccess = useMemApForMemAccess;
		useMemApForMemAccess = newUseMemApForMemAccess;
		boolean oldUseMemApForMemAccessESet = useMemApForMemAccessESet;
		useMemApForMemAccessESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS, oldUseMemApForMemAccess, useMemApForMemAccess, !oldUseMemApForMemAccessESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseMemApForMemAccess() {
		short oldUseMemApForMemAccess = useMemApForMemAccess;
		boolean oldUseMemApForMemAccessESet = useMemApForMemAccessESet;
		useMemApForMemAccess = USE_MEM_AP_FOR_MEM_ACCESS_EDEFAULT;
		useMemApForMemAccessESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS, oldUseMemApForMemAccess, USE_MEM_AP_FOR_MEM_ACCESS_EDEFAULT, oldUseMemApForMemAccessESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseMemApForMemAccess() {
		return useMemApForMemAccessESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.DAP_TYPE__JTAGDP:
				return basicSetJTAGDP(null, msgs);
			case devicesPackage.DAP_TYPE__SWDDP:
				return basicSetSWDDP(null, msgs);
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
			case devicesPackage.DAP_TYPE__JTAGDP:
				return getJTAGDP();
			case devicesPackage.DAP_TYPE__SWDDP:
				return getSWDDP();
			case devicesPackage.DAP_TYPE__DEBUG_BASE_ADDRESS:
				return getDebugBaseAddress();
			case devicesPackage.DAP_TYPE__CTI_BASE_ADDRESS:
				return getCTIBaseAddress();
			case devicesPackage.DAP_TYPE__PTM_BASE_ADDRESS:
				return getPTMBaseAddress();
			case devicesPackage.DAP_TYPE__ETM_BASE_ADDRESS:
				return getETMBaseAddress();
			case devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX:
				return getFunnelPortIndex();
			case devicesPackage.DAP_TYPE__DEBUG_AP_INDEX:
				return getDebugApIndex();
			case devicesPackage.DAP_TYPE__DEBUG_PULP_NPC_ADDR:
				return getDebugPulpNPCAddr();
			case devicesPackage.DAP_TYPE__DEBUG_TRANSPORT:
				return getDebugTransport();
			case devicesPackage.DAP_TYPE__MEMORY_AP_INDEX:
				return getMemoryApIndex();
			case devicesPackage.DAP_TYPE__JTAG_AP_INDEX:
				return getJtagApIndex();
			case devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS:
				return getUseMemApForMemAccess();
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
			case devicesPackage.DAP_TYPE__JTAGDP:
				setJTAGDP((JTAGDPType)newValue);
				return;
			case devicesPackage.DAP_TYPE__SWDDP:
				setSWDDP((EObject)newValue);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_BASE_ADDRESS:
				setDebugBaseAddress((String)newValue);
				return;
			case devicesPackage.DAP_TYPE__CTI_BASE_ADDRESS:
				setCTIBaseAddress((String)newValue);
				return;
			case devicesPackage.DAP_TYPE__PTM_BASE_ADDRESS:
				setPTMBaseAddress((String)newValue);
				return;
			case devicesPackage.DAP_TYPE__ETM_BASE_ADDRESS:
				setETMBaseAddress((String)newValue);
				return;
			case devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX:
				setFunnelPortIndex((Short)newValue);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_AP_INDEX:
				setDebugApIndex((Short)newValue);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_PULP_NPC_ADDR:
				setDebugPulpNPCAddr((String)newValue);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_TRANSPORT:
				setDebugTransport((Short)newValue);
				return;
			case devicesPackage.DAP_TYPE__MEMORY_AP_INDEX:
				setMemoryApIndex((Short)newValue);
				return;
			case devicesPackage.DAP_TYPE__JTAG_AP_INDEX:
				setJtagApIndex((Short)newValue);
				return;
			case devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS:
				setUseMemApForMemAccess((Short)newValue);
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
			case devicesPackage.DAP_TYPE__JTAGDP:
				setJTAGDP((JTAGDPType)null);
				return;
			case devicesPackage.DAP_TYPE__SWDDP:
				setSWDDP((EObject)null);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_BASE_ADDRESS:
				setDebugBaseAddress(DEBUG_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.DAP_TYPE__CTI_BASE_ADDRESS:
				setCTIBaseAddress(CTI_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.DAP_TYPE__PTM_BASE_ADDRESS:
				setPTMBaseAddress(PTM_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.DAP_TYPE__ETM_BASE_ADDRESS:
				setETMBaseAddress(ETM_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX:
				unsetFunnelPortIndex();
				return;
			case devicesPackage.DAP_TYPE__DEBUG_AP_INDEX:
				unsetDebugApIndex();
				return;
			case devicesPackage.DAP_TYPE__DEBUG_PULP_NPC_ADDR:
				setDebugPulpNPCAddr(DEBUG_PULP_NPC_ADDR_EDEFAULT);
				return;
			case devicesPackage.DAP_TYPE__DEBUG_TRANSPORT:
				unsetDebugTransport();
				return;
			case devicesPackage.DAP_TYPE__MEMORY_AP_INDEX:
				unsetMemoryApIndex();
				return;
			case devicesPackage.DAP_TYPE__JTAG_AP_INDEX:
				unsetJtagApIndex();
				return;
			case devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS:
				unsetUseMemApForMemAccess();
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
			case devicesPackage.DAP_TYPE__JTAGDP:
				return jTAGDP != null;
			case devicesPackage.DAP_TYPE__SWDDP:
				return sWDDP != null;
			case devicesPackage.DAP_TYPE__DEBUG_BASE_ADDRESS:
				return DEBUG_BASE_ADDRESS_EDEFAULT == null ? debugBaseAddress != null : !DEBUG_BASE_ADDRESS_EDEFAULT.equals(debugBaseAddress);
			case devicesPackage.DAP_TYPE__CTI_BASE_ADDRESS:
				return CTI_BASE_ADDRESS_EDEFAULT == null ? cTIBaseAddress != null : !CTI_BASE_ADDRESS_EDEFAULT.equals(cTIBaseAddress);
			case devicesPackage.DAP_TYPE__PTM_BASE_ADDRESS:
				return PTM_BASE_ADDRESS_EDEFAULT == null ? pTMBaseAddress != null : !PTM_BASE_ADDRESS_EDEFAULT.equals(pTMBaseAddress);
			case devicesPackage.DAP_TYPE__ETM_BASE_ADDRESS:
				return ETM_BASE_ADDRESS_EDEFAULT == null ? eTMBaseAddress != null : !ETM_BASE_ADDRESS_EDEFAULT.equals(eTMBaseAddress);
			case devicesPackage.DAP_TYPE__FUNNEL_PORT_INDEX:
				return isSetFunnelPortIndex();
			case devicesPackage.DAP_TYPE__DEBUG_AP_INDEX:
				return isSetDebugApIndex();
			case devicesPackage.DAP_TYPE__DEBUG_PULP_NPC_ADDR:
				return DEBUG_PULP_NPC_ADDR_EDEFAULT == null ? debugPulpNPCAddr != null : !DEBUG_PULP_NPC_ADDR_EDEFAULT.equals(debugPulpNPCAddr);
			case devicesPackage.DAP_TYPE__DEBUG_TRANSPORT:
				return isSetDebugTransport();
			case devicesPackage.DAP_TYPE__MEMORY_AP_INDEX:
				return isSetMemoryApIndex();
			case devicesPackage.DAP_TYPE__JTAG_AP_INDEX:
				return isSetJtagApIndex();
			case devicesPackage.DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS:
				return isSetUseMemApForMemAccess();
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
		result.append(", cTIBaseAddress: ");
		result.append(cTIBaseAddress);
		result.append(", pTMBaseAddress: ");
		result.append(pTMBaseAddress);
		result.append(", eTMBaseAddress: ");
		result.append(eTMBaseAddress);
		result.append(", funnelPortIndex: ");
		if (funnelPortIndexESet) result.append(funnelPortIndex); else result.append("<unset>");
		result.append(", debugApIndex: ");
		if (debugApIndexESet) result.append(debugApIndex); else result.append("<unset>");
		result.append(", debugPulpNPCAddr: ");
		result.append(debugPulpNPCAddr);
		result.append(", debugTransport: ");
		if (debugTransportESet) result.append(debugTransport); else result.append("<unset>");
		result.append(", memoryApIndex: ");
		if (memoryApIndexESet) result.append(memoryApIndex); else result.append("<unset>");
		result.append(", jtagApIndex: ");
		if (jtagApIndexESet) result.append(jtagApIndex); else result.append("<unset>");
		result.append(", useMemApForMemAccess: ");
		if (useMemApForMemAccessESet) result.append(useMemApForMemAccess); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DAPTypeImpl
