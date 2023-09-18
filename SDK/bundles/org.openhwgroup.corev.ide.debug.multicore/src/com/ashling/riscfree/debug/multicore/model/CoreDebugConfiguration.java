package com.ashling.riscfree.debug.multicore.model;

/**
 * @author vinod.appu
 *
 *         Information to debug a core in multicore launch
 */
public class CoreDebugConfiguration {

	private String coreName;
	private String coreId;
	private String debuggerName; // Debugger which is going to use for debugging this core

	public String getCoreName() {
		return coreName;
	}

	public String getCoreId() {
		return coreId;
	}

	public CoreDebugConfiguration(String coreID, String coreName, String debuggerName) {
		this.coreName = coreName;
		this.coreId = coreID;
		this.debuggerName = debuggerName;
	}

	public String getDebuggerName() {
		return debuggerName;
	}
}
