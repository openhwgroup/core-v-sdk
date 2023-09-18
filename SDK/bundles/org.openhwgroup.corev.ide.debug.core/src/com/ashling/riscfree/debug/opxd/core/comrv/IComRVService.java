/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import java.util.List;

/**
 * @author vinod.appu
 *
 */
public interface IComRVService {
	
	List<OverlayGroup> getOverlayGroups();
	
	String getLoadedPhysicalAddress(String overlaySymbolName);
	
	boolean isOverlaySymbol(String overlaySymbolName);
	
	boolean isLoadedOverlaySymbol(String overlaySymbolName);
}
