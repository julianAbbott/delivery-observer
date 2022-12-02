package com.comp303.service.bike.gui;

import javax.swing.JPanel;

import com.comp303.service.bike.gui.panels.PackagePanel;
import com.comp303.service.bike.gui.panels.PizzaPanel;
import com.comp303.service.bike.gui.panels.RideSharePanel;

@SuppressWarnings("serial")
public class BikeCourierPanel extends JPanel {
	
	private PackagePanel aPackagePanel;
	private PizzaPanel aPizzaPanel;
	private RideSharePanel aRideSharePanel;
	
	BikeCourierPanel(PackagePanel pPackagePanel, PizzaPanel pPizzaPanel, RideSharePanel pRideSharePanel ){
		aPackagePanel = pPackagePanel;
		aPizzaPanel =  pPizzaPanel;
		aRideSharePanel = pRideSharePanel;
	}
	
	public void showPackage(){
		add(aPackagePanel.getBikerLabel());
	}
	
	public void showPizza() {
		add(aPizzaPanel.getBikerLabel());
	}
	
	public void showRideShare() {
		add(aRideSharePanel.getBikerLabel());
	}
	
}
