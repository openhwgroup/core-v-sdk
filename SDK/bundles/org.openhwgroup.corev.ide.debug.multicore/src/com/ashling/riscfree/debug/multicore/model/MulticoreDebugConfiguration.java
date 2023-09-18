package com.ashling.riscfree.debug.multicore.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author vinod.appu
 *
 *Represents a multicore debug configuration
 */
public class MulticoreDebugConfiguration {

	List<CoreDebugConfiguration> coreInfo = new LinkedList<>();

	public MulticoreDebugConfiguration(List<CoreDebugConfiguration> coreInfo) {
		this.coreInfo = coreInfo;
	}

	public List<CoreDebugConfiguration> getCoreInfo() {
		return coreInfo;
	}

	public Optional<CoreDebugConfiguration> getCoreDebugConfigruation(final String coreId) {
		return coreInfo.stream().filter(p -> {
			return p.getCoreId().equalsIgnoreCase(coreId);

		}).findFirst();
	}
}
