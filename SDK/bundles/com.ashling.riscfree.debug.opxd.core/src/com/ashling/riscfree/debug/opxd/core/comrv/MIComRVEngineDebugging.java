package com.ashling.riscfree.debug.opxd.core.comrv;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.mi.service.command.commands.MIInterpreterExecConsole;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;


public class MIComRVEngineDebugging extends MIInterpreterExecConsole<MIInfo>{
	
	public static final String ENABLE_OVERLAY = "set skip-ovlmgr 0";
	public static final String DISABLE_OVERLAY = "set skip-ovlmgr 1";
	
	public MIComRVEngineDebugging(IDMContext ctx, boolean isOverlayEnabled) {
		
		super(ctx, (isOverlayEnabled? ENABLE_OVERLAY:DISABLE_OVERLAY));    

	}
	
}