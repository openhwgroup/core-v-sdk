/**
 * 
 */
package com.ashling.riscfree.debug.opxd.registers.core;

import org.eclipse.cdt.dsf.debug.service.IRegisters.IBitGroup;

/**
 * @author IOT2
 *
 */
class BitGroup  implements IBitGroup{

	private int startBit;
	private int bitCount;
	public BitGroup(int startBit, int endBit) {
		this.startBit = startBit;
		this.bitCount = Math.abs(endBit - startBit)+1;
	}
	
	@Override
	public int startBit()
	{
		return this.startBit;
	}
	
	@Override
	public int bitCount()
	{
		return this.bitCount;
	}
}
