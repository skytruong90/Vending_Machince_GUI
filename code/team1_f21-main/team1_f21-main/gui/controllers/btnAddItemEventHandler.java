package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnAddItemEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.addItemStage = new Stage();
			Pane root = View.buildAddItemStage();
			Scene scene = new Scene(root,800,400);
			Main.addItemStage.setTitle("Add Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.addItemStage.setScene(scene);
			Main.managerStage.close();
			Main.addItemStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
