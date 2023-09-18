/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.probe.scan;

/**
 * @author vinod.appu
 *
 */
public class TargetState {
	public static final int RUNNING = 1;
	public static final int HALTED = 0;
	public static final int UNKNOWN = -1;
	
	private int targetStatus = -1;
	private int targetProgramCounterValue;

	public int getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(int targetStatus) {
		this.targetStatus = targetStatus;
	}

	public int getTargetProgramCounterValue() {
		return targetProgramCounterValue;
	}

	public void setTargetProgramCounterValue(int targetProgramCounterValue) {
		this.targetProgramCounterValue = targetProgramCounterValue;
	}

	@Override
	public String toString() {
		return "TargetState [targetStatus=" + targetStatus + ", targetProgramCounterValue=" + targetProgramCounterValue
				+ "]";
	}
}
