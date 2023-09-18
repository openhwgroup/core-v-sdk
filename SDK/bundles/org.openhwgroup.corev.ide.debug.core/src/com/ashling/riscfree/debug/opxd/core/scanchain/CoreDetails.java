/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.scanchain;

/**
 * @author vinod.appu
 *
 */
public class CoreDetails {
	private int coreId;
	private String name;
	private int coreIndex;

	public CoreDetails(int coreHash, String name, int coreIndex) {
		this.coreId = coreHash;
		this.name = name;
		this.coreIndex = coreIndex;
	}

	public CoreDetails() {
	}

	public int getCoreId() {
		return coreId;
	}

	public void setCoreId(int coreId) {
		this.coreId = coreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCoreIndex() {
		return coreIndex;
	}

	public void setCoreIndex(int coreIndex) {
		this.coreIndex = coreIndex;
	}

	public String getCoreIdInHexString() {
		return "0x" + Integer.toHexString(this.coreId).toUpperCase();
	}

	public String getFormattedCoreIDString() {
		StringBuilder formattedBuffer = new StringBuilder();
		formattedBuffer.append("0x");
		String coreIDHexString = Integer.toHexString(coreId);
		//Fill zeros to make 8 digits
		for (int i = coreIDHexString.length() + 1; i <= 8; i++) {
			formattedBuffer.append("0");
		}
		formattedBuffer.append(coreIDHexString.toUpperCase());
		return formattedBuffer.toString();
	}

	@Override
	public String toString() {
		return "CoreDetails [coreId=" + coreId + ", name=" + name + ", coreIndex=" + coreIndex + "]";
	}
}
