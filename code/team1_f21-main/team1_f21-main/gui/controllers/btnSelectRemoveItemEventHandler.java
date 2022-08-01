package gui.controllers;

import gui.Main;
import gui.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnSelectRemoveItemEventHandler implements EventHandler<ActionEvent> 
{

	@Override
	public void handle(ActionEvent arg0) 
	{
		try {
			Main.removeSelectItemStage = new Stage();
			Pane root = View.buildSelectRemoveItemStage();
			Scene scene = new Scene(root,800,400);
			Main.removeSelectItemStage.setTitle("Remove Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.removeSelectItemStage.setScene(scene);
			Main.removeItemStage.close();
			Main.removeSelectItemStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
