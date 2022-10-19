/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DAP Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.DAPType#getJTAGDP <em>JTAGDP</em>}</li>
 *   <li>{@link Devices.DAPType#getSWDDP <em>SWDDP</em>}</li>
 *   <li>{@link Devices.DAPType#getDebugBaseAddress <em>Debug Base Address</em>}</li>
 *   <li>{@link Devices.DAPType#getCTIBaseAddress <em>CTI Base Address</em>}</li>
 *   <li>{@link Devices.DAPType#getPTMBaseAddress <em>PTM Base Address</em>}</li>
 *   <li>{@link Devices.DAPType#getETMBaseAddress <em>ETM Base Address</em>}</li>
 *   <li>{@link Devices.DAPType#getFunnelPortIndex <em>Funnel Port Index</em>}</li>
 *   <li>{@link Devices.DAPType#getDebugApIndex <em>Debug Ap Index</em>}</li>
 *   <li>{@link Devices.DAPType#getDebugPulpNPCAddr <em>Debug Pulp NPC Addr</em>}</li>
 *   <li>{@link Devices.DAPType#getDebugTransport <em>Debug Transport</em>}</li>
 *   <li>{@link Devices.DAPType#getMemoryApIndex <em>Memory Ap Index</em>}</li>
 *   <li>{@link Devices.DAPType#getJtagApIndex <em>Jtag Ap Index</em>}</li>
 *   <li>{@link Devices.DAPType#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getDAPType()
 * @model extendedMetaData="name='DAP_._type' kind='elementOnly'"
 * @generated
 */
public interface DAPType extends EObject {
	/**
	 * Returns the value of the '<em><b>JTAGDP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JTAGDP</em>' containment reference.
	 * @see #setJTAGDP(JTAGDPType)
	 * @see devicesPackage.DevicesPackage#getDAPType_JTAGDP()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='JTAGDP' namespace='##targetNamespace'"
	 * @generated
	 */
	JTAGDPType getJTAGDP();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getJTAGDP <em>JTAGDP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JTAGDP</em>' containment reference.
	 * @see #getJTAGDP()
	 * @generated
	 */
	void setJTAGDP(JTAGDPType value);

	/**
	 * Returns the value of the '<em><b>SWDDP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SWDDP</em>' containment reference.
	 * @see #setSWDDP(EObject)
	 * @see devicesPackage.DevicesPackage#getDAPType_SWDDP()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SWDDP' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getSWDDP();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getSWDDP <em>SWDDP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SWDDP</em>' containment reference.
	 * @see #getSWDDP()
	 * @generated
	 */
	void setSWDDP(EObject value);

	/**
	 * Returns the value of the '<em><b>Debug Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Base Address</em>' attribute.
	 * @see #setDebugBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getDAPType_DebugBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='DebugBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDebugBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getDebugBaseAddress <em>Debug Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Base Address</em>' attribute.
	 * @see #getDebugBaseAddress()
	 * @generated
	 */
	void setDebugBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CTI Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CTI Base Address</em>' attribute.
	 * @see #setCTIBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getDAPType_CTIBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CTIBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCTIBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getCTIBaseAddress <em>CTI Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CTI Base Address</em>' attribute.
	 * @see #getCTIBaseAddress()
	 * @generated
	 */
	void setCTIBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>PTM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PTM Base Address</em>' attribute.
	 * @see #setPTMBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getDAPType_PTMBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='PTMBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPTMBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getPTMBaseAddress <em>PTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PTM Base Address</em>' attribute.
	 * @see #getPTMBaseAddress()
	 * @generated
	 */
	void setPTMBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>ETM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ETM Base Address</em>' attribute.
	 * @see #setETMBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getDAPType_ETMBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='ETMBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getETMBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getETMBaseAddress <em>ETM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ETM Base Address</em>' attribute.
	 * @see #getETMBaseAddress()
	 * @generated
	 */
	void setETMBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>Funnel Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Funnel Port Index</em>' attribute.
	 * @see #isSetFunnelPortIndex()
	 * @see #unsetFunnelPortIndex()
	 * @see #setFunnelPortIndex(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_FunnelPortIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='FunnelPortIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getFunnelPortIndex();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getFunnelPortIndex <em>Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Funnel Port Index</em>' attribute.
	 * @see #isSetFunnelPortIndex()
	 * @see #unsetFunnelPortIndex()
	 * @see #getFunnelPortIndex()
	 * @generated
	 */
	void setFunnelPortIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getFunnelPortIndex <em>Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFunnelPortIndex()
	 * @see #getFunnelPortIndex()
	 * @see #setFunnelPortIndex(short)
	 * @generated
	 */
	void unsetFunnelPortIndex();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getFunnelPortIndex <em>Funnel Port Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Funnel Port Index</em>' attribute is set.
	 * @see #unsetFunnelPortIndex()
	 * @see #getFunnelPortIndex()
	 * @see #setFunnelPortIndex(short)
	 * @generated
	 */
	boolean isSetFunnelPortIndex();

	/**
	 * Returns the value of the '<em><b>Debug Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Ap Index</em>' attribute.
	 * @see #isSetDebugApIndex()
	 * @see #unsetDebugApIndex()
	 * @see #setDebugApIndex(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_DebugApIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='DebugApIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getDebugApIndex();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getDebugApIndex <em>Debug Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Ap Index</em>' attribute.
	 * @see #isSetDebugApIndex()
	 * @see #unsetDebugApIndex()
	 * @see #getDebugApIndex()
	 * @generated
	 */
	void setDebugApIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getDebugApIndex <em>Debug Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDebugApIndex()
	 * @see #getDebugApIndex()
	 * @see #setDebugApIndex(short)
	 * @generated
	 */
	void unsetDebugApIndex();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getDebugApIndex <em>Debug Ap Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Debug Ap Index</em>' attribute is set.
	 * @see #unsetDebugApIndex()
	 * @see #getDebugApIndex()
	 * @see #setDebugApIndex(short)
	 * @generated
	 */
	boolean isSetDebugApIndex();

	/**
	 * Returns the value of the '<em><b>Debug Pulp NPC Addr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Pulp NPC Addr</em>' attribute.
	 * @see #setDebugPulpNPCAddr(String)
	 * @see devicesPackage.DevicesPackage#getDAPType_DebugPulpNPCAddr()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='DebugPulpNPCAddr' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDebugPulpNPCAddr();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getDebugPulpNPCAddr <em>Debug Pulp NPC Addr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Pulp NPC Addr</em>' attribute.
	 * @see #getDebugPulpNPCAddr()
	 * @generated
	 */
	void setDebugPulpNPCAddr(String value);

	/**
	 * Returns the value of the '<em><b>Debug Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Transport</em>' attribute.
	 * @see #isSetDebugTransport()
	 * @see #unsetDebugTransport()
	 * @see #setDebugTransport(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_DebugTransport()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='DebugTransport' namespace='##targetNamespace'"
	 * @generated
	 */
	short getDebugTransport();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getDebugTransport <em>Debug Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Transport</em>' attribute.
	 * @see #isSetDebugTransport()
	 * @see #unsetDebugTransport()
	 * @see #getDebugTransport()
	 * @generated
	 */
	void setDebugTransport(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getDebugTransport <em>Debug Transport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDebugTransport()
	 * @see #getDebugTransport()
	 * @see #setDebugTransport(short)
	 * @generated
	 */
	void unsetDebugTransport();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getDebugTransport <em>Debug Transport</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Debug Transport</em>' attribute is set.
	 * @see #unsetDebugTransport()
	 * @see #getDebugTransport()
	 * @see #setDebugTransport(short)
	 * @generated
	 */
	boolean isSetDebugTransport();

	/**
	 * Returns the value of the '<em><b>Memory Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Ap Index</em>' attribute.
	 * @see #isSetMemoryApIndex()
	 * @see #unsetMemoryApIndex()
	 * @see #setMemoryApIndex(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_MemoryApIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='MemoryApIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getMemoryApIndex();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getMemoryApIndex <em>Memory Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Ap Index</em>' attribute.
	 * @see #isSetMemoryApIndex()
	 * @see #unsetMemoryApIndex()
	 * @see #getMemoryApIndex()
	 * @generated
	 */
	void setMemoryApIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getMemoryApIndex <em>Memory Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMemoryApIndex()
	 * @see #getMemoryApIndex()
	 * @see #setMemoryApIndex(short)
	 * @generated
	 */
	void unsetMemoryApIndex();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getMemoryApIndex <em>Memory Ap Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Memory Ap Index</em>' attribute is set.
	 * @see #unsetMemoryApIndex()
	 * @see #getMemoryApIndex()
	 * @see #setMemoryApIndex(short)
	 * @generated
	 */
	boolean isSetMemoryApIndex();

	/**
	 * Returns the value of the '<em><b>Jtag Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jtag Ap Index</em>' attribute.
	 * @see #isSetJtagApIndex()
	 * @see #unsetJtagApIndex()
	 * @see #setJtagApIndex(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_JtagApIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='JtagApIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getJtagApIndex();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getJtagApIndex <em>Jtag Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jtag Ap Index</em>' attribute.
	 * @see #isSetJtagApIndex()
	 * @see #unsetJtagApIndex()
	 * @see #getJtagApIndex()
	 * @generated
	 */
	void setJtagApIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getJtagApIndex <em>Jtag Ap Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJtagApIndex()
	 * @see #getJtagApIndex()
	 * @see #setJtagApIndex(short)
	 * @generated
	 */
	void unsetJtagApIndex();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getJtagApIndex <em>Jtag Ap Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jtag Ap Index</em>' attribute is set.
	 * @see #unsetJtagApIndex()
	 * @see #getJtagApIndex()
	 * @see #setJtagApIndex(short)
	 * @generated
	 */
	boolean isSetJtagApIndex();

	/**
	 * Returns the value of the '<em><b>Use Mem Ap For Mem Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Mem Ap For Mem Access</em>' attribute.
	 * @see #isSetUseMemApForMemAccess()
	 * @see #unsetUseMemApForMemAccess()
	 * @see #setUseMemApForMemAccess(short)
	 * @see devicesPackage.DevicesPackage#getDAPType_UseMemApForMemAccess()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='UseMemApForMemAccess' namespace='##targetNamespace'"
	 * @generated
	 */
	short getUseMemApForMemAccess();

	/**
	 * Sets the value of the '{@link Devices.DAPType#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Mem Ap For Mem Access</em>' attribute.
	 * @see #isSetUseMemApForMemAccess()
	 * @see #unsetUseMemApForMemAccess()
	 * @see #getUseMemApForMemAccess()
	 * @generated
	 */
	void setUseMemApForMemAccess(short value);

	/**
	 * Unsets the value of the '{@link Devices.DAPType#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUseMemApForMemAccess()
	 * @see #getUseMemApForMemAccess()
	 * @see #setUseMemApForMemAccess(short)
	 * @generated
	 */
	void unsetUseMemApForMemAccess();

	/**
	 * Returns whether the value of the '{@link Devices.DAPType#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Mem Ap For Mem Access</em>' attribute is set.
	 * @see #unsetUseMemApForMemAccess()
	 * @see #getUseMemApForMemAccess()
	 * @see #setUseMemApForMemAccess(short)
	 * @generated
	 */
	boolean isSetUseMemApForMemAccess();

} // DAPType
