package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRemoveVMEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.removeVMStage = new Stage();
			Pane root = View.buildRemoveVMStage();
			Scene scene = new Scene(root,800,400);
			Main.removeVMStage.setTitle("Removing Vending Machines");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.removeVMStage.setScene(scene);
			Main.managerStage.close();
			Main.removeVMStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
