package com.ashling.riscfree.debug.osawareness.linux.util;

import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMEvent;
import org.eclipse.cdt.dsf.debug.service.IRunControl;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IContainerDMContext;
import org.eclipse.cdt.dsf.mi.service.command.events.MIStoppedEvent;
import org.eclipse.cdt.dsf.service.DsfServiceEventHandler;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Acts as a target stopped event listener, there by sending the event to the
 * waiting consumer of this class.
 *
 */
public class TargetHaltListener {

	private DsfSession session;
	private IContainerDMContext processCtx;
	private Object syncObj;
	private IDMEvent<?> stopEvent;
	private String errorMsg;
	
	public TargetHaltListener(DsfSession session, IContainerDMContext processCtx) {
		super();
		this.session = session;
		this.processCtx = processCtx;
		this.syncObj = new Object();
	}
	
	public void startListening() {
		this.session.addServiceEventListener(this, null);
	}
	
	@DsfServiceEventHandler
	public void eventDispatched(final IRunControl.ISuspendedDMEvent e) {
		processEvent(e);
	}
	
	@DsfServiceEventHandler
	public void eventDispatched(final MIStoppedEvent e) {
		processEvent(e);
	}
	
	public IDMEvent<?> getStopEvent() throws InterruptedException {
		return stopEvent;
	}
	
	/**
	 * This method will block the calling thread until we receive the first stopped event or we have any errors reported.
	 * @return
	 * @throws InterruptedException
	 */
	public boolean waitForTargetToHalt(IProgressMonitor monitor) throws InterruptedException {
		if (stopEvent == null) {
			synchronized (syncObj) {
				while (stopEvent == null && errorMsg == null && !monitor.isCanceled()) {
					syncObj.wait(500);
				}
			}
		}
		return errorMsg == null && !monitor.isCanceled() && stopEvent != null;
	}
	
	public void reportError(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErrorMessage() {
		return errorMsg;
	}
	
	/**
	 * If the event is already processed for the corresponding Container context already, 
	 * the new events should be ignored.
	 * @param event
	 * @return
	 */
	private synchronized boolean processEvent(IDMEvent<?> event) {
		if (stopEvent == null && processCtx != null
				&& processCtx.equals(DMContexts.getAncestorOfType(event.getDMContext(), IContainerDMContext.class))) {
			this.session.removeServiceEventListener(this);
			stopEvent = event;
			synchronized (syncObj) {
				syncObj.notify();
			}
			return true;
		}
		return false;
	}
}
