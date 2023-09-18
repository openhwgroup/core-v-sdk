/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.probe.scan;

/**
 * @author vinod.appu
 *
 */
public enum CoreType {
	ARC(0XA), RISC(0XB), ARM(0xC);

	int value;

	CoreType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
