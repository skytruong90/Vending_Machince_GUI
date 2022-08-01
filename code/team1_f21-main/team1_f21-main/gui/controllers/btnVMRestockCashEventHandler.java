package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnVMRestockCashEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.restockingCashStage = new Stage();
			Pane root = View.buildRestockingCashStage();
			Scene scene = new Scene(root,800,400);
			Main.restockingCashStage.setTitle("Restock Cash");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.restockingCashStage.setScene(scene);
			Main.technicianStage.close();
			Main.restockingCashStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
