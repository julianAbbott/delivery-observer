package com.comp303.service.bike;

import com.comp303.common.util.Employee;

public class BikeCourier extends Employee{
	private final String aName;
	private final int aPin;
	

	public BikeCourier(String pName, int pPin) {
		super(pName, pPin);
		aName=pName;
		aPin=pPin;
	}
	
	@Override
	public String getName() {
		return aName;
	}
	
	@Override
	public int getPin() {
		return aPin;
	}
	
	

}
