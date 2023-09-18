package com.ashling.riscfree.debug.opxd.core.comrv;

public class CFunctionDetails {

	String functionName;
	int startLine;
	int endLine;
	

	public  CFunctionDetails(String functionName,int startLine,int endLine) {
		this.functionName=functionName;
		this.startLine=startLine;
		this.endLine=endLine;
	}


	public String getFunctionName() {
		return functionName;
	}


	public int getStartLine() {
		return startLine;
	}


	public int getEndLine() {
		return endLine;
	}
	
	
}