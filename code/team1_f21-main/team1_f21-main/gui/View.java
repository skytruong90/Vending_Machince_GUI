package gui;

import gui.controllers.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import vmClasses.VendingMachine;

public class View 
{
	public static Pane buildCustomerStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnVMCustomerEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuCustomerEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildCreateCustomerStage() 
	{
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		h1.getChildren().add(new Label("Number of Nickles(Required):"));
		Main.txfNumNickles = new TextField();
		h1.getChildren().add(Main.txfNumNickles);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		h2.getChildren().add(new Label("Number of Dimes(Required):"));
		Main.txfNumDimes = new TextField();
		h2.getChildren().add(Main.txfNumDimes);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		h3.getChildren().add(new Label("Number of Quarters(Required):"));
		Main.txfNumQuarters = new TextField();
		h3.getChildren().add(Main.txfNumQuarters);
		
		HBox h4 = new HBox();
		h4.getStyleClass().add("h_or_v_box");
		h4.getChildren().add(new Label("Number of Dollars(Required):"));
		Main.txfNumDollars = new TextField();
		h4.getChildren().add(Main.txfNumDollars);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuCreateCustomerEventHandler());
		Main.btnAddItemAction = new Button("Create Customer");
		Main.btnAddItemAction.setOnAction(new btnCreateCustomerActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnAddItemAction);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblCustomerCreateStatus = new Label("");
		vBox.getChildren().addAll(new Label("Create a Customer"),h1,h2,h3,h4,Main.lblCustomerCreateStatus,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}

	public static Pane buildPurchaseStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuPurchaseEventHandler());
		vBox.getChildren().add(Main.lblPurchaseStatus);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildAddItemStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnVMAddItemEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuAddItemEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRestockingCashStage() 
	{
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		Button addNickle = new Button("+.05");
		Button addDime = new Button("+.10");
		addNickle.setOnAction(new btnAddNickleEventHandler());
		addDime.setOnAction(new btnAddDimeEventHandler());
		h1.getChildren().addAll(addNickle,addDime);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		Button addQuarter = new Button("+.25");
		Button addDollar = new Button("+1");
		addQuarter.setOnAction(new btnAddQuarterEventHandler());
		addDollar.setOnAction(new btnAddDollarEventHandler());
		h2.getChildren().addAll(addQuarter,addDollar);
		
		VBox v1 = new VBox();
		v1.getStyleClass().add("h_or_v_box");
		v1.getChildren().addAll(h1,h2);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		Button deleteNickle = new Button("-.05");
		Button deleteDime = new Button("-.10");
		deleteNickle.setOnAction(new btnRemoveNickleEventHandler());
		deleteDime.setOnAction(new btnRemoveDimeEventHandler());
		h3.getChildren().addAll(deleteNickle,deleteDime);
		
		HBox h4 = new HBox();
		h4.getStyleClass().add("h_or_v_box");
		Button deleteQuarter = new Button("-.25");
		Button deleteDollar = new Button("-1");
		deleteQuarter.setOnAction(new btnRemoveQuarterEventHandler());
		deleteDollar.setOnAction(new btnRemoveDollarEventHandler());
		h4.getChildren().addAll(deleteQuarter,deleteDollar);
		
		VBox v2 = new VBox();
		v2.getStyleClass().add("h_or_v_box");
		v2.getChildren().addAll(h3,h4);
		
		HBox h = new HBox();
		h.getStyleClass().add("h_or_v_box");
		h.getChildren().addAll(v1,v2);
		

		Main.btnReturnMenu.setOnAction(new btnReturnMenuRestockingCashEventHandler());

		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblRestockCash = new Label(String.format("Nickels: %d  Dimes: %d  Quarters: %d  Dollars:%d", Main.vm.getVMs()[Main.vmIndex].getNumNickels(),Main.vm.getVMs()[Main.vmIndex].getNumDimes(),Main.vm.getVMs()[Main.vmIndex].getNumQuarters(),Main.vm.getVMs()[Main.vmIndex].getNumDollars()));
		vBox.getChildren().addAll(Main.lblRestockCash,h,Main.btnReturnMenu);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRestockingItemStage() 
	{
		HBox h = new HBox();
		h.getStyleClass().add("h_or_v_box");
		h.getChildren().add(new Label("Quantity(Required):"));
		Main.txfQuantity = new TextField();
		h.getChildren().add(Main.txfQuantity);
		

		Main.lblRestockStatus = new Label("");
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRestockingItemEventHandler());
		Main.btnRestock = new Button("Restock");
		Main.btnRestock.setOnAction(new btnRestockEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnRestock);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblAddItem = new Label("");
		vBox.getChildren().addAll(Main.lblRestockStatus,h,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildMainStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnCustomer = new Button("Customer");
		Main.btnCustomer.setOnAction(new btnCustomerEventHandler());
		Main.btnManager = new Button("Manager");
		Main.btnManager.setOnAction(new btnManagerEventHandler());
		Main.btnTechnician = new Button("Technician");
		Main.btnTechnician.setOnAction(new btnTechnicianEventHandler());
		vBox.getChildren().add(Main.btnCustomer);
		vBox.getChildren().add(Main.btnManager);
		vBox.getChildren().add(Main.btnTechnician);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildManagerStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnAddVendingMachine = new Button("Add Vending Machine");
		Main.btnAddVendingMachine.setOnAction(new btnAddVendingMachineEventHandler());
		Main.btnRemoveVM = new Button("Remove Vending Machine");
		Main.btnRemoveVM.setOnAction(new btnRemoveVMEventHandler());
		Main.btnAddItem = new Button("Add Item");
		Main.btnAddItem.setOnAction(new btnAddItemEventHandler());
		Main.btnRemoveItem = new Button("Remove Item");
		Main.btnRemoveItem.setOnAction(new btnRemoveItemEventHandler());
		Main.btnEditVendingMachine = new Button("Edit Vending Machine");
		Main.btnEditVendingMachine.setOnAction(new btnEditVendingMachineEventHandler());
		Main.btnReports = new Button("Reports");
		Main.btnReports.setOnAction(new btnReportsEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuManagerEventHandler());
		vBox.getChildren().add(Main.btnAddVendingMachine);
		vBox.getChildren().add(Main.btnRemoveVM);
		vBox.getChildren().add(Main.btnAddItem);
		vBox.getChildren().add(Main.btnRemoveItem);
		vBox.getChildren().add(Main.btnEditVendingMachine);
		vBox.getChildren().add(Main.btnReports);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildTechnicianStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnRestockCoins = new Button("Restock Currency");
		Main.btnRestockCoins.setOnAction(new btnRestockCoinsEventHandler());
		Main.btnRestockItems = new Button("Restock Items");
		Main.btnRestockItems.setOnAction(new btnRestockItemsEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuTechnicianEventHandler());
		vBox.getChildren().add(Main.btnRestockCoins);
		vBox.getChildren().add(Main.btnRestockItems);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRestockItemsStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnVMRestockItemsEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRestockItemsEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRestockCashStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnVMRestockCashEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRestockCashEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildEditVMStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnVMEditVMEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuEditVMEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildEditActionVMStage() {
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		h1.getChildren().add(new Label("Location:"));
		Main.txfAddress = new TextField();
		h1.getChildren().add(Main.txfAddress);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		h2.getChildren().add(new Label("Building:"));
		Main.txfBuilding = new TextField();
		h2.getChildren().add(Main.txfBuilding);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		h3.getChildren().add(new Label("Company:"));
		Main.txfCompany = new TextField();
		h3.getChildren().add(Main.txfCompany);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnEditVM = new Button("Edit Vending Machine");
		Main.btnEditVM.setOnAction(new btnVMEditActionEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuEditVMActionEventHandler());
		buttons.getChildren().addAll(Main.btnEditVM,Main.btnReturnMenu);
		
		vBox.getChildren().addAll(h1,h2,h3,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildReportsStage() 
	{
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		
		HBox textBoxes = new HBox();
		textBoxes.getStyleClass().add("h_or_v_box");
		Label location = new Label("Location:");
		Main.txfAddress = new TextField();
		Label building = new Label("Building:");
		Main.txfBuilding = new TextField();
		Label company = new Label("Company:");
		Main.txfCompany = new TextField();
		Label name = new Label("Item Name:");
		Main.txfName = new TextField();
		Label manufacturer = new Label("Manufacturer:");
		Main.txfManufacturer = new TextField();
		textBoxes.getChildren().addAll(location,Main.txfAddress,building,Main.txfBuilding,company,Main.txfCompany,name,Main.txfName,manufacturer,Main.txfManufacturer);
		
		Button MachineReport = new Button("Machine Report");
		MachineReport.setOnAction(new btnMachineReportEventHandler());
		Button ProductReport = new Button("Product Report");
		ProductReport.setOnAction(new btnProductReportEventHandler());
		Button DetailedMachineReport = new Button("Detailed Machine Report");
		DetailedMachineReport.setOnAction(new btnDetailedMachineReportEventHandler());
		Button LocationReport = new Button("Location Report");
		LocationReport.setOnAction(new btnLocationReportEventHandler());
		Button CompanyReport = new Button("Company Report");
		CompanyReport.setOnAction(new btnCompanyReportEventHandler());
		Button DryGoodsReport = new Button("Dry Goods Report");
		DryGoodsReport.setOnAction(new btnDryGoodsReportEventHandler());
		Button RefrigeratedGoodsReport = new Button("Refrigerated Goods Report");
		RefrigeratedGoodsReport.setOnAction(new btnRefrigeratedGoodsReportEventHandler());
		Button GoodsReport = new Button("Goods Report");
		GoodsReport.setOnAction(new btnGoodsReportEventHandler());
		Button ManufacturerReport = new Button("Manufacturer Report");
		ManufacturerReport.setOnAction(new btnManufacturerReportEventHandler());
		Button ReturnMainMenu = new Button("Return to Main Menu");
		ReturnMainMenu.setOnAction(new btnReturnMainReportEventHandler());
		
		HBox expiredInventory = new HBox();
		expiredInventory.getStyleClass().add("h_or_v_box");
		Label month = new Label("Current Month:");
		Main.txfMonth = new TextField();
		Label day = new Label("Current Day:");
		Main.txfDay = new TextField();
		Label year = new Label("Current Year:");
		Main.txfYear = new TextField();
		Button ExpiredInventoryReport = new Button("Expired Inventory Report:");
		ExpiredInventoryReport.setOnAction(new btnExpiredInventoryReportEventHandler());
		expiredInventory.getChildren().addAll(month,Main.txfMonth,day,Main.txfDay,year,Main.txfYear,ExpiredInventoryReport);
		
		Main.txaReports = new TextArea();
		
		vBox.getChildren().addAll(textBoxes,MachineReport,ProductReport,DetailedMachineReport,LocationReport,CompanyReport,DryGoodsReport,RefrigeratedGoodsReport,GoodsReport,ManufacturerReport,expiredInventory,ReturnMainMenu,Main.txaReports);
		
		GridPane root = new GridPane();
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildAddItemsActionStage() 
	{
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		h1.getChildren().add(new Label("Name(Required):"));
		Main.txfName = new TextField();
		h1.getChildren().add(Main.txfName);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		h2.getChildren().add(new Label("Manufacturer(Required):"));
		Main.txfManufacturer = new TextField();
		h2.getChildren().add(Main.txfManufacturer);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		h3.getChildren().add(new Label("Cost(Required):"));
		Main.txfCost = new TextField();
		h3.getChildren().add(Main.txfCost);
		
		HBox h4 = new HBox();
		h4.getStyleClass().add("h_or_v_box");
		h4.getChildren().add(new Label("Price(Optional but will set price at $0.00):"));
		Main.txfPrice = new TextField();
		h4.getChildren().add(Main.txfPrice);
		
		HBox h5 = new HBox();
		h5.getStyleClass().add("h_or_v_box");
		h5.getChildren().add(new Label("Expiration Date(Required in mm dd yyyy):"));
		Main.txfMonth = new TextField();
		Main.txfDay = new TextField();
		Main.txfYear = new TextField();
		h5.getChildren().add(Main.txfMonth);
		h5.getChildren().add(new Label("/"));
		h5.getChildren().add(Main.txfDay);
		h5.getChildren().add(new Label("/"));
		h5.getChildren().add(Main.txfYear);
		
		HBox h6 = new HBox();
		h6.getStyleClass().add("h_or_v_box");
		h6.getChildren().add(new Label("Height(Required):"));
		Main.txfHeight = new TextField();
		h6.getChildren().add(Main.txfHeight);
		
		HBox h7 = new HBox();
		h7.getStyleClass().add("h_or_v_box");
		h7.getChildren().add(new Label("Width(Required):"));
		Main.txfWidth = new TextField();
		h7.getChildren().add(Main.txfWidth);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuAddItemActionEventHandler());
		Main.btnAddItemAction = new Button("Create Item");
		Main.btnAddItemAction.setOnAction(new btnAddItemActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnAddItemAction);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblAddItem = new Label("");
		vBox.getChildren().addAll(Main.lblAddItem,h1,h2,h3,h4,h5,h6,h7,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildAddRefrigeratedItemsActionStage() 
	{
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		h1.getChildren().add(new Label("Name(Required):"));
		Main.txfName = new TextField();
		h1.getChildren().add(Main.txfName);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		h2.getChildren().add(new Label("Manufacturer(Required):"));
		Main.txfManufacturer = new TextField();
		h2.getChildren().add(Main.txfManufacturer);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		h3.getChildren().add(new Label("Cost(Required):"));
		Main.txfCost = new TextField();
		h3.getChildren().add(Main.txfCost);
		
		HBox h4 = new HBox();
		h4.getStyleClass().add("h_or_v_box");
		h4.getChildren().add(new Label("Price(Optional but will set price at $0.00):"));
		Main.txfPrice = new TextField();
		h4.getChildren().add(Main.txfPrice);
		
		HBox h5 = new HBox();
		h5.getStyleClass().add("h_or_v_box");
		h5.getChildren().add(new Label("Expiration Date(Required in mm dd yyyy):"));
		Main.txfMonth = new TextField();
		Main.txfDay = new TextField();
		Main.txfYear = new TextField();
		h5.getChildren().add(Main.txfMonth);
		h5.getChildren().add(new Label("/"));
		h5.getChildren().add(Main.txfDay);
		h5.getChildren().add(new Label("/"));
		h5.getChildren().add(Main.txfYear);
		
		HBox h6 = new HBox();
		h6.getStyleClass().add("h_or_v_box");
		h6.getChildren().add(new Label("Height(Required):"));
		Main.txfHeight = new TextField();
		h6.getChildren().add(Main.txfHeight);
		
		HBox h7 = new HBox();
		h7.getStyleClass().add("h_or_v_box");
		h7.getChildren().add(new Label("Width(Required):"));
		Main.txfWidth = new TextField();
		h7.getChildren().add(Main.txfWidth);
		
		HBox h8 = new HBox();
		h8.getStyleClass().add("h_or_v_box");
		h8.getChildren().add(new Label("Min Temp(Required):"));
		Main.txfMinTemp = new TextField();
		h8.getChildren().add(Main.txfMinTemp);
		
		HBox h9 = new HBox();
		h9.getStyleClass().add("h_or_v_box");
		h9.getChildren().add(new Label("Max Temp(Required):"));
		Main.txfMaxTemp = new TextField();
		h9.getChildren().add(Main.txfMaxTemp);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuAddItemActionEventHandler());
		Main.btnAddItemAction = new Button("Create Item");
		Main.btnAddItemAction.setOnAction(new btnAddRefrigeratedItemActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnAddItemAction);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblAddItem = new Label("");
		vBox.getChildren().addAll(Main.lblAddItem,h1,h2,h3,h4,h5,h6,h7,h8,h9,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRestockingItemChooseStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().add(new Label("Items"));
		VendingMachine v;
		
		if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none")) 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		else 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwBuildings.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		Main.lvwItems = new ListView<>();
		Controller.generateItems(v);
		vBox.getChildren().add(Main.lvwItems);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRestockingItemChooseEventHandler());
		Main.btnRestockingItemChoose = new Button("Choose Item");
		Main.btnRestockingItemChoose.setOnAction(new btnRestockingItemChooseEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnRestockingItemChoose);
		vBox.getChildren().add(buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildAddVMStage() 
	{
		HBox h1 = new HBox();
		h1.getStyleClass().add("h_or_v_box");
		h1.getChildren().add(new Label("Address(Required):"));
		Main.txfAddress = new TextField();
		h1.getChildren().add(Main.txfAddress);
		
		HBox h2 = new HBox();
		h2.getStyleClass().add("h_or_v_box");
		h2.getChildren().add(new Label("Building(Optional):"));
		Main.txfBuilding = new TextField();
		h2.getChildren().add(Main.txfBuilding);
		
		HBox h3 = new HBox();
		h3.getStyleClass().add("h_or_v_box");
		h3.getChildren().add(new Label("Company(Required):"));
		Main.txfCompany = new TextField();
		h3.getChildren().add(Main.txfCompany);
		
		HBox h4 = new HBox();
		h4.getStyleClass().add("h_or_v_box");
		h4.getChildren().add(new Label("Height(Required):"));
		Main.txfHeight = new TextField();
		h4.getChildren().add(Main.txfHeight);
		
		HBox h5 = new HBox();
		h5.getStyleClass().add("h_or_v_box");
		h5.getChildren().add(new Label("Width(Required):"));
		Main.txfWidth = new TextField();
		h5.getChildren().add(Main.txfWidth);
		
		HBox h6 = new HBox();
		h6.getStyleClass().add("h_or_v_box");
		h6.getChildren().add(new Label("Capacity(Required):"));
		Main.txfCap = new TextField();
		h6.getChildren().add(Main.txfCap);
		
		HBox h7 = new HBox();
		h7.getStyleClass().add("h_or_v_box");
		h7.getChildren().add(new Label("Max Temp(Makes Refrigerated VM):"));
		Main.txfMaxTemp = new TextField();
		h7.getChildren().add(Main.txfMaxTemp);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuAddVMEventHandler());
		Main.btnAddVMAction = new Button("Create Vending Machine");
		Main.btnAddVMAction.setOnAction(new btnAddVMActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnAddVMAction);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblAddVM = new Label("");
		vBox.getChildren().addAll(Main.lblAddVM,h1,h2,h3,h4,h5,h6,h7,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane chooseItemStage() 
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().add(new Label("Items"));
		VendingMachine v;
		
		if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none")) 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		else 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwBuildings.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		Main.lvwItems = new ListView<>();
		Controller.generateItems(v);
		vBox.getChildren().add(Main.lvwItems);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuChooseItemEventHandler());
		Main.btnBuyItemCash = new Button("Buy Item With Cash");
		Main.btnBuyItemCash.setOnAction(new btnBuyItemCashEventHandler());
		Main.btnBuyItemCard = new Button("Buy Item With Card");
		Main.btnBuyItemCard.setOnAction(new btnBuyItemCardEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnBuyItemCash,Main.btnBuyItemCard);
		vBox.getChildren().add(buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildSelectRemoveItemStage()
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().add(new Label("Items"));
		VendingMachine v;
		
		if(Main.lvwBuildings.getSelectionModel().getSelectedItem().equals("none")) 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		else 
		{
			v = Main.vm.getVM(Main.lvwAddresses.getSelectionModel().getSelectedItem(), Main.lvwBuildings.getSelectionModel().getSelectedItem(), Main.lvwVendingMachines.getSelectionModel().getSelectedItem());
		}
		Main.lvwItems = new ListView<>();
		Controller.generateItems(v);
		vBox.getChildren().add(Main.lvwItems);
		
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuChooseItemEventHandler());
		Main.btnRemoveItem = new Button("Remove selected Item");
		Main.btnRemoveItem.setOnAction(new btnRemoveItemActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnRemoveItem);
		vBox.getChildren().add(buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static VBox buildListsMenu() 
	{
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().add(buildLists());
		Main.lblListsStatus = new Label("");
		vBox.getChildren().add(Main.lblListsStatus);
		return vBox;
	}
	
	public static HBox buildLists() 
	{
		HBox hBox = new HBox();
		hBox.getChildren().add(buildAddressList());
		hBox.getChildren().add(buildBuildingList());
		hBox.getChildren().add(buildVMList());
		return hBox;
	}
	
	public static VBox buildAddressList() 
	{
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblAddress = new Label("Address");
		Main.lvwAddresses = new ListView<>();
		Controller.generateAddresses();
		Main.lvwAddresses.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Main.btnAddress = new Button("Choose Address");
		Main.btnAddress.setOnAction(new btnAddressEventHandler());
		vBox.getChildren().add(Main.lblAddress);
		vBox.getChildren().add(Main.lvwAddresses);
		vBox.getChildren().add(Main.btnAddress);
		return vBox;
	}
	
	public static VBox buildBuildingList() 
	{
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblBuilding = new Label("Building");
		Main.lvwBuildings = new ListView<>();
		Main.lvwBuildings.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Main.btnBuilding = new Button("Generate Vending Machines");
		Main.btnBuilding.setOnAction(new btnBuildingEventHandler());
		vBox.getChildren().add(Main.lblBuilding);
		vBox.getChildren().add(Main.lvwBuildings);
		vBox.getChildren().add(Main.btnBuilding);
		return vBox;
	}
	
	public static VBox buildVMList() 
	{
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblVendingMachine = new Label("Vending Machine");
		Main.lvwVendingMachines = new ListView<>();
		Main.lvwVendingMachines.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		vBox.getChildren().add(Main.lblVendingMachine);
		vBox.getChildren().add(Main.lvwVendingMachines);
		return vBox;
	}

	public static Pane buildRemoveVMStage() 
	{
		HBox buttons = new HBox();
		buttons.getStyleClass().add("h_or_v_box");
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRemoveVMEventHandler());
		Main.btnRemoveVMAction = new Button("Remove Vending Machine");
		Main.btnRemoveVMAction.setOnAction(new btnRemoveVMActionEventHandler());
		buttons.getChildren().addAll(Main.btnReturnMenu,Main.btnRemoveVMAction);
		
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.lblRemoveVM = new Label("");
		vBox.getChildren().addAll(buildListsMenu(),Main.lblRemoveVM,buttons);
		
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
	
	public static Pane buildRemoveItemStage()
	{
		GridPane root = new GridPane();
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		Main.btnVM = new Button("Go To Vending Machine");
		Main.btnVM.setOnAction(new btnSelectRemoveItemEventHandler());
		Main.btnReturnMenu.setOnAction(new btnReturnMenuRemoveItemEventHandler());
		vBox.getChildren().add(buildListsMenu());
		vBox.getChildren().add(Main.btnVM);
		vBox.getChildren().add(Main.btnReturnMenu);
		vBox.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		root.add(vBox,0,0);
		return root;
	}
}
