package com.ashling.riscfree.debug.opxd.core.comrv;

public class CacheEntry {

	String cacheIndex;
	String overlayGroup;

	public CacheEntry(String cacheIndex, String overlayGroup) {
		this.cacheIndex = cacheIndex;
		this.overlayGroup = overlayGroup;
	}

	public String getCacheIndex() {
		return cacheIndex;
	}

	public String getOverlayGroup() {
		return overlayGroup;
	}
}
