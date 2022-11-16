package com.comp303.service.bike.model;

import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Random;
import com.comp303.common.schedule.SchedulingErrorException;
import com.comp303.service.bike.panels.PackagePanel;
import com.comp303.service.bike.panels.PizzaPanel;
public class TestModel {
	
		Random rand = new Random();
		ArrayList<BikeCourier> bikePool = new ArrayList<BikeCourier>();
		
		BikeCourier jackson = new BikeCourier("Jackson",rand.nextInt(1000), false);
		BikeCourier beatrice = new BikeCourier("Beatrice",rand.nextInt(1000), true);
		BikeCourier james = new BikeCourier("James",rand.nextInt(1000), true);

		BikeSchedule mySchedule= new BikeSchedule();
		Model myModel = new Model(mySchedule);
	
	
	
	
	@Test
	public void testAddObserver() {
		
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.populateSchedule(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel);
		
		assertTrue(myModel.getObservers().size() == 1);
	}
	
	@Test
	public void testNotifyObserverSingle() throws SchedulingErrorException {
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.populateSchedule(bikePool);
		
		

		PackagePanel myPackagePanel= new PackagePanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
 		
	}
	
	@Test
	public void testNotifyObserver2() throws SchedulingErrorException {
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.populateSchedule(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		ArrayList<BikeCourier> bp = bikePool;
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
		assertTrue(myPizzaPanel.getBiker().getName() == "Jackson");
	
	}
	
	@Test
	public void testNotifyObserver3()throws SchedulingErrorException{
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.populateSchedule(bikePool);

		PackagePanel myPackagePanel= new PackagePanel(myModel); 
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		myModel.setBiker(); 
		
		assertTrue(myPackagePanel.getBiker().getName() == "Jackson");
		assertTrue(myPizzaPanel.getBiker().getName() == "Jackson");
		
		//now the case where you reset the biker
 		myModel.setBiker();
 		
 		Model m = myModel;
		assertTrue(myPackagePanel.getBiker().getName() == "Beatrice");
		assertTrue(myPizzaPanel.getBiker().getName() == "Beatrice"); 
	}
	
	@Test
	public void testNotifyObserver4()throws SchedulingErrorException{
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
		mySchedule.populateSchedule(bikePool);

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
}
