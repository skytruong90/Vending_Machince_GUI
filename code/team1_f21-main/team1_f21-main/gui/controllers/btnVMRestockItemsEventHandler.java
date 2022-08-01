package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnVMRestockItemsEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.restockingItemChooseStage = new Stage();
			Pane root =  View.buildRestockingItemChooseStage();
			Scene scene = new Scene(root,800,400);
			Main.restockingItemChooseStage.setTitle("Choose an Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.restockingItemChooseStage.setScene(scene);
			Main.restockItemsStage.close();
			Main.restockingItemChooseStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
