package com.comp303.service.bike.gui;

import java.util.ArrayList;
import java.util.Random;

import com.comp303.common.schedule.SchedulingErrorException;
import com.comp303.service.bike.gui.panels.PackagePanel;
import com.comp303.service.bike.gui.panels.PizzaPanel;
import com.comp303.service.bike.gui.panels.RideSharePanel;
import com.comp303.service.bike.model.BikeCourier;
import com.comp303.service.bike.model.BikeSchedule;
import com.comp303.service.bike.model.DeliveryAbortedException;
import com.comp303.service.bike.model.Model;

public class TestGui {
	public static void main(String[] args) throws DeliveryAbortedException, SchedulingErrorException {
		Random rand = new Random();
		ArrayList<BikeCourier> bikePool = new ArrayList<BikeCourier>();
		
		BikeCourier jackson = new BikeCourier("Jackson",rand.nextInt(1000), false);
		BikeCourier beatrice = new BikeCourier("Beatrice",rand.nextInt(1000), true);
		BikeCourier james = new BikeCourier("James",rand.nextInt(1000), true);
		
		bikePool.add(james);
		bikePool.add(beatrice);
		bikePool.add(jackson);
	
		BikeSchedule mySchedule= new BikeSchedule();
		Model myModel = new Model(mySchedule);
		

		mySchedule.populateSchedule(bikePool);
		myModel.setBiker();

		PackagePanel myPackagePanel= new PackagePanel(myModel);
		PizzaPanel myPizzaPanel = new PizzaPanel(myModel);
		RideSharePanel myRidePanel= new RideSharePanel(myModel); 
		
	
		
		new DeliveryFrame(myModel, myPackagePanel, myPizzaPanel, myRidePanel);
	}

}
