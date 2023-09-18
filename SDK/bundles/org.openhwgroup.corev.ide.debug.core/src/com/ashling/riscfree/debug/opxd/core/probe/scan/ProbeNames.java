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
 * Vinod appu P.G. - 27-09-2012 - Override toString.
 *******************************************************************************/
package com.ashling.riscfree.debug.opxd.core.probe.scan;

/**
 * ProbeNames defines the names of Ashling debug probes.
 * 
 * @author vinod.appu
 * 
 */
public enum ProbeNames {
	/** Denotes Ashling Opella-XD debug probe.*/
	OPELLA_XD;
	
	@Override
	public String toString() {
		String probeName;
		switch (this) {
		case OPELLA_XD:
			probeName = "Opella-XD";
			break;
		default:
			probeName = "Invalid Debug probe";
			break;
		}
		return probeName;
	};
}
