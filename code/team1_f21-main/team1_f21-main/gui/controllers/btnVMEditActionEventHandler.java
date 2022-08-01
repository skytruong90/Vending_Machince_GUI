package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vmClasses.VendingMachine;

public class btnVMEditActionEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try {
			VendingMachine vm = Main.vm.getVM(Main.vmIndex);
			
			if(Main.txfAddress.getText().length() != 0) {
				vm.editLocation(Main.txfAddress.getText());
			}
			if(Main.txfBuilding.getText().length() != 0) {
				vm.editBuilding(Main.txfBuilding.getText());
			}
			if(Main.txfCompany.getText().length() != 0) {
				vm.editCompany(Main.txfCompany.getText());
			}
			
			Main.vm.replace(Main.vmIndex,vm);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
