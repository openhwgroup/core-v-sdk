/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

/**
 * @author vinod.appu
 *
 *One symbol can be present in multiple Overlay groups with different token and virtual address
 */
public class OverlayGroupInfo {

	private long virtualAddress;
	private String token;
	private OverlayGroup overlayGroup;

	public OverlayGroupInfo(long virtualAddress, String token, OverlayGroup overlayGroup) {
		this.virtualAddress = virtualAddress;
		this.token = token;
		this.overlayGroup = overlayGroup;
	}

	public long getVirtualAddress() {
		return virtualAddress;
	}

	public String getToken() {
		return token;
	}

	public OverlayGroup getOverlayGroup() {
		return overlayGroup;
	}
}
