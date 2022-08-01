package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnBuildingEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) {
		try {
			if(Main.lvwBuildings.getSelectionModel().isEmpty()) {
				Main.lblListsStatus.setText("Must select a building");
			}
			else if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none")) {
				if(Main.lvwAddresses.getSelectionModel().isEmpty()) {
					Main.lblListsStatus.setText("Must select an address");
				}
				else{
					String[] vms = Main.vm.getCompanys(Main.lvwAddresses.getSelectionModel().getSelectedItem());
					Controller.generateVMs(Main.lvwAddresses.getSelectionModel().getSelectedItem());
					Main.lblListsStatus.setText("Vending Machines Generated");
					}
			}
			else {
				Controller.generateVMs(Main.lvwAddresses.getSelectionModel().getSelectedItem(),Main.lvwBuildings.getSelectionModel().getSelectedItem());
				Main.lblListsStatus.setText("Vending Machines Generated");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
