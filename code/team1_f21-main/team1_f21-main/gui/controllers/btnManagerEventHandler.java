package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnManagerEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.managerStage = new Stage();
			Pane root = View.buildManagerStage();
			Scene scene = new Scene(root,800,400);
			Main.managerStage.setTitle("Vending Machine (Manager)");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.managerStage.setScene(scene);
			Main.mainStage.close();
			Main.managerStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
