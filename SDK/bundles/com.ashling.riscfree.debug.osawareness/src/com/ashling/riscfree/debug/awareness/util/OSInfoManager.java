package com.ashling.riscfree.debug.awareness.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ResourceLocator;

import com.ashling.riscfree.debug.osawareness.Activator;

public class OSInfoManager {
	public static final OSInfoManager INSTANCE = new OSInfoManager();
	TreeMap<String, String[]> osToVersionMap = new TreeMap<String, String[]>();
	private static final String OS_INFO_PROVIDER_EXTENSION_NAME = "OSInfoProvider";
	private static final String OS_NAME = "name";
	private static final String OS_VERSIONS = "versions";
	
	private OSInfoManager() {
		try {
			readOSInfo();
		} catch (CoreException e) {
			Activator.log(e);
		}
	}

	void readOSInfo() throws CoreException {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(Activator.PLUGIN_ID, OS_INFO_PROVIDER_EXTENSION_NAME);
		for (IConfigurationElement configElement : configurationElements) {
			List<String> versions = new ArrayList<>();
			String osName = configElement.getAttribute(OS_NAME);
			String versionsFile = configElement.getAttribute(OS_VERSIONS);
			ResourceLocator.locate(Platform.getBundle(configElement.getDeclaringExtension().getContributor().getName())
					.getSymbolicName(), versionsFile).ifPresent(verFile -> {
						try (Scanner sc = new Scanner(Paths.get(FileLocator.toFileURL(verFile).toURI()).toFile())) {
							sc.useDelimiter(",");
							while (sc.hasNext()) // returns a boolean value
							{
								versions.add(sc.next()); // find and returns the next complete token from this scanner
							}
						} catch (IOException | URISyntaxException e) {
							Activator.log(e);
						}
						osToVersionMap.put(osName, versions.toArray(new String[versions.size()]));
					});
		}
	}

	public String[] getSupportedRTOS() {
		return osToVersionMap.keySet().toArray(new String[0]);
	}
	
	public String[] getSupportedVersions(String rtosName) {
		return osToVersionMap.getOrDefault(rtosName, new String[0]);
	}
	
	public Optional<String> getDefaultOSType() {
		if(!osToVersionMap.isEmpty()) {
			return Optional.of(osToVersionMap.firstKey());
		}
		return Optional.empty();
	}
	
	public Optional<String> getDefaultOSVersion() {
		// Get the first version of the default OS TYPE
		return getDefaultOSType().map(k -> {
			String[] versions = osToVersionMap.get(k);
			if (versions.length > 0) {
				return versions[0];
			}
			return null;
		});
	}
}