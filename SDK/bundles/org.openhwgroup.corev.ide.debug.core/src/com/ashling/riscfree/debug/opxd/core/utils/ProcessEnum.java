package com.ashling.riscfree.debug.opxd.core.utils;

/**
 * @author promod.kumar
 * 
 * @implNote Enum that represents Process Names.
 *
 */

public enum ProcessEnum {

	JTAGSERVER("jtagserver.exe","jtagd"); //$NON-NLS-1$

	private String winProcessName;
	private String linProcessName;
	
	public String getWinProcessName() {
		return winProcessName;
	}

	public String getLinProcessName() {
		return linProcessName;
	}
	
	private ProcessEnum(String winProcessName,String linProcessName) {
		this.winProcessName=winProcessName;
		this.linProcessName=linProcessName;
	}
}
