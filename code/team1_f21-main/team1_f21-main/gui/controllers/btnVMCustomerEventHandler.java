package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnVMCustomerEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.chooseItemStage = new Stage();
			Pane root = gui.View.chooseItemStage();
			Scene scene = new Scene(root,800,400);
			Main.chooseItemStage.setTitle("Choose Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.chooseItemStage.setScene(scene);
			Main.customerStage.close();
			Main.chooseItemStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
