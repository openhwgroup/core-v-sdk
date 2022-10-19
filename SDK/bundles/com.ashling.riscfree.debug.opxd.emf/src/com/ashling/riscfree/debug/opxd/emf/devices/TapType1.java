/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tap Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.TapType1#getIRlength <em>IRlength</em>}</li>
 *   <li>{@link Devices.TapType1#getBypassInst <em>Bypass Inst</em>}</li>
 *   <li>{@link Devices.TapType1#getId <em>Id</em>}</li>
 *   <li>{@link Devices.TapType1#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getTapType1()
 * @model extendedMetaData="name='Tap_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface TapType1 extends EObject {
	/**
	 * Returns the value of the '<em><b>IRlength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IRlength</em>' attribute.
	 * @see #isSetIRlength()
	 * @see #unsetIRlength()
	 * @see #setIRlength(short)
	 * @see devicesPackage.DevicesPackage#getTapType1_IRlength()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='element' name='IRlength' namespace='##targetNamespace'"
	 * @generated
	 */
	short getIRlength();

	/**
	 * Sets the value of the '{@link Devices.TapType1#getIRlength <em>IRlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IRlength</em>' attribute.
	 * @see #isSetIRlength()
	 * @see #unsetIRlength()
	 * @see #getIRlength()
	 * @generated
	 */
	void setIRlength(short value);

	/**
	 * Unsets the value of the '{@link Devices.TapType1#getIRlength <em>IRlength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIRlength()
	 * @see #getIRlength()
	 * @see #setIRlength(short)
	 * @generated
	 */
	void unsetIRlength();

	/**
	 * Returns whether the value of the '{@link Devices.TapType1#getIRlength <em>IRlength</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>IRlength</em>' attribute is set.
	 * @see #unsetIRlength()
	 * @see #getIRlength()
	 * @see #setIRlength(short)
	 * @generated
	 */
	boolean isSetIRlength();

	/**
	 * Returns the value of the '<em><b>Bypass Inst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bypass Inst</em>' attribute.
	 * @see #setBypassInst(String)
	 * @see devicesPackage.DevicesPackage#getTapType1_BypassInst()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='BypassInst' namespace='##targetNamespace'"
	 * @generated
	 */
	String getBypassInst();

	/**
	 * Sets the value of the '{@link Devices.TapType1#getBypassInst <em>Bypass Inst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bypass Inst</em>' attribute.
	 * @see #getBypassInst()
	 * @generated
	 */
	void setBypassInst(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(short)
	 * @see devicesPackage.DevicesPackage#getTapType1_Id()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	short getId();

	/**
	 * Sets the value of the '{@link Devices.TapType1#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(short value);

	/**
	 * Unsets the value of the '{@link Devices.TapType1#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(short)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link Devices.TapType1#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(short)
	 * @generated
	 */
	boolean isSetId();

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #isSetNumber()
	 * @see #unsetNumber()
	 * @see #setNumber(short)
	 * @see devicesPackage.DevicesPackage#getTapType1_Number()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='attribute' name='Number' namespace='##targetNamespace'"
	 * @generated
	 */
	short getNumber();

	/**
	 * Sets the value of the '{@link Devices.TapType1#getNumber <em>Number</em>}' attribute.
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
	 * Unsets the value of the '{@link Devices.TapType1#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumber()
	 * @see #getNumber()
	 * @see #setNumber(short)
	 * @generated
	 */
	void unsetNumber();

	/**
	 * Returns whether the value of the '{@link Devices.TapType1#getNumber <em>Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number</em>' attribute is set.
	 * @see #unsetNumber()
	 * @see #getNumber()
	 * @see #setNumber(short)
	 * @generated
	 */
	boolean isSetNumber();

} // TapType1
