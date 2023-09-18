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
 * CommunicationMedium defines the communication interfaces supported
 * by Ashling debug probes.
 * 
 * @author vinod.appu
 * 
 */
public enum CommunicationMedium {
	/** Denotes the USB communication interface.*/
	USB, 
	/** Denotes the Ethernet communication interface.*/
	ETHERNET
}
