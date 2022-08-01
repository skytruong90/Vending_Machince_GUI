package gui.controllers;

import gui.Main;
import gui.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRemoveItemEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) 
	{
		try {
			Main.removeItemStage = new Stage();
			Pane root = View.buildRemoveItemStage();
			Scene scene = new Scene(root,800,400);
			Main.removeItemStage.setTitle("Remove Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.removeItemStage.setScene(scene);
			Main.managerStage.close();
			Main.removeItemStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
