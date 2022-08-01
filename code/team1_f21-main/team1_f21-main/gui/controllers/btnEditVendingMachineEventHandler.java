package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnEditVendingMachineEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try{
			Main.editVMStage = new Stage();
			Pane root = View.buildEditVMStage();
			Scene scene = new Scene(root,800,400);
			Main.editVMStage.setTitle("Edit Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.editVMStage.setScene(scene);
			Main.managerStage.close();
			Main.editVMStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

