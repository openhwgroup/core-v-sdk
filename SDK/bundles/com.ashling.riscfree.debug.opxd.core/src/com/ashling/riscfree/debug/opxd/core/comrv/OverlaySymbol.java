/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinod.appu
 *
 */
public class OverlaySymbol {

	private String name;
	private Map<OverlayGroup, OverlayGroupInfo> overlayGroupToVirtualAddressMap = new HashMap<>();

	public OverlaySymbol(String name, OverlayGroupInfo overlayInfo) {
		this.name = name;
		overlayGroupToVirtualAddressMap.put(overlayInfo.getOverlayGroup(), overlayInfo);
	}

	public String getName() {
		return name;
	}

	public String getToken(OverlayGroup group) {
		return overlayGroupToVirtualAddressMap.get(group).getToken();
	}

	public long getVirtualStartAddress(OverlayGroup group) {
		return overlayGroupToVirtualAddressMap.get(group).getVirtualAddress();
	}

	public void addGroupInfo(OverlayGroupInfo overlayInfo) {
		this.overlayGroupToVirtualAddressMap.put(overlayInfo.getOverlayGroup(), overlayInfo);
	}

	public boolean isMultigroupSymbol() {
		return this.overlayGroupToVirtualAddressMap.size() > 1;
	}
}
