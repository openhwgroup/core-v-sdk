/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ashling Processor Data Base Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.AshlingProcessorDataBaseType#getProcessor <em>Processor</em>}</li>
 *   <li>{@link Devices.AshlingProcessorDataBaseType#getDate <em>Date</em>}</li>
 *   <li>{@link Devices.AshlingProcessorDataBaseType#getFamily <em>Family</em>}</li>
 *   <li>{@link Devices.AshlingProcessorDataBaseType#getSubSet <em>Sub Set</em>}</li>
 *   <li>{@link Devices.AshlingProcessorDataBaseType#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType()
 * @model extendedMetaData="name='AshlingProcessorDataBase_._type' kind='elementOnly'"
 * @generated
 */
public interface AshlingProcessorDataBaseType extends EObject {
	/**
	 * Returns the value of the '<em><b>Processor</b></em>' containment reference list.
	 * The list contents are of type {@link Devices.ProcessorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor</em>' containment reference list.
	 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType_Processor()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Processor' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ProcessorType> getProcessor();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(XMLGregorianCalendar)
	 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType_Date()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
	 *        extendedMetaData="kind='attribute' name='Date' namespace='##targetNamespace'"
	 * @generated
	 */
	XMLGregorianCalendar getDate();

	/**
	 * Sets the value of the '{@link Devices.AshlingProcessorDataBaseType#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family</em>' attribute.
	 * @see #setFamily(String)
	 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType_Family()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Family' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFamily();

	/**
	 * Sets the value of the '{@link Devices.AshlingProcessorDataBaseType#getFamily <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' attribute.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(String value);

	/**
	 * Returns the value of the '<em><b>Sub Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Set</em>' attribute.
	 * @see #setSubSet(String)
	 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType_SubSet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='SubSet' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSubSet();

	/**
	 * Sets the value of the '{@link Devices.AshlingProcessorDataBaseType#getSubSet <em>Sub Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Set</em>' attribute.
	 * @see #getSubSet()
	 * @generated
	 */
	void setSubSet(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #setVersion(short)
	 * @see devicesPackage.DevicesPackage#getAshlingProcessorDataBaseType_Version()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte" required="true"
	 *        extendedMetaData="kind='attribute' name='Version' namespace='##targetNamespace'"
	 * @generated
	 */
	short getVersion();

	/**
	 * Sets the value of the '{@link Devices.AshlingProcessorDataBaseType#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(short value);

	/**
	 * Unsets the value of the '{@link Devices.AshlingProcessorDataBaseType#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersion()
	 * @see #getVersion()
	 * @see #setVersion(short)
	 * @generated
	 */
	void unsetVersion();

	/**
	 * Returns whether the value of the '{@link Devices.AshlingProcessorDataBaseType#getVersion <em>Version</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Version</em>' attribute is set.
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @see #setVersion(short)
	 * @generated
	 */
	boolean isSetVersion();

} // AshlingProcessorDataBaseType
