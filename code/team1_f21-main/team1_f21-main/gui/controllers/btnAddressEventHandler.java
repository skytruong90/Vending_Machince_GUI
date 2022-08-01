package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnAddressEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) 
	{
		try 
		{
			if(Main.lvwAddresses.getSelectionModel().isEmpty()) 
			{
				Main.lblListsStatus.setText("Must select an address");
			}
			else 
			{
				String[] buildings = Main.vm.getBuildings(Main.lvwAddresses.getSelectionModel().getSelectedItem());
				if(buildings.length == 0) 
				{
					Main.lvwBuildings.getItems().add("Default");
				}
				else 
				{
					Controller.generateBuildings(Main.lvwAddresses.getSelectionModel().getSelectedItem());
					Main.lblListsStatus.setText("Buildings Generated");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
