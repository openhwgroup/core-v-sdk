/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.CoreType#getDAP <em>DAP</em>}</li>
 *   <li>{@link Devices.CoreType#getTap <em>Tap</em>}</li>
 *   <li>{@link Devices.CoreType#getVJTAG <em>VJTAG</em>}</li>
 *   <li>{@link Devices.CoreType#getDebugBaseAddress <em>Debug Base Address</em>}</li>
 *   <li>{@link Devices.CoreType#getMemory <em>Memory</em>}</li>
 *   <li>{@link Devices.CoreType#getGDBRegFile <em>GDB Reg File</em>}</li>
 *   <li>{@link Devices.CoreType#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link Devices.CoreType#getFamily <em>Family</em>}</li>
 *   <li>{@link Devices.CoreType#getName <em>Name</em>}</li>
 *   <li>{@link Devices.CoreType#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getCoreType()
 * @model extendedMetaData="name='Core_._type' kind='elementOnly'"
 * @generated
 */
public interface CoreType extends EObject {
	/**
	 * Returns the value of the '<em><b>DAP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DAP</em>' containment reference.
	 * @see #setDAP(DAPType)
	 * @see devicesPackage.DevicesPackage#getCoreType_DAP()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DAP' namespace='##targetNamespace'"
	 * @generated
	 */
	DAPType getDAP();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getDAP <em>DAP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DAP</em>' containment reference.
	 * @see #getDAP()
	 * @generated
	 */
	void setDAP(DAPType value);

	/**
	 * Returns the value of the '<em><b>Tap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tap</em>' containment reference.
	 * @see #setTap(TapType)
	 * @see devicesPackage.DevicesPackage#getCoreType_Tap()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Tap' namespace='##targetNamespace'"
	 * @generated
	 */
	TapType getTap();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getTap <em>Tap</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tap</em>' containment reference.
	 * @see #getTap()
	 * @generated
	 */
	void setTap(TapType value);

	/**
	 * Returns the value of the '<em><b>VJTAG</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VJTAG</em>' containment reference.
	 * @see #setVJTAG(VJTAGType)
	 * @see devicesPackage.DevicesPackage#getCoreType_VJTAG()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='VJTAG' namespace='##targetNamespace'"
	 * @generated
	 */
	VJTAGType getVJTAG();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getVJTAG <em>VJTAG</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VJTAG</em>' containment reference.
	 * @see #getVJTAG()
	 * @generated
	 */
	void setVJTAG(VJTAGType value);

	/**
	 * Returns the value of the '<em><b>Debug Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Base Address</em>' attribute.
	 * @see #setDebugBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getCoreType_DebugBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='DebugBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDebugBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getDebugBaseAddress <em>Debug Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Base Address</em>' attribute.
	 * @see #getDebugBaseAddress()
	 * @generated
	 */
	void setDebugBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>Memory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory</em>' containment reference.
	 * @see #setMemory(MemoryType)
	 * @see devicesPackage.DevicesPackage#getCoreType_Memory()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Memory' namespace='##targetNamespace'"
	 * @generated
	 */
	MemoryType getMemory();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getMemory <em>Memory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory</em>' containment reference.
	 * @see #getMemory()
	 * @generated
	 */
	void setMemory(MemoryType value);

	/**
	 * Returns the value of the '<em><b>GDB Reg File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>GDB Reg File</em>' attribute.
	 * @see #setGDBRegFile(String)
	 * @see devicesPackage.DevicesPackage#getCoreType_GDBRegFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='GDBRegFile' namespace='##targetNamespace'"
	 * @generated
	 */
	String getGDBRegFile();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getGDBRegFile <em>GDB Reg File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>GDB Reg File</em>' attribute.
	 * @see #getGDBRegFile()
	 * @generated
	 */
	void setGDBRegFile(String value);

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #setArchitecture(String)
	 * @see devicesPackage.DevicesPackage#getCoreType_Architecture()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Architecture' namespace='##targetNamespace'"
	 * @generated
	 */
	String getArchitecture();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family</em>' attribute.
	 * @see #setFamily(String)
	 * @see devicesPackage.DevicesPackage#getCoreType_Family()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Family' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFamily();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getFamily <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' attribute.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see devicesPackage.DevicesPackage#getCoreType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #isSetNumber()
	 * @see #unsetNumber()
	 * @see #setNumber(short)
	 * @see devicesPackage.DevicesPackage#getCoreType_Number()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='attribute' name='Number' namespace='##targetNamespace'"
	 * @generated
	 */
	short getNumber();

	/**
	 * Sets the value of the '{@link Devices.CoreType#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #isSetNumber()
	 * @see #unsetNumber()
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(short value);

	/**
	 * Unsets the value of the '{@link Devices.CoreType#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumber()
	 * @see #getNumber()
	 * @see #setNumber(short)
	 * @generated
	 */
	void unsetNumber();

	/**
	 * Returns whether the value of the '{@link Devices.CoreType#getNumber <em>Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number</em>' attribute is set.
	 * @see #unsetNumber()
	 * @see #getNumber()
	 * @see #setNumber(short)
	 * @generated
	 */
	boolean isSetNumber();

} // CoreType
