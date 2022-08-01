package gui.controllers;

import gui.Controller;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vmClasses.VMManager;
import vmClasses.VendingMachine;
import gui.View;

public class btnCreateCustomerActionEventHandler implements EventHandler<ActionEvent> 
{
	@Override
	public void handle(ActionEvent event) {
		try {
			if((Main.txfNumNickles.getText().length() == 0)||
			  (Main.txfNumDimes.getText().length() == 0)||
			  (Main.txfNumQuarters.getText().length() == 0)||
			  (Main.txfNumDollars.getText().length() == 0)) {
				Main.lblCustomerCreateStatus.setText("Must have Nickles, Dimes, Quarters, and Dollars");
			}
			else if((!(Controller.isInt(Main.txfNumNickles.getText())))||
					(!(Controller.isInt(Main.txfNumDimes.getText())))||
					(!(Controller.isInt(Main.txfNumQuarters.getText())))||
					(!(Controller.isInt(Main.txfNumDollars.getText())))){
				Main.lblCustomerCreateStatus.setText("Nickles, Dimes, Quarters, and Dollars must be integers!");
			}
			else {
				VendingMachine[] newVm = Main.vm.getVMs();
				VendingMachine v = newVm[Main.vmIndex];
				int nickles = Integer.parseInt(Main.txfNumNickles.getText());
				int dimes = Integer.parseInt(Main.txfNumDimes.getText());
				int quarters = Integer.parseInt(Main.txfNumQuarters.getText());
				int dollars = Integer.parseInt(Main.txfNumDollars.getText());
				
				while(nickles > 0) {
					v.addNickel_Customer();
					nickles--;
				}
				while(dimes > 0) {
					v.addDime_Customer();
					dimes--;
				}
				while(quarters > 0) {
					v.addQuarter_Customer();
					quarters--;
				}
				while(dollars > 0) {
					v.addDollar_Customer();
					dollars--;
				}
				
				newVm[Main.vmIndex] = v;
				Main.vm = new VMManager(newVm);
				
//				String heightWidth = Main.vm.getHeightWidth(Main.itemName, Main.vm.getVMs()[Main.vmIndex]);
//				String[] hw = heightWidth.split("/");
//				Main.height = Integer.parseInt(hw[0]);
//				Main.width = Integer.parseInt(hw[1]);
				
				Main.lblPurchaseStatus = new Label("");
				if((Main.vm.getVMs()[Main.vmIndex].purchaseItem_Cash(Main.height,Main.width))) {
					Main.lblPurchaseStatus.setText("Purchase Successful");
				}
				else {
					Main.lblPurchaseStatus.setText("Purchase Failed");
				}
				
				Main.purchaseStage = new Stage();
				Pane root = View.buildPurchaseStage();
				Scene scene = new Scene(root,800,400);
				Main.purchaseStage.setTitle("Purchase Item");
				scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
				Main.purchaseStage.setScene(scene);
				Main.createCustomerStage.close();
				Main.purchaseStage.show();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
