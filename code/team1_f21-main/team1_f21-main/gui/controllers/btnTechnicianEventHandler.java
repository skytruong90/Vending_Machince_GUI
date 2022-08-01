package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnTechnicianEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.technicianStage = new Stage();
			Pane root = gui.View.buildTechnicianStage();
			Scene scene = new Scene(root,800,400);
			Main.technicianStage.setTitle("Vending Machine (Technician)");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.technicianStage.setScene(scene);
			Main.mainStage.close();
			Main.technicianStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


