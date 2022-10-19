package com.ashling.riscfree.debug.osawareness.linux.util;

import java.util.Optional;

import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.IMIContainerDMContext;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Just a POJO class holding all the objects needed to setting a break point at
 * a location and continue.
 *
 */
public class BreakAndContinueToken {
	private String breakLocation;
	private IProgressMonitor monitor;
	private IGDBControl gdbControl;
	private IMIContainerDMContext processContext;
	private TargetHaltListener targetHaltListener;
	private String waitingMonitorTaskText;

	public BreakAndContinueToken(String breakLocation, IProgressMonitor monitor, IGDBControl gdbControl,
			IMIContainerDMContext processContext, TargetHaltListener targetHaltListener,
			String waitingMonitorTaskText) {
		super();
		this.breakLocation = breakLocation;
		this.monitor = monitor;
		this.gdbControl = gdbControl;
		this.processContext = processContext;
		this.targetHaltListener = targetHaltListener;
		this.waitingMonitorTaskText = waitingMonitorTaskText;
	}

	public Optional<String> getBreakLocation() {
		return Optional.ofNullable(breakLocation);
	}

	public IProgressMonitor getMonitor() {
		return monitor;
	}

	public IGDBControl getGdbControl() {
		return gdbControl;
	}

	public IMIContainerDMContext getProcessContext() {
		return processContext;
	}

	public TargetHaltListener getTargetHaltListener() {
		return targetHaltListener;
	}

	public Optional<String> getWaitingMonitorTaskText() {
		return Optional.ofNullable(waitingMonitorTaskText);
	}

	public void setBreakLocation(String breakLocation) {
		this.breakLocation = breakLocation;
	}

	public void setWaitingMonitorTaskText(String waitingMonitorTaskText) {
		this.waitingMonitorTaskText = waitingMonitorTaskText;
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	public void setGdbControl(IGDBControl gdbControl) {
		this.gdbControl = gdbControl;
	}

	public void setProcessContext(IMIContainerDMContext processContext) {
		this.processContext = processContext;
	}

	public void setTargetHaltListener(TargetHaltListener targetHaltListener) {
		this.targetHaltListener = targetHaltListener;
	}
}