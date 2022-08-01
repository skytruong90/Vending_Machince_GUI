package gui.controllers;

import gui.View;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class btnBuyItemCardEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			String name = Main.lvwItems.getSelectionModel().getSelectedItem();
			Main.itemName = name;
			
			Main.lblPurchaseStatus = new Label("");
			if((Main.vm.getVMs()[Main.vmIndex].purchaseItem_Card(Main.height,Main.width))) 
			{
				Main.lblPurchaseStatus.setText("Purchase Successful");
			}
			else 
			{
				Main.lblPurchaseStatus.setText("Purchase Failed");
			}
			
			Main.purchaseStage = new Stage();
			Pane root = View.buildPurchaseStage();
			Scene scene = new Scene(root,800,400);
			Main.purchaseStage.setTitle("Purchase Item");
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			Main.purchaseStage.setScene(scene);
			Main.chooseItemStage.close();
			Main.purchaseStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
