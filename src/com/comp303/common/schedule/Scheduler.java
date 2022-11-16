package com.comp303.common.schedule;

import java.util.Collection;

import com.comp303.service.bike.model.BikeCourier;


/**
 * 
 * API for scheduling algorithms. 
 * See {@link com.comp303.common.TemplateSchedule} 
 * for partial implementation. 
 * 
 * @author Julian Abbott
 */

public interface Scheduler {
	
	/**
	 * Method to populate schedule object. 
	 * 
	 * @param pToSchedule the collection of elements that need to be scheduled. 
	 */
	void populateSchedule(Collection pToSchedule);

	
	/**
	 * Method with schedule add logic.
	 * 
	 * @param o the object that needs to be added
	 */
	void add(Object o);
	
	/**
	 * Method with get next item in schedule logic. 
	 * 
	 * @return provides the a schedule item. 
	 * @throws SchedulingErrorException thrown when next item cannot be determined
	 */

	Object getNext() throws SchedulingErrorException;


}