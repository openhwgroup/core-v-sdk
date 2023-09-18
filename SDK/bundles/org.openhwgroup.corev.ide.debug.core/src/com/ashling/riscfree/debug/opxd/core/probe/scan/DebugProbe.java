/*******************************************************************************
 * Copyright (c) 2012 Ashling Microsystems Ltd.
 * All rights reserved. 
 * 
 * This software is the confidential and proprietary information of 
 * Ashling Microsystems Ltd. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ashling.
 * 
 * Contributors: 
 * Vinod appu P.G. - 18-09-2012 - Initial version
 *******************************************************************************/
package com.ashling.riscfree.debug.opxd.core.probe.scan;

/**
 * DebugProbe is the base class for different debug probes. This class
 * contains the basic details of a debug probe.
 * 
 * @author vinod.appu
 * 
 */
public class DebugProbe {

	String deviceName;
	String serialNumber;
	String displayName;

	/**
	 * Default constructor.
	 */
	public DebugProbe() {
	}

	/**
	 * The constructor which receives serial number as argument.
	 * 
	 * @param serialNumber the serial number of the probe.
	 */
	public DebugProbe(String serialNumber, String devName, String displayName) {
		this.serialNumber = serialNumber;
		deviceName = devName;
		this.displayName = displayName;
	}


	/**
	 * Returns the Device name of this debug probe.
	 * 
	 * @return the Device name of this debug probe.
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * Returns the serial number of this debug probe.
	 * 
	 * @return the serial number of the debug probe.
	 */
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Returns the display name of this debug probe.
	 * 
	 * @return the display name of the debug probe.
	 */
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "DebugProbe [deviceName=" + deviceName + ", serialNumber=" + serialNumber + ", displayName="
				+ displayName + "]";
	}
}
