package gui.controllers;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vmClasses.VendingMachine;

public class btnDetailedMachineReportEventHandler implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) {
		try {
			Main.txaReports.clear();
			String location = Main.txfAddress.getText();
			String building = Main.txfBuilding.getText();
			String company = Main.txfCompany.getText();
			
			if((location.length() == 0)||(company.length() == 0)) {
				Main.txaReports.setText("Location,Company, and/or Building must be filled!");
			}
			else if(building.length() != 0) {
				VendingMachine vm = Main.vm.getVM(location, building, company);
				if(vm == null) {
					Main.txaReports.setText("No Vending Machine Found");
				}
				else {
					Main.txaReports.setText(Main.report.DetailedMachineReport(vm));
				}
			}
			else {
				VendingMachine vm = Main.vm.getVM(location, company);
				if(vm == null) {
					Main.txaReports.setText("No Vending Machine Found");
				}
				else {
					Main.txaReports.setText(Main.report.DetailedMachineReport(vm));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
