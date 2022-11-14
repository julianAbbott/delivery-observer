package comp303.common.util;

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
