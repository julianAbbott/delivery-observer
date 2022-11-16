package com.comp303.service.bike.model;

import com.comp303.common.util.Employee;


public class BikeCourier extends Employee{
	private final String aName;
	private final int aPin;
	private final Boolean aWinterTires;
	

	public BikeCourier(String pName, int pPin, Boolean pWinterTires) {
		super(pName, pPin);
		aName=pName;
		aPin=pPin;
		aWinterTires= pWinterTires;
	}
	
	@Override
	public String getName() {
		return aName;
	}
	
	@Override
	public int getPin() {
		return aPin;
	}
	
	public Boolean getWinterTires() {
		return aWinterTires;
	}
	
	

}
