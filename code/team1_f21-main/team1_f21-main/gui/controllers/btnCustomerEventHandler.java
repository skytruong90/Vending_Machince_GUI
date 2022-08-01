package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnCustomerEventHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent event) 
	{
		try {
			Main.customerStage = new Stage();
			Pane root = View.buildCustomerStage();
			Scene scene = new Scene(root,800,400);
			Main.customerStage.setTitle("Vending Machine (Customer)");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.customerStage.setScene(scene);
			Main.mainStage.close();
			Main.customerStage.show();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
