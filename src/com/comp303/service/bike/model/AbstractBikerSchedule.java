package com.comp303.service.bike.model;

import java.util.Collection;
import java.util.Queue;
import java.util.Stack;

import com.comp303.common.schedule.DeliveryAbortedException;
import com.comp303.common.schedule.Scheduler;

public abstract class AbstractBikerSchedule implements Scheduler{

	private Stack<BikeCourier> aSchedule;

	@Override
	public void runSchedulerAlgorithm(Collection pToSchedule) { 
		for (Object cur : pToSchedule) {
			BikeCourier curCasted = (BikeCourier) cur; 
			aSchedule.push(curCasted);
		}
		
	}

	@Override
	public void add(Object o) {
		BikeCourier pBiker = (BikeCourier) o;
		aSchedule.push(pBiker); //FIFO 
	}

	@Override
	public Object getNext() throws DeliveryAbortedException {
		try {
			return aSchedule.pop();
		}
		catch (Exception EmptyStackException) {
			throw new DeliveryAbortedException("Unable to schedule Biker Delivery.");
		}
	}

}
