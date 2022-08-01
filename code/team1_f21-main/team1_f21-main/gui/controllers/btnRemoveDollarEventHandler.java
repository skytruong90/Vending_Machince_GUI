package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnRemoveDollarEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			if(Main.vm.getVMs()[Main.vmIndex].getNumDollars()!=0) {
				Main.vm.getVMs()[Main.vmIndex].removeDollars_Technician(1);
				Main.lblRestockCash.setText(String.format("Nickels: %d  Dimes: %d  Quarters: %d  Dollars:%d", Main.vm.getVMs()[Main.vmIndex].getNumNickels(),Main.vm.getVMs()[Main.vmIndex].getNumDimes(),Main.vm.getVMs()[Main.vmIndex].getNumQuarters(),Main.vm.getVMs()[Main.vmIndex].getNumDollars()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
