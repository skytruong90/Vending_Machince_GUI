package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnBuyItemCashEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			String name = Main.lvwItems.getSelectionModel().getSelectedItem();
			Main.itemName = name;
			
			Main.createCustomerStage = new Stage();
			Pane root = View.buildCreateCustomerStage();
			Scene scene = new Scene(root,800,400);
			Main.createCustomerStage.setTitle("Create Customer");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.createCustomerStage.setScene(scene);
			Main.chooseItemStage.close();
			Main.createCustomerStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
