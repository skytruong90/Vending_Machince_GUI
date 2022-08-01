package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnManufacturerReportEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.txaReports.clear();
			String manufacturer = Main.txfManufacturer.getText();
			if(manufacturer.length() == 0) {
				Main.txaReports.setText("Manufacturer must be filled!");
			}
			else {
				Main.txaReports.setText(Main.report.ManufacturerReport(manufacturer));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
