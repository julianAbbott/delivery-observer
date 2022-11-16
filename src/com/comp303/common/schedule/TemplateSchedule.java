package com.comp303.common.schedule;

import java.util.Collection;
import java.util.Queue;
import java.util.Stack;

public abstract class TemplateSchedule implements Scheduler{

	private Collection aSchedule;

	@Override
	public void populateSchedule(Collection pToSchedule) {
		executeScheduleAlgorithm(pToSchedule);
		log();
	}
	
	protected abstract void executeScheduleAlgorithm(Collection pToSchedule);

	@Override
	public void add(Object o) {
		executeAddLogic(o);
		log();

	}

	protected abstract void executeAddLogic(Object o);

	@Override
	public Object getNext() throws SchedulingErrorException {
		try {
			return executeRemoveNextLogic();
		}
		catch (Exception e) {
			throw new SchedulingErrorException();
		}
		finally {
			log();

		}
	}

	protected abstract Object executeRemoveNextLogic();
	
	protected abstract void log();

}
