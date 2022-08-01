package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRestockItemsEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.restockItemsStage = new Stage();
			Pane root = gui.View.buildRestockItemsStage();
			Scene scene = new Scene(root,800,400);
			Main.restockItemsStage.setTitle("Restock Items");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.restockItemsStage.setScene(scene);
			Main.technicianStage.close();
			Main.restockItemsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
