package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnRestockEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			String input = Main.txfQuantity.getText();
			
			if(!(Controller.isInt(input))) {
				Main.lblRestockStatus.setText("Failed: Quantity must be integer");
			}
			else {
				int quantity = Integer.parseInt(input);
				if(Main.vm.getVMs()[Main.vmIndex].getDispenser(Main.height,Main.width).addItem(quantity, Main.vm.getVMs()[Main.vmIndex].getItemFromArray(Main.height, Main.width))) {
//					lblRestock.setText(String.format("Quantity: %d Max: %d", vm.getVMs()[vmIndex].getDispenser(height,width).getQuantity(),vm.getVMs()[vmIndex].getDispenser(height,width).max));
					Main.lblRestockStatus.setText("Success!");
				}
				else {
					Main.lblRestockStatus.setText("Failed");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
