/**
 * 
 */
package com.ashling.riscfree.debug.ease.dsf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ease.IExecutionListener;
import org.eclipse.ease.IScriptEngine;
import org.eclipse.ease.Script;
import org.eclipse.ease.ScriptResult;
import org.eclipse.ease.service.EngineDescription;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.ui.PlatformUI;

import com.ashling.riscfree.debug.ease.Activator;
import com.ashling.riscfree.debug.ease.module.GDBModule;

/**
 * @author vinod.appu Service responsible to store and run all the EASE scripts
 *         which has to be executed in background
 *
 */
public enum EASEScriptUtil {
	INSTANCE;

	private static final String SCRIPT_EXEC_JOB_NAME = "Fetching data";
	private static final String SCRIPTS_FOLDER_NAME = "Scripts";
	private static final String POPULATOR_SCRIPT_END = "_populator.py";
	private static final String CONFIGURATOR_SCRIPT_END = "_configurator.py";
	private static Map<String, String> sctiptLocationsMap = Collections.synchronizedMap(new HashMap<>());
	private static EngineDescription engineDescription;
	private static ExecutorService scriptIndexer;
	private static Future<?> indexScriptFeature;

	static {
		// Retrieve the engine aimed to execute Python code
		final IScriptService scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
		
		//TODO: Py4j engine causing multiple issues at the moment
		//engineDescription = scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine");
		engineDescription = scriptService.getEngineByID("org.eclipse.ease.python.jython");

		scriptIndexer = Executors.newFixedThreadPool(1);
		indexScriptFeature = scriptIndexer.submit(() -> indexAllScripts());
	}

	/**
	 * Execute a script and return result
	 * 
	 * @param scriptIdentifier  - can be an absolute file path or an identifier, if
	 *                          identifier is passing, the script should be
	 *                          available in "/script" folder in the installation
	 *                          directory
	 * @param scriptVariables
	 * @param executionListener
	 * @return
	 */
	public Optional<ScriptResult> executeSript(String scriptIdentifier, ScriptVariable[] scriptVariables,
			Optional<IExecutionListener> executionListener) {

		// Indexing has to be completed before running the script
		completeScriptIndexing();

		String scriptFileLocation = null;
		File locationCheckFile = new File(scriptIdentifier);
		if (locationCheckFile.exists()) {
			scriptFileLocation = scriptIdentifier;
		} else {
			scriptFileLocation = sctiptLocationsMap.get(scriptIdentifier);
		}
		if (null == scriptFileLocation || scriptFileLocation.isEmpty() || scriptFileLocation.isBlank()) {
			return Optional.empty();
		}
		IScriptEngine engine = engineDescription.createEngine();
		if (scriptVariables != null) {
			for (ScriptVariable variable : scriptVariables) {
				engine.setVariable(variable.getName(), variable.getObject());
			}
		}
		// Add the listener if client passing one
		executionListener.ifPresent(engine::addExecutionListener);
		Optional<ScriptResult> result = Optional.empty();
		try {
			File scriptFile = new File(scriptFileLocation);

			/**
			 * Sending the folder name where the script lies since this path has to be added
			 * to the path using the script below
			 * 
			 * @code sys.path.append(script_location) There could be some modules available
			 *       in the location to be used in the script
			 */
			engine.setVariable("script_location", scriptFile.getParentFile().getAbsolutePath());
			engine.setVariable("gdb_module", createGDBModule());
			final InputStream stream = new FileInputStream(scriptFile);
			Script script = new Script(scriptIdentifier, stream);
			setJobName(engine, SCRIPT_EXEC_JOB_NAME);
			result = Optional.of(engine.execute(script));
			engine.schedule();
		} catch (IOException e) {
			Activator.log(e);
		} catch (Exception e) {
			Activator.log(e);
		}
		return result;
	}

	private void setJobName(IScriptEngine engine, String name) {
		if(engine instanceof Job)
		{
			((Job)engine).setName(name);
		}
		
	}

	private void completeScriptIndexing() {
		try {
			indexScriptFeature.get();
		} catch (InterruptedException | ExecutionException e) {
			Activator.logErrorMessage("Script indexing filed, see the reason below");
			Activator.log(e);
		}
	}

	private static void indexScripts(File scriptFolder) {
		File[] files = scriptFolder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					indexScripts(file);
				} else if (file.getName().endsWith(CONFIGURATOR_SCRIPT_END)
						|| file.getName().contains(POPULATOR_SCRIPT_END)) {
					addScript(file.getName(), file.getAbsolutePath());

				}
			}
		}
	}

	private static void addScript(String scriptIdentifier, String scriptAbsolutePath) {

		sctiptLocationsMap.put(scriptIdentifier, scriptAbsolutePath);
	}

	private static void indexAllScripts() {
		// Indexing installation location scripts here
		URL url = Platform.getInstallLocation().getURL();
		File installationLocation = url == null ? new File(".") : new File(url.getPath()).getParentFile();
		File[] scriptFolders = installationLocation
				.listFiles((file) -> file.getName().equalsIgnoreCase(SCRIPTS_FOLDER_NAME));
		if (scriptFolders != null) {
			for (File scriptFolder : scriptFolders) {
				indexScripts(scriptFolder);
			}
		}
	}
	
	//EASE frame work stuck in bootstrapping modules at times, it gives loadModule("/RiscFree/GDB Debugging", False); failure in scripts
	//We are creating a module object manually here to get rid of EASE module load issues
	//TODO: FIXME get rid of tight dependency with GDBModule class, try with a stable EASE version 0.8.0 release version or above
	private GDBModule createGDBModule()
	{
		return new GDBModule();
	}
}
