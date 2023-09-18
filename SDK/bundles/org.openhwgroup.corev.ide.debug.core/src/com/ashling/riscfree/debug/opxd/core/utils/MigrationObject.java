package com.ashling.riscfree.debug.opxd.core.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MigrationObject {

	private Map<String, Object> migrationAttrMap;
	
	public MigrationObject() {
		migrationAttrMap = new HashMap<>();
	}
	
	public void addAttribute(String attrKey, Object attrVal) {
		migrationAttrMap.put(attrKey, attrVal);
	}
	
	public Optional<Object> getMigrationAttrVal(String key){
		return Optional.ofNullable(migrationAttrMap.get(key));
	}
}
