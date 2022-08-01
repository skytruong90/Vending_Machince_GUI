package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnReportsEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.reportsStage = new Stage();
			Pane root = View.buildReportsStage();
			Scene scene = new Scene(root,1600,800);
			Main.reportsStage.setTitle("Reports");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.reportsStage.setScene(scene);
			Main.managerStage.close();
			Main.reportsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
