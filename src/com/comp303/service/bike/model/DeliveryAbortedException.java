package com.comp303.service.bike.model;

public class DeliveryAbortedException extends Exception{ 
	public DeliveryAbortedException() {
		super();
	}
	public DeliveryAbortedException(String msg) {
		super(msg);
	}
}
