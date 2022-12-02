package com.comp303.service.bike.gui.panels;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.comp303.common.util.Employee;
import com.comp303.common.util.Observer;
import com.comp303.service.bike.model.BikeCourier;
import com.comp303.service.bike.model.Model;

public class RideSharePanel  implements Observer {
	private Model aModel;
	private BikeCourier aBiker; 
	private JLabel aBikerLabel;
	
	public RideSharePanel(Model pModel) {
		aModel = pModel;
		aModel.addObserver(this);
		aBiker= aModel.getBiker();
		aBikerLabel=new JLabel(aBiker.getName());
	}

	@Override
	public void upDate(Employee pEmployee) {
		aBiker=(BikeCourier) pEmployee;
		aBikerLabel=new JLabel(aBiker.getName());
	}
	
	public BikeCourier getBiker() {
		return aBiker;
	}
	
	public JLabel getBikerLabel() {
		return aBikerLabel;
	}
}