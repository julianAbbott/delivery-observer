package com.comp303.service.bike.model;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
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
		
		BikeCourier jackson = new BikeCourier("Jackson",rand.nextInt(1000), false);
		BikeCourier beatrice = new BikeCourier("Beatrice",rand.nextInt(1000), true);
		BikeCourier james = new BikeCourier("James",rand.nextInt(1000), true);

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
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
 		
	}
	
	@Test
	public void testNotifyObserver2() throws DeliveryAbortedException {
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		Model m = myModel;
		ArrayList<BikeCourier> b = bikePool;
		TestAlgorithm algo = mySchedule;
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
		assertTrue(myPizzaPanel.getBiker().getName() == "Jackson");
	
	}
	
	@Test
	public void testNotifyObserver3()throws DeliveryAbortedException{
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
		assertTrue(myPizzaPanel.getBiker().getName() == "Jackson");
		
		//now the case where you reset the biker
 		myModel.setBiker();
		assertTrue(myPackagePanel.getBiker().getName() == "Beatrice");
		assertTrue(myPizzaPanel.getBiker().getName() == "Beatrice");
	}
	
	@Test
	public void testNotifyObserver4()throws DeliveryAbortedException{
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.runSchedulerAlgorithm(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
		assertTrue(myPizzaPanel.getBiker().getName() == "Jackson");
		
		//now the case where you reset the biker
 		myModel.setBiker();
		assertTrue(myPackagePanel.getBiker().getName() == "Beatrice");
		assertTrue(myPizzaPanel.getBiker().getName() == "Beatrice");
		
 		myModel.setBiker();
		assertTrue(myPackagePanel.getBiker().getName() == "James");
		assertTrue(myPizzaPanel.getBiker().getName() == "James");
		
		assertThrows(DeliveryAbortedException.class, ()-> {
			myModel.setBiker();
		});

		
	}
	
	
	
	
	class TestAlgorithm extends AbstractBikerSchedule{
		private Stack<BikeCourier> aSchedule = new Stack<BikeCourier>();

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

	
}
