/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import java.util.LinkedList;
import java.util.List;

/**
 * @author vinod.appu
 *
 */
public class OverlayGroup {

	private int id;
	private long crc;
	private long size;
	private long start;
	private long end;
	private long padding;
	private List<OverlaySymbol> overlaySymbolList = new LinkedList<>();

	public OverlayGroup(int id, long start, long end, long size) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.size = end - start;
	}

	public int getId() {
		return id;
	}

	public long getSize() {
		return size;
	}

	public long getCRC() {
		return this.crc;
	}

	public void setCRC(long crc) {
		this.crc = crc;
	}

	public void addOverlaySymbol(OverlaySymbol overlaySymbol) {
		getOverlaySymbolList().add(overlaySymbol);
	}

	public void addOverlaySymbols(List<OverlaySymbol> overlaySymbols) {
		overlaySymbolList.addAll(overlaySymbols);
	}

	public List<OverlaySymbol> getOverlaySymbolList() {
		return overlaySymbolList;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "Group " + this.id + " CRC = " + this.crc + " Size " + this.size;
	}

	public void setPadding(long padding) {
		this.padding = padding;

	}

	public long getPadding() {
		return this.padding;
	}
}
