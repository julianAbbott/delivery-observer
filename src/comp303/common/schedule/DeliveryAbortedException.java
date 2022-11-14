package comp303.common.schedule;

public class DeliveryAbortedException extends Exception{ 
	public DeliveryAbortedException() {
		super();
	}
	public DeliveryAbortedException(String msg) {
		super(msg);
	}
}
