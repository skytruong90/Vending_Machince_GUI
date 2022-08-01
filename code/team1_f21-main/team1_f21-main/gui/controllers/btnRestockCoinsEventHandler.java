package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnRestockCoinsEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.restockCashStage = new Stage();
			Pane root = View.buildRestockCashStage();
			Scene scene = new Scene(root,800,400);
			Main.restockCashStage.setTitle("Restock Money");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.restockCashStage.setScene(scene);
			Main.technicianStage.close();
			Main.restockCashStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

