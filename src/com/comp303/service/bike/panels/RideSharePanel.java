package com.comp303.service.bike.panels;

import com.comp303.common.util.Employee;
import com.comp303.common.util.Observer;
import com.comp303.service.bike.model.BikeCourier;
import com.comp303.service.bike.model.Model;

public class RideSharePanel implements Observer {
	private Model aModel;
	private BikeCourier aBiker;
	
	public RideSharePanel(Model pModel) {
		aModel = pModel;
		aModel.addObserver(this);
		aBiker= aModel.getBiker();
	}

	@Override
	public void upDate(Employee pEmployee) {
		aBiker= (BikeCourier) pEmployee;
	}
	
	public BikeCourier getBiker() {
		return aBiker;
	}
}
