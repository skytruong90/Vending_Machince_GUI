package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class btnRemoveItemActionEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent arg0) 
	{
		try 
		{
			String input = Main.lvwItems.getSelectionModel().getSelectedItem().toLowerCase();
			if(Main.vm.getVMs()[Main.vmIndex].removeItem(input))
			{
				Main.lblRemoveStatus.setText("Success!");
				Main.lvwItems.getSelectionModel().clearSelection();
			}
			else 
			{
				Main.lblRemoveStatus.setText("Failed");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
