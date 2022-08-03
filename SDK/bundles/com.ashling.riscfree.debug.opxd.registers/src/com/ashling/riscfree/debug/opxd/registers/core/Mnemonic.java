/**
 * 
 */
package com.ashling.riscfree.debug.opxd.registers.core;

/**
 * @author IOT2
 *
 */
class Mnemonic {

	String shortName;
	String longName;
	
	//TODO : This field seems not used and incorrect
	int size;

	public Mnemonic(String shortName, String longName, int size) {
		this.shortName = shortName;
		this.longName = longName;
		this.size = size;
	}

	public String getShortName() {
		return this.shortName;
	}

	public String getLongName() {
		return this.longName;
	}
	
	public int getSize()
	{
		return this.size;
	}
}
