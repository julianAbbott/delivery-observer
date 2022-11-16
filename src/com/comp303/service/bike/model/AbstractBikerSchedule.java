package com.comp303.service.bike.model;

import java.util.Collection;
import java.util.Queue;

import com.comp303.common.schedule.DeliveryAbortedException;
import com.comp303.common.schedule.Scheduler;

public abstract class AbstractBikerSchedule implements Scheduler{

	private Queue<BikeCourier> aSchedule;

	@Override
	public void runSchedulerAlgorithm(Collection pToSchedule) { 
		for (Object cur : pToSchedule) {
			BikeCourier curCasted = (BikeCourier) cur; 
			aSchedule.add(curCasted);
		}
		
	}

	@Override
	public void add(Object o) {
		BikeCourier pBiker = (BikeCourier) o;
		aSchedule.add(pBiker); //FIFO 
	}

	@Override
	public Object getNext() throws DeliveryAbortedException {
		if (aSchedule.peek() == null) {
			throw new DeliveryAbortedException("Unable to schedule Biker Delivery.");
		}
		return aSchedule.peek();
	}

}
