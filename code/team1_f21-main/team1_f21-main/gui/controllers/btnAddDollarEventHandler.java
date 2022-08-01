package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnAddDollarEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.vm.getVMs()[Main.vmIndex].addDollars_Technician(1);
			Main.lblRestockCash.setText(String.format("Nickels: %d  Dimes: %d  Quarters: %d  Dollars:%d", Main.vm.getVMs()[Main.vmIndex].getNumNickels(),Main.vm.getVMs()[Main.vmIndex].getNumDimes(),Main.vm.getVMs()[Main.vmIndex].getNumQuarters(),Main.vm.getVMs()[Main.vmIndex].getNumDollars()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
