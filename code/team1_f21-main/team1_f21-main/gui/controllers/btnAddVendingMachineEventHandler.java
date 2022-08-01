package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnAddVendingMachineEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.addVMStage = new Stage();
			Pane root = View.buildAddVMStage();
			Scene scene = new Scene(root,800,400);
			Main.addVMStage.setTitle("Adding Vending Machines");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.addVMStage.setScene(scene);
			Main.managerStage.close();
			Main.addVMStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

