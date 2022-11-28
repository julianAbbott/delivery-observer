package com.comp303.service.bike.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.comp303.common.*;
import com.comp303.common.schedule.TemplateSchedule;
import com.comp303.common.schedule.Scheduler;
import com.comp303.common.schedule.SchedulingErrorException;
import com.comp303.common.util.Employee;
import com.comp303.common.util.Observer;

/**
 * Sends data to observers. Using the "Push" style Observer design pattern. 
 * @author Julian Abbott
 *
 */
public class Model {

	private TemplateSchedule aSchedule;
	private List<Observer> aObservers = new ArrayList<Observer>();
	private BikeCourier aCurBiker;
	
	
	/**
	 * Constructor 
	 * @param pSchedule refrence to schedule object
	 */
	public Model(TemplateSchedule pSchedule) { 
		aSchedule = pSchedule;  
	}
	
	/**
	 * Adds single observer panel
	 * @param pObserver panel to add
	 */
	public void addObserver(Observer pObserver) {
		aObservers.add(pObserver);
	}
	
	/**
	 * invokes {@link common.util.Observer.upDate()} for each of the Observers in 
	 * aObservers. 
	 */
	public void notifyObservers() {
		for (Observer observer: aObservers) {
			observer.upDate();
		}
	}
	
	/**
	 * Updates aCurBiker with next avail biker in Schedule and communicates with
	 * observers 
	 * 
	 * @throws SchedulingErrorException
	 * @throws DeliveryAbortedException
	 */
	public void setBiker() throws SchedulingErrorException, DeliveryAbortedException {
		aCurBiker = (BikeCourier) aSchedule.getNext();
		notifyObservers();
	}

	public BikeCourier getBiker() {
		return aCurBiker;
	}
	
	protected List<Observer> getObservers(){
		return aObservers;
	}
}
