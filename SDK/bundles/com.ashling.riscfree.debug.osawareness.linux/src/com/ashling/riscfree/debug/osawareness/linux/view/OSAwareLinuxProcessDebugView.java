package com.ashling.riscfree.debug.osawareness.linux.view;

import java.io.File;
import java.util.ArrayList;
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
import com.ashling.riscfree.debug.osawareness.linux.ui.LoadProcessSymbolDlg;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;

/**
 * Ease View class for Linux Process
 *
 */
public class OSAwareLinuxProcessDebugView extends OSAwareLinuxDebugView {
	private Action watchProcess;
	private Action loadProcessSymbol;
	private TreeViewer viewer;

	@Override
	protected void createActions() {
		if (!isStaticDebugView()) {
			// Watch Action
			createWatchAction();
			// Load Process Symbol Action
			createLoadProcessSymAction();
		}
		super.createActions();
	}

	private void createLoadProcessSymAction() {
		loadProcessSymbol = new Action(Messages.Load_process_symbol) {
			@Override
			public void run() {
				if (viewer instanceof TreeViewer) {
					OSAwarenessDebugUtil.performLinuxAction(() -> {
						TreeItem[] item = ((TreeViewer) viewer).getTree().getSelection();
						if (item.length > 0 && isAValidSelection(item[0])) {
							String processName = item[0].getText(2);
							final LoadProcessSymbolDlg dlg = LoadProcessSymbolDlg
									.getDefault(CDebugUIPlugin.getActiveWorkbenchShell(), processName);
							if (dlg.open() == Window.OK) {
								final File processNameFullpath = dlg.getProcessFile();
								final File rootFileSystemPath = dlg.getRootFile();
								final ArrayList<String> sharedLibraryPath = dlg.getSharedLibSearchList();
								DsfServicesTracker tracker = null;
								try {
									tracker = OSAwarenessDebugUtil.createDsfServiceTracker();
									Optional<IGDBControl> gdbControl = Optional.ofNullable(tracker)
											.map(trckr -> trckr.getService(IGDBControl.class));
									if (gdbControl.isPresent()) {
										final DataRequestMonitor<MIInfo> miInfo = new DataRequestMonitor<MIInfo>(
												gdbControl.get().getExecutor(), null);
										final String absPath = processNameFullpath.getAbsolutePath().replace('\\',
												'/');
										OSAwarenessDebugUtil.addProcessSymFile(gdbControl.get(), absPath);
										if (rootFileSystemPath != null || !sharedLibraryPath.isEmpty()) {
											OSAwarenessDebugUtil.setSharedLibraryPath(gdbControl.get(),
													rootFileSystemPath, sharedLibraryPath);
										}
									}
								} catch (Exception e) {
									Activator.log(e);
									DSFUtility.INSTANCE.openError(Messages.Error, Messages.Failed_to_load_process_symbol,
											null);
								} finally {
									Optional.ofNullable(tracker).ifPresent(DsfServicesTracker::dispose);
								}

							}
						}
					});
				}
			}
		};
		loadProcessSymbol.setToolTipText(Messages.Load_process_symbol);
	}

	private void createWatchAction() {
		watchProcess = new Action(Messages.Watch) {
			@Override
			public void run() {
				if (viewer instanceof TreeViewer) {
					TreeItem[] item = ((TreeViewer) viewer).getTree().getSelection();
					if (item.length > 0 && isAValidSelection(item[0])) {
						final IWatchExpression watchExpression = DebugPlugin.getDefault().getExpressionManager()
								.newWatchExpression(IInternalDebugCoreConstants.EMPTY_STRING);
						watchExpression.setExpressionText("(struct task_struct*)" //$NON-NLS-1$
								+ item[0].getText(0));
						DebugPlugin.getDefault().getExpressionManager().addExpression(watchExpression);
						showExpressionsView();
					}
				}
			}
		};
		watchProcess.setToolTipText(Messages.Watch);
		watchProcess.setImageDescriptor(Activator.getImageDescriptor("icons/watch_exp.gif"));
	}
	
	private boolean isAValidSelection(TreeItem treeItem) {
		String processAddr = treeItem.getText(0);
		String processName = treeItem.getText(2);
		if (processAddr != null && !processAddr.isBlank() && processName != null
				&& !processName.isBlank()) {
			return true;
		}
		return false;
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {
		menu.add(watchProcess);
		menu.add(loadProcessSymbol);
		super.fillContextMenu(menu);
	}

	@Override
	protected TreeViewer makeViewer(Composite parent) {
		viewer = super.makeViewer(parent);
		return viewer;
	}
}
