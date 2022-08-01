package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnReturnMenuCustomerEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.mainStage = new Stage();
			Pane root = gui.View.buildMainStage();
			Scene scene = new Scene(root,800,400);
			Main.mainStage.setTitle("Vending Machine Home Page");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.customerStage.close();
			Main.mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
