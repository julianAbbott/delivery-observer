package com.comp303.service.bike.model;

import com.comp303.common.schedule.SchedulingErrorException;

public class DeliveryAbortedException extends SchedulingErrorException{ 
	public DeliveryAbortedException() {
		super();
	}
	public DeliveryAbortedException(String msg) {
		super(msg);
	}
}
