package com.ashling.riscfree.debug.osawareness.linux.view;

import java.util.Optional;

import org.eclipse.cdt.debug.ui.CDebugUIPlugin;
import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IWatchExpression;
import org.eclipse.debug.internal.core.IInternalDebugCoreConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;

import com.ashling.riscfree.debug.opxd.core.utils.DSFUtility;
import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.Messages;
import com.ashling.riscfree.debug.osawareness.linux.ui.DebugAlreadyRunningModuleDialog;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;

/**
 * Ease View class for Linux Modules
 *
 */
public class OSAwareLinuxModuleDebugView extends OSAwareLinuxDebugView {
	private Action watchModule;
	private Action loadModuleSymbol;
	private TreeViewer viewer;

	@Override
	protected void createActions() {
		if (!isStaticDebugView()) {
			// Watch Action
			createWatchAction();
			createLoadModuleAction();
		}
		super.createActions();
	}

	private void createWatchAction() {
		watchModule = new Action(Messages.Watch) {
			@Override
			public void run() {
				if (viewer instanceof TreeViewer) {
					TreeItem[] item = ((TreeViewer) viewer).getTree().getSelection();
					if (item.length > 0 && isAValidSelection(item[0])) {
						final IWatchExpression watchExpression = DebugPlugin.getDefault().getExpressionManager()
								.newWatchExpression(IInternalDebugCoreConstants.EMPTY_STRING);
						watchExpression.setExpressionText("(struct module*)" //$NON-NLS-1$
								+ item[0].getText(0));
						DebugPlugin.getDefault().getExpressionManager().addExpression(watchExpression);
						showExpressionsView();
					}
				}
			}
		};
		watchModule.setToolTipText(Messages.Watch);
		watchModule.setImageDescriptor(Activator.getImageDescriptor("icons/watch_exp.gif"));
	}

	private void createLoadModuleAction() {
		// Load Module Symbol Action
		loadModuleSymbol = new Action(Messages.Load_module_symbol) {
			@Override
			public void run() {
				if (viewer instanceof TreeViewer) {
					OSAwarenessDebugUtil.performLinuxAction(() -> {
						TreeItem[] item = ((TreeViewer) viewer).getTree().getSelection();
						if (item.length > 0 && isAValidSelection(item[0])) {
							String moduleAddr = item[0].getText(0);
							String moduleName = item[0].getText(1);
							if (moduleAddr != null && !moduleAddr.isBlank() && moduleName != null
									&& !moduleName.isBlank()) {
								final DebugAlreadyRunningModuleDialog dlg = DebugAlreadyRunningModuleDialog
										.getDefault(CDebugUIPlugin.getActiveWorkbenchShell(), moduleName);
								if (dlg.open() == Window.OK) {
									final String moduleNameFullpath = dlg.GetText();
									loadModuleSymbol(moduleNameFullpath, moduleAddr);
								}
							}
						}
					});
				}
			}
		};
		loadModuleSymbol.setToolTipText(Messages.Load_module_symbol);
	}

	private void loadModuleSymbol(String moduleNameFullpath, String address) {
		moduleNameFullpath = moduleNameFullpath.replace('\\', '/');
		DsfServicesTracker tracker = null;
		try {
			tracker = OSAwarenessDebugUtil.createDsfServiceTracker();
			Optional<IGDBControl> gdbControl = Optional.ofNullable(tracker)
					.map(trckr -> trckr.getService(IGDBControl.class));
			if (gdbControl.isPresent()) {
				DataRequestMonitor<MIInfo> requestMonitor = new DataRequestMonitor<>(gdbControl.get().getExecutor(),
						null);
				OSAwarenessDebugUtil.addSymSections(gdbControl.get(), moduleNameFullpath, address, requestMonitor);
			}
		} catch (Exception e) {
			Activator.log(e);
			DSFUtility.INSTANCE.openError(Messages.Error, Messages.Failed_to_load_module_symbol, null);
		} finally {
			Optional.ofNullable(tracker).ifPresent(DsfServicesTracker::dispose);
		}
	}
	
	private boolean isAValidSelection(TreeItem treeItem) {
		String moduleAddr = treeItem.getText(0);
		String moduleName = treeItem.getText(1);
		if (moduleAddr != null && !moduleAddr.isBlank() && moduleName != null
				&& !moduleName.isBlank()) {
			return true;
		}
		return false;
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {
		menu.add(watchModule);
		menu.add(loadModuleSymbol);
		super.fillContextMenu(menu);
	}

	@Override
	protected TreeViewer makeViewer(Composite parent) {
		viewer = super.makeViewer(parent);
		return viewer;
	}
}
