package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnGoodsReportEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.txaReports.clear();
			Main.txaReports.setText(Main.report.GoodsReport());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
