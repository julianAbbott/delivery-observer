package com.comp303.service.bike.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.comp303.service.bike.gui.panels.PackagePanel;
import com.comp303.service.bike.gui.panels.PizzaPanel;
import com.comp303.service.bike.gui.panels.RideSharePanel;
import com.comp303.service.bike.model.Model;


public class DeliveryFrame extends JFrame {

	
	DeliveryFrame(Model pModel, PackagePanel pPackagePanel, PizzaPanel pPizzaPanel, RideSharePanel pRideSharePanel){
		super("DeliveryFrame");
		final BikeCourierPanel aNorth = new BikeCourierPanel(pPackagePanel,pPizzaPanel,pRideSharePanel);
		setLayout(new BorderLayout());
		add(aNorth, BorderLayout.CENTER);

		final JButton bPackage = new JButton("Get Package Delivery");
		final JButton bPizza = new JButton("Get Pizza Delivery");
		final JButton bRide = new JButton("Get ride");
		add(bPackage, BorderLayout.SOUTH);
		add(bPizza, BorderLayout.SOUTH);
		add(bRide, BorderLayout.SOUTH);
		
		bPackage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aNorth.showPackage();
				pModel.getBiker();

			}
		});
		
		bPizza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aNorth.showPizza();
				pModel.getBiker();

			}
		});
		
		bRide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aNorth.showRideShare();
				pModel.getBiker();
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);

	}

}
