package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRestockingItemChooseEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try {
			String name = Main.lvwItems.getSelectionModel().getSelectedItem();
			Main.itemName = name;
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
			String heightWidth = Main.vm.getHeightWidth(Main.itemName, Main.vm.getVMs()[Main.vmIndex]);
			String[] hw = heightWidth.split("/");
			Main.height = Integer.parseInt(hw[0]);
			Main.width = Integer.parseInt(hw[1]);
			
			Main.restockingItemStage = new Stage();
			Pane root = gui.View.buildRestockingItemStage();
			Scene scene = new Scene(root,800,400);
			Main.restockingItemStage.setTitle("Restock Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.restockingItemStage.setScene(scene);
			Main.restockingItemChooseStage.close();
			Main.restockingItemStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
