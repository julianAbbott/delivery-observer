package com.comp303.common.schedule;

public class SchedulingErrorException extends Exception{ 
	public SchedulingErrorException() {
		super();
	}
	public SchedulingErrorException(String msg) {
		super(msg);
	}
}