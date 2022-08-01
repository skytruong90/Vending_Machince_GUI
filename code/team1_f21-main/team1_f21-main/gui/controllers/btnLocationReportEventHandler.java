package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnLocationReportEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.txaReports.clear();
			String location = Main.txfAddress.getText();
			if(location.length() == 0) {
				Main.txaReports.setText("Location must be filled!");
			}
			else {
				Main.txaReports.setText(Main.report.LocationReport(location));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
