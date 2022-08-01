package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnAddVMActionEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			boolean hasBuilding = true;
			boolean flag;
			
			if(Main.txfBuilding.getText().equals("")) {
				hasBuilding = false;
			}
			
			if((Main.txfAddress.getText().length() == 0)||
			  (Main.txfCompany.getText().length() == 0)||
			  (Main.txfWidth.getText().length() == 0)||
			  (Main.txfHeight.getText().length() == 0)||
			  (Main.txfCap.getText().length() == 0)) {
				Main.lblAddVM.setText("Must have Address, Company, Width, Height, and Capacity");
			}
			else if((!(Controller.isInt(Main.txfWidth.getText())))||
					(!(Controller.isInt(Main.txfHeight.getText())))||
					(!(Controller.isInt(Main.txfCap.getText())))){
				Main.lblAddVM.setText("Width, Height, and Capacity must be integers!");
			}
			else if(hasBuilding) {
				String address = Main.txfAddress.getText();
				String building = Main.txfBuilding.getText();
				String company = Main.txfCompany.getText();
				int width = Integer.parseInt(Main.txfWidth.getText());
				int height = Integer.parseInt(Main.txfHeight.getText());
				int cap = Integer.parseInt(Main.txfCap.getText());
				if((Main.txfMaxTemp.getText().length() != 0)&&(isDouble(Main.txfMaxTemp.getText()))){
					double temp = Double.parseDouble(Main.txfMaxTemp.getText());
					flag = Main.vm.addRVM(height, width, cap, address, building, company,temp);
				}
				else {
					flag = Main.vm.addVM(height, width, cap, address, building, company);
				}
				if(flag) {
					Main.lblAddVM.setText("Successfully added");
				}
				else {
					Main.lblAddVM.setText("Vending Machine Already Exists");
				}
			}
			else {
				String address = Main.txfAddress.getText();
				String company = Main.txfCompany.getText();
				String building = "none";
				int width = Integer.parseInt(Main.txfWidth.getText());
				int height = Integer.parseInt(Main.txfHeight.getText());
				int cap = Integer.parseInt(Main.txfCap.getText());
				if((Main.txfMaxTemp.getText().length() != 0)&&(isDouble(Main.txfMaxTemp.getText()))){
					double temp = Double.parseDouble(Main.txfMaxTemp.getText());
					flag = Main.vm.addRVM(height, width, cap, address, building, company,temp);
				}
				else {
					flag = Main.vm.addVM(height, width, cap, address, building, company);
				}
				if(flag) {
					Main.lblAddVM.setText("Successfully added");
				}
				else {
					Main.lblAddVM.setText("Vending Machine Already Exists");
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isDouble(String string) {
		char[] c = string.toCharArray();
		boolean foundDot = false;
		for(int i = 0; i < c.length; i++) {
			if(!(Character.isDigit(c[i]))) {
				if((c[i] == '.')&&(i < c.length-2)&&(!(foundDot))) {
					foundDot = true;
				}
				else {
					return false;
				}
			}
			}
		return true;
		}
}
