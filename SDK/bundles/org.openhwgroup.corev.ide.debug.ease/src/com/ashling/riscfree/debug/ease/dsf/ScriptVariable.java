/**
 * 
 */
package com.ashling.riscfree.debug.ease.dsf;

/**
 * @author vinod.appu 
 * Variable has to be sent to a script to full fill it's requirements
 * 
 */
public class ScriptVariable {
	/**
	 * Name used in the script to refer this variable
	 */
	String name;

	/**
	 * The java object to be sent to the script
	 */
	Object object;

	public ScriptVariable(String name, Object object) {
		this.name = name;
		this.object = object;
	}

	public String getName() {
		return this.name;
	}

	public Object getObject() {
		return this.object;
	}
}
