package com.comp303.service.bike.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

import org.junit.Test;

import com.comp303.common.schedule.DeliveryAbortedException;
import com.comp303.common.schedule.Scheduler;
import com.comp303.common.util.Employee;
import com.comp303.service.bike.panels.PackagePanel;
import com.comp303.service.bike.panels.PizzaPanel;
public class TestModel {
	
		Random rand = new Random();
		ArrayList<BikeCourier> bikePool = new ArrayList<BikeCourier>();
		BikeCourier james = new BikeCourier("James",rand.nextInt(1000), true);
		BikeCourier beatrice = new BikeCourier("Beatrice",rand.nextInt(1000), true);
		BikeCourier jackson = new BikeCourier("Jackson",rand.nextInt(1000), false);
		TestAlgorithm mySchedule= new TestAlgorithm();
		Model myModel = new Model(mySchedule);
	
	
	
	
	@Test
	public void testAddObserver() {
		
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel);
		
		assertTrue(myModel.getObservers().size() == 1);
	}
	
	@Test
	public void testNotifyObserverSingle() throws DeliveryAbortedException {
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "James");
 		
	}
	
	@Test
	public void testNotifyObserverMulti() throws DeliveryAbortedException {
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "James");
		assertTrue(myPizzaPanel.getBiker().getName() == "James");
 		
	}
	
	
	class TestAlgorithm extends AbstractBikerSchedule{
		private Queue<BikeCourier> aSchedule = new LinkedList<BikeCourier>();

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

	
}
