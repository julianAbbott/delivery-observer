package com.comp303.common.util;

/**
 * Plain Java Object for Employee profiles
 * @author julian
 *
 */
public class Employee {
	
	private final String aName;
	private final int aPin;
	
	public Employee(String pName, int pPin) {
		aName=pName;
		aPin=pPin;
	}
	
	public String getName() {
		return aName;
	}
	
	public int getPin() {
		return aPin;
	}

}
