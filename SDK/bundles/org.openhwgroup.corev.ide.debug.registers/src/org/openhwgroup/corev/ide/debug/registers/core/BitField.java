/**
 * 
 */
package org.openhwgroup.corev.ide.debug.registers.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VA
 *
 */
class BitField {

	private String name;
	private String description;
	private Long value;
	boolean isReadable;
	boolean isReadOnce;
	boolean isWritable;
	boolean hasSideEffects;
	boolean isZerobasedNumbering;
	boolean isZeroBitLeftMost;
	boolean isWritableOnce;
	private List<BitGroup> bitGroupList;
	private List<Mnemonic> mnemonics;

	public BitField(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isReadable() {
		return isReadable;
	}

	public boolean isReadOnce() {
		return isReadOnce;
	}

	public boolean isWritable() {
		return isWritable;
	}

	public boolean isHasSideEffects() {
		return hasSideEffects;
	}

	public boolean isZerobasedNumbering() {
		return isZerobasedNumbering;
	}

	public boolean isZeroBitLeftMost() {
		return isZeroBitLeftMost;
	}

	public List<BitGroup> getBitGroupList() {
		return bitGroupList;
	}

	public List<Mnemonic> getMnemonics() {
		if (null == mnemonics) {
			return new ArrayList<Mnemonic>();
		}
		return mnemonics;
	}

	public void setBitGroupList(List<BitGroup> bitGroupList) {
		this.bitGroupList = bitGroupList;
	}

	public void setMnemonics(List<Mnemonic> mnemonics) {
		this.mnemonics = mnemonics;
	}

	@Override
	public String toString() {
		return name + "\t" + description + "\n"; //$NON-NLS-1$
	}

	public boolean isWriteOnce() {
		return isWritableOnce;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
