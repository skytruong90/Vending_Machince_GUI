package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRemoveVMActionEventHandler implements EventHandler<ActionEvent> 
{

	@Override
	public void handle(ActionEvent arg0) 
	{
		try {			
			if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none"))
			{
				String address = Main.lvwAddresses.getSelectionModel().getSelectedItem();
				String company = Main.lvwVendingMachines.getSelectionModel().getSelectedItem();
				Main.vm.removeVM(address, company);
				Main.lblRemoveVM.setText("Vending machine removed");
			}
			else {
				String address = Main.lvwAddresses.getSelectionModel().getSelectedItem();
				String building = Main.lvwBuildings.getSelectionModel().getSelectedItem();
				String company = Main.lvwVendingMachines.getSelectionModel().getSelectedItem();
				Main.vm.removeVM(address, building, company);
				Main.lblRemoveVM.setText("Vending machine removed");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
