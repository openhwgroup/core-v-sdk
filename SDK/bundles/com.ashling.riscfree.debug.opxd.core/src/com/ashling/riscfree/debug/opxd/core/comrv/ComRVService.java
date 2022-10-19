/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExitedDMEvent;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IResumedDMEvent;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IStartedDMEvent;
import org.eclipse.cdt.dsf.debug.service.IRunControl.ISuspendedDMEvent;
import org.eclipse.cdt.dsf.debug.service.command.ICommand;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService;
import org.eclipse.cdt.dsf.mi.service.command.commands.CLICommand;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.AbstractDsfService;
import org.eclipse.cdt.dsf.service.DsfServiceEventHandler;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import com.ashling.riscfree.debug.opxd.core.Activator;
import com.ashling.riscfree.debug.opxd.core.ui.Messages;

/**
 * @author vinod.appu
 *
 */
public class ComRVService extends AbstractDsfService implements IComRVService {

	private static final String COMRV_STATUS_COMMAND = "comrv status";
	private List<OverlayGroup> overlayGroup;
	private String mapFilePath;
	private ExecutorService mapFileParser;
	Future<?> mapFileParserFuture;
	private static final String OVERLAY_MAPPING_START_STRING = "Current overlay mappings";
	private Map<String, String> overlaySymbolMap;
	private Map<String, String> loadedPhysicalAddressMap = new HashMap<>();
	private List<String> loadedOverlaySymbols = new ArrayList<>();
	private List<String> overlaySymbols = new ArrayList<>();
	HashMap<String, CFunctionDetails> symbolList = new HashMap<>();
	MapFileParser parser;

	public ComRVService(DsfSession session, String mapFilePath) {
		super(session);
		this.mapFilePath = mapFilePath;
		mapFileParser = Executors.newFixedThreadPool(1);
		getSession().addServiceEventListener(this, null);
	}

	@Override
	protected BundleContext getBundleContext() {
		return Activator.getDefault().getBundle().getBundleContext();
	}

	@Override
	public void initialize(RequestMonitor rm) {
		parser = new MapFileParser();
		mapFileParserFuture = mapFileParser.submit(() -> {
			this.overlayGroup = parser.parseOverlayMapFile(this.mapFilePath);
		});
		register(new String[] { IComRVService.class.getName() }, new Hashtable<>());
		super.initialize(rm);
	}

	@Override
	public void shutdown(RequestMonitor rm) {
		mapFileParser.shutdown();
		mapFileParser.shutdownNow();
		super.shutdown(rm);
	}

	@Override
	public List<OverlayGroup> getOverlayGroups() {
		// Make sure parsing .map file is done before returning the list.
		// 30 seconds should be enough to parse.
		try {
			mapFileParserFuture.get(30, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			Activator.logErrorMessage(Messages.getString("Comrv.parsing_error"));
			Activator.log(e);
		}
		return this.overlayGroup;
	}

	@Override
	public String getLoadedPhysicalAddress(String overlaySymbolName) {
		for (Map.Entry<String, String> entry : loadedPhysicalAddressMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(overlaySymbolName)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean isOverlaySymbol(String overlaySymbolName) {
		return overlaySymbols.contains(overlaySymbolName);
	}

	@Override
	public boolean isLoadedOverlaySymbol(String overlaySymbolName) {
		return loadedOverlaySymbols.contains(overlaySymbolName);
	}

	@DsfServiceEventHandler
	public void launchHalted(ISuspendedDMEvent suspendedDMEvent) {
		parseComrvStatus(suspendedDMEvent.getDMContext());
	}

	@DsfServiceEventHandler
	public void launchStarted(IStartedDMEvent startedDMEvent) {
		parseComrvStatus(startedDMEvent.getDMContext());
	}

	@DsfServiceEventHandler
	public void launchTerminated(IExitedDMEvent exitedDMEvent) {
		ComRVAnnotationModelTracker.getInstance().clearSelections();
	}

	@DsfServiceEventHandler
	public void launchResumed(IResumedDMEvent resumeDMEvent) {
		ComRVAnnotationModelTracker.getInstance().clearSelections();
	}

	private void executeGDBCommand(String command, IExecutionDMContext context, DataRequestMonitor<MIInfo> rm) {
		ICommand<MIInfo> cmd = new CLICommand<>(context, command);

		ICommandControlService commandControl = getServicesTracker().getService(ICommandControlService.class);
		if (commandControl != null) {
			commandControl.queueCommand(cmd, rm);
		} else {
			// Should not happen, so log the situation but then ignore it
			rm.setStatus(new Status(IStatus.INFO, Activator.PLUGIN_ID, Messages.getString("GDB.CLI_command_error"))); //$NON-NLS-1$
		}
	}

	private void parseComrvStatus(IExecutionDMContext context) {
		overlaySymbolMap = parser.getSymbolMap();
		loadedPhysicalAddressMap.clear();
		loadedOverlaySymbols.clear();
		executeGDBCommand(COMRV_STATUS_COMMAND, context, new DataRequestMonitor<MIInfo>(getExecutor(), null) {
			@Override
			protected void handleCompleted() {
				if (isSuccess()) {
					List<String> processedGroupIdList = new ArrayList<>();
					String command = getData().toString();
					if (!command.isEmpty()) {
						Scanner sc = new Scanner(command);
						boolean overlayFound = false;
						while (sc.hasNextLine()) {
							String line = sc.nextLine();
							// From the "Current overlay mappings" line from the comrv status reply start
							// parsing
							if (line.contains(OVERLAY_MAPPING_START_STRING) || overlayFound) {
								if (!overlayFound) {
									// skip first 2 line which contains column names
									for (int i = 0; i < 2; i++) {
										sc.nextLine();
									}
									overlayFound = true;
								} else {
									String[] splited = line.split("\\s+");
									// make sure that after splitting the array contains overlay mapping values
									if (splited.length > 11) {
										final String groupIdString = splited[2].trim(); 
										int groupId = Integer.parseInt(groupIdString);
										//One loaded group has to be processed only once, all the symbols in the group are loaded
										if(processedGroupIdList.contains(groupIdString))
										{
											continue;
										}
										processedGroupIdList.add(groupIdString);
										
										long cacheAddress = Long.decode(splited[4]);
										Optional<OverlayGroup> overlayGroupOptional = overlayGroup.stream()
												.filter(p -> p.getId() == groupId).findFirst();
										if (overlayGroupOptional.isPresent()) {
											overlayGroupOptional.ifPresent(
													group -> group.getOverlaySymbolList().stream().forEach(symbol -> {
														loadedOverlaySymbols.add(symbol.getName());
														loadedPhysicalAddressMap.put(symbol.getName(), Long.toHexString(
																cacheAddress + getSymbolOffsetInGroup(group, symbol)));
													}));
										}
									}
								}
							}
						}
						sc.close();
						overlaySymbols = overlaySymbolMap.keySet().stream()
								.collect(Collectors.toCollection(ArrayList::new));
					}
					ComRVAnnotationModelTracker.getInstance().annotateAllCEditors(overlaySymbols, loadedOverlaySymbols);
				}
			}
		});

	}

	private long getSymbolOffsetInGroup(OverlayGroup group, OverlaySymbol symbol) {
		List<OverlaySymbol> overlaySymbolList = group.getOverlaySymbolList();
		long virtualStartAddress = overlaySymbolList.get(0).getVirtualStartAddress(group);
		return symbol.getVirtualStartAddress(group) - virtualStartAddress;
	}
}
