package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vmClasses.Item;
import vmClasses.RefrigeratedItem;
import vmClasses.VMManager;
import vmClasses.VendingMachine;

public class btnAddRefrigeratedItemActionEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			boolean hasPrice = true;
			boolean flag;
			
			if(Main.txfPrice.getText().equals("")) {
				hasPrice = false;
			}
			
			if((Main.txfName.getText().length() == 0)||
			  (Main.txfManufacturer.getText().length() == 0)||
			  (Main.txfCost.getText().length() == 0)||
			  (Main.txfHeight.getText().length() == 0)||
			  (Main.txfWidth.getText().length() == 0)||
			  (Main.txfMinTemp.getText().length() == 0)||
			  (Main.txfMaxTemp.getText().length() == 0)) {
				Main.lblAddItem.setText("Must have Name, Manufacturer, cost, height, width, Min Temp, and Max Temp!");
			}
			else if((Main.txfMonth.getText().length()!=2)||
					((Main.txfDay.getText().length() != 2))||
					((Main.txfYear.getText().length() != 4))){
				Main.lblAddItem.setText("Expiration Date Must Be In Form mm/dd/yyyy");
			}
			else if((!(Controller.isInt(Main.txfMonth.getText())))||
					(!(Controller.isInt(Main.txfDay.getText())))||
					(!(Controller.isInt(Main.txfYear.getText())))||
					(!(Controller.isInt(Main.txfWidth.getText())))||
					(!(Controller.isInt(Main.txfHeight.getText())))) {
				Main.lblAddItem.setText("mm dd yyyy, width, and height must all be integers!");
			}
			else if(((Integer.parseInt(Main.txfMonth.getText())>12)||(Integer.parseInt(Main.txfMonth.getText())<1))||
					(Integer.parseInt(Main.txfDay.getText())>31)||(Integer.parseInt(Main.txfDay.getText())<1)) {
				Main.lblAddItem.setText("Month must be between 1 and 12/ Day must be between 1 and 31");
			}
			else if(hasPrice) {
				if((!(Controller.isDouble(Main.txfPrice.getText())))||
				  (!(Controller.isDouble(Main.txfCost.getText())))||
				  (!(Controller.isDouble(Main.txfMinTemp.getText())))||
				  (!(Controller.isDouble(Main.txfMaxTemp.getText())))) {
					Main.lblAddItem.setText("Cost,Price,Min Temp, and Max Temp must be doubles or integers!");
				}
				
				VendingMachine[] machines = Main.vm.getVMs();
				RefrigeratedItem item = new RefrigeratedItem(Main.txfName.getText(),Main.txfManufacturer.getText(),Double.parseDouble(Main.txfCost.getText()),
						             						 Double.parseDouble(Main.txfPrice.getText()),Integer.parseInt(Main.txfMonth.getText()),
						             						 Integer.parseInt(Main.txfDay.getText()),Integer.parseInt(Main.txfYear.getText()),Double.parseDouble(Main.txfMinTemp.getText()),
						             						 Double.parseDouble(Main.txfMaxTemp.getText()));
				
				flag = machines[Main.vmIndex].addItemTypeToDispenser(Integer.parseInt(Main.txfHeight.getText()),Integer.parseInt(Main.txfWidth.getText()),item);
				if(flag) {
					Main.lblAddItem.setText("Success!");
					Main.vm = new VMManager(machines);
				}
				else {
					Main.lblAddItem.setText("Dispenser is occupied");
				}
			}
			else {
				if((!(Controller.isDouble(Main.txfCost.getText())))||
				  (!(Controller.isDouble(Main.txfMinTemp.getText())))||
				  (!(Controller.isDouble(Main.txfMaxTemp.getText())))) {
					Main.lblAddItem.setText("Cost,Min Temp, and Max Temp must be a double or integer!");
						}
						
						VendingMachine[] machines = Main.vm.getVMs();
						RefrigeratedItem item = new RefrigeratedItem(Main.txfName.getText(),Main.txfManufacturer.getText(),Double.parseDouble(Main.txfCost.getText()),
								             Integer.parseInt(Main.txfMonth.getText()),Integer.parseInt(Main.txfDay.getText()),
								             Integer.parseInt(Main.txfYear.getText()),Double.parseDouble(Main.txfMinTemp.getText()),
		             						 Double.parseDouble(Main.txfMaxTemp.getText()));
						
						flag = machines[Main.vmIndex].addItemTypeToDispenser(Integer.parseInt(Main.txfHeight.getText()),Integer.parseInt(Main.txfWidth.getText()),item);

						if(flag) {
							Main.lblAddItem.setText("Success!");
							Main.vm = new VMManager(machines);
						}
						else {
							Main.lblAddItem.setText("Dispenser is occupied");
						}
					}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
