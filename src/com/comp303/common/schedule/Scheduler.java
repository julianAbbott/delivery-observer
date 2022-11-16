package com.comp303.common.schedule;

import java.util.Collection;

import com.comp303.service.bike.model.BikeCourier;


public interface Scheduler {

	void runSchedulerAlgorithm(Collection pToSchedule);

	void add(Object o);

	Object getNext() throws DeliveryAbortedException;
	


}