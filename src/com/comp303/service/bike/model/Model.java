package com.comp303.service.bike.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.comp303.common.*;
import com.comp303.common.schedule.DeliveryAbortedException;
import com.comp303.common.schedule.Scheduler;
import com.comp303.common.util.Employee;
import com.comp303.common.util.Observer;

public class Model {

	private AbstractBikerSchedule aSchedule;
	List<Observer> aObservers = new ArrayList<Observer>();
	private BikeCourier aCurBiker;

	public Model(AbstractBikerSchedule pScheduler) { 
		aSchedule = pScheduler;
	}
	
	
	public void addObserver(Observer pObserver) {
		aObservers.add(pObserver);
	}
	
	public void notifyObservers() {
		for (Observer observer: aObservers) {
			observer.upDate((Employee) aCurBiker);
		}
		
	}
	public void setBiker() throws DeliveryAbortedException {
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
