package com.comp303.service.bike.model;

import java.util.Collection;
import java.util.Stack;

import com.comp303.common.schedule.SchedulingErrorException;
import com.comp303.common.schedule.TemplateSchedule;

public class BikeSchedule extends TemplateSchedule{
	
	private Stack<BikeCourier> aSchedule = new Stack<BikeCourier>();
	private String aLog = "";

	@Override
	protected void executeScheduleAlgorithm(Collection pToSchedule) {
		for (Object cur : pToSchedule) {
			BikeCourier curCasted = (BikeCourier) cur; 
			aSchedule.push(curCasted);
		}
		
	}

	@Override
	protected void executeAddLogic(Object o) {
		BikeCourier pCasted = (BikeCourier) o;
		aSchedule.push(pCasted);
		
	}
	
	@Override
	public Object getNext() throws DeliveryAbortedException  {
		try {
			return executeRemoveNextLogic();
		}
		catch (Exception NoSuchElementException) {
			throw new DeliveryAbortedException("Sorry, No one is available for delivery :(( ");
		}
		finally {
			log();
		}
	}

	@Override
	protected Object executeRemoveNextLogic() {
		
		return aSchedule.lastElement();
	}

	@Override
	protected void log() {
		aLog.concat("I am a very very useful log msg! \n");
		
	}

}
