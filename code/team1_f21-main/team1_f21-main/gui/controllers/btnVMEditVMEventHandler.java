package gui.controllers;

import gui.Main;
import gui.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnVMEditVMEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) 
	{
		try 
		{
			Main.editActionVMStage = new Stage();
			Pane root = View.buildEditActionVMStage();
			Scene scene = new Scene(root,800,400);
			Main.editActionVMStage.setTitle("Edit Vending");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.editActionVMStage.setScene(scene);
			Main.editVMStage.close();
			Main.editActionVMStage.show();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
