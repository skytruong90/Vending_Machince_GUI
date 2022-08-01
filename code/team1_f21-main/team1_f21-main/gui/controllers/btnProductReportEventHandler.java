package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vmClasses.Item;

public class btnProductReportEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.txaReports.clear();
			String name = Main.txfName.getText();
			if(name.length()==0) {
				Main.txaReports.setText("Item Name must be filled!");
			}
			else {
				Item item = new Item(name,"",0.0,0,0,0);
				Main.txaReports.setText(Main.report.ProductReport(item));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
