package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnExpiredInventoryReportEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.txaReports.clear();
			String m = Main.txfMonth.getText();
			String d = Main.txfDay.getText();
			String y = Main.txfYear.getText();
			
			if((m.length() == 0)||(d.length() == 0)||(y.length() == 0)) {
				Main.txaReports.setText("Month, Day, and Year must be filled!");
			}
			else if(!((isDigit(m))&&(isDigit(d))&&(isDigit(y)))) {
					Main.txaReports.setText("Month, Day, and Year must be integers!");
				}
			else {
				int month = Integer.parseInt(m);
				int day = Integer.parseInt(d);
				int year = Integer.parseInt(y);
				
				if(isDate(month,day,year)) {
					Main.txaReports.setText(Main.report.expiredInventoryReport(month, day, year));
				}
				else {
					Main.txaReports.setText("Month, Day, and Year must be valid!");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//helper methods
	private boolean isDigit(String s) {
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(!(Character.isDigit(c[i]))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isDate(int m, int d, int y) {
		if((m < 1)||(m > 12)) {
			return false;
		}
		else if((d < 1)||(d > 31)) {
			return false;
		}
		else if((y < 1000)||(y > 9999)) {
			return false;
		}
		return true;
	}
}
