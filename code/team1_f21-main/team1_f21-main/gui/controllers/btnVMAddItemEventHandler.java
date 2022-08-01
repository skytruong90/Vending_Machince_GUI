package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vmClasses.RefrigeratedVendingMachine;

public class btnVMAddItemEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) 
	{
		try {	
			if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none")) {
				String address = Main.lvwAddresses.getSelectionModel().getSelectedItem();
				String company = Main.lvwVendingMachines.getSelectionModel().getSelectedItem();
				Main.vmIndex = Main.vm.getVMIndex(address, company);
			}
			else {
				String address = Main.lvwAddresses.getSelectionModel().getSelectedItem();
				String building = Main.lvwBuildings.getSelectionModel().getSelectedItem();
				String company = Main.lvwVendingMachines.getSelectionModel().getSelectedItem();
				Main.vmIndex = Main.vm.getVMIndex(address, building, company);
			}
			
			if(Main.vm.getVM(Main.vmIndex).hasTemp()) {
				Main.addRefrigeratedItemsActionStage = new Stage();
				Pane root = gui.View.buildAddRefrigeratedItemsActionStage();
				Scene scene = new Scene(root,800,400);
				Main.addRefrigeratedItemsActionStage.setTitle("Add Item");
				scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
				Main.addRefrigeratedItemsActionStage.setScene(scene);
				Main.addItemStage.close();
				Main.addRefrigeratedItemsActionStage.show();
			}
			else {
				Main.addItemsActionStage = new Stage();
				Pane root = gui.View.buildAddItemsActionStage();
				Scene scene = new Scene(root,800,400);
				Main.addItemsActionStage.setTitle("Add Item");
				scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
				Main.addItemsActionStage.setScene(scene);
				Main.addItemStage.close();
				Main.addItemsActionStage.show();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
