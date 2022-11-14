package com.comp303.service.bike;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.comp303.common.*;
import com.comp303.common.schedule.DeliveryAbortedException;
import com.comp303.common.schedule.Scheduler;
import com.comp303.common.util.Employee;
import com.comp303.common.util.Observer;

public class Model {

	private Scheduler aSchedule;
	private List<Observer> aObservers = new ArrayList<Observer>();
	private BikeCourier aCurBiker;

	public Model(Collection<Employee> pToSchedule, Scheduler pScheduler) { 
		aSchedule = pScheduler.copy();
		aSchedule.runSchedulerAlgorithm(pToSchedule);
	}
	
	public void runScheduler(Collection<Employee> pToSchedule) {
		aSchedule.runSchedulerAlgorithm(pToSchedule);
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
}
