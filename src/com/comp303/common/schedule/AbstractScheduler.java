package com.comp303.common.schedule;

import java.util.Collection;

public abstract class AbstractScheduler {
	private Collection aSchedule;
	
	public AbstractScheduler(Collection pToSchedule) {} 
		
	public abstract void add(Object o); 
	
	public abstract Object getNext() throws DeliveryAbortedException;

}
