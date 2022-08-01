package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnReturnMainReportEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) 
	{
		try 
		{
			Main.mainStage = new Stage();
			Pane root = gui.View.buildMainStage();
			Scene scene = new Scene(root,800,400);
			Main.mainStage.setTitle("Vending Machine Home Page");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.reportsStage.close();
			Main.mainStage.show();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
