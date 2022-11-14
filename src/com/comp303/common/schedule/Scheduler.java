package com.comp303.common.schedule;

import java.util.Collection;

public interface Scheduler {

	void runSchedulerAlgorithm(Collection pToSchedule);

	void add(Object o);

	Object getNext() throws DeliveryAbortedException;
	
	Scheduler copy();

}