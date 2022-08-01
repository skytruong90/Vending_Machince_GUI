package gui;
import javafx.application.Application;
import javafx.stage.Stage;
import vmClasses.Reports;
import vmClasses.VMManager;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class Main extends Application 
{
	public static VMManager vm = new VMManager();
	public static Reports report = new Reports(vm);
	public static int vmIndex,width,height;
	public static String itemName;
	public static double price;
	public static Stage mainStage;
	public static Stage customerStage;
	public static Stage managerStage;
	public static Stage technicianStage;
	public static Stage addItemStage;
	public static Stage editVMStage;
	public static Stage restockCashStage;
	public static Stage restockItemsStage;
	public static Stage addVMStage;
	public static Stage addItemsActionStage;
	public static Stage chooseItemStage;
	public static Stage buyItemStage;
	public static Stage createCustomerStage;
	public static Stage purchaseStage;
	public static Stage restockingItemChooseStage;
	public static Stage restockingItemStage;
	public static Stage restockingCashStage;
	public static Stage reportsStage;
	public static Stage editActionVMStage;
	public static Button btnCustomer;
	public static Button btnManager;
	public static Button btnTechnician;
	public static Button btnAddress;
	public static Button btnBuilding;
	public static Button btnVM;
	public static Button btnAddVendingMachine;
	public static Button btnAddItem;
	public static Button btnEditVendingMachine;
	public static Button btnRestockCoins;
	public static Button btnRestockItems;
	public static Button btnAddVMAction;
	public static Button btnAddItemAction;
	public static Button btnBuyItemCash;
	public static Button btnBuyItemCard;
	public static Button btnRestockingItemChoose;
	public static Button btnRestock;
	public static Button btnReports;
	public static Button btnRemoveVM;
	public static ListView<String> lvwAddresses, lvwBuildings, lvwVendingMachines, lvwItems;
	public static Label lblAddress, lblBuilding, lblVendingMachine, lblListsStatus, lblAddVM,
						   lblAddItem,lblCustomerCreateStatus,lblBuyItemStatus,lblPurchaseStatus,
						   lblRestock, lblRestockStatus, lblRestockCash, lblRemoveStatus, lblRemoveVM;
	public static TextField txfAddress,txfBuilding,txfCompany,txfWidth,txfHeight, txfCap,
							   txfName, txfManufacturer, txfCost, txfPrice, txfMonth, txfDay,
							   txfYear,txfNumNickles,txfNumDimes,txfNumQuarters,txfNumDollars,
							   txfQuantity, txfItemName, txfMaxTemp, txfMinTemp;
	public static TextArea txaReports;
	public static Button btnReturnMenu = new Button("Go To Main Menu");
	public static Button btnRemoveVMAction, btnRemoveItem, btnEditVM;
	public static Stage removeVMStage, removeItemStage, removeSelectItemStage, addRefrigeratedItemsActionStage;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Pane root = View.buildMainStage();
			Scene scene = new Scene(root,800,400);
			primaryStage.setTitle("Vending Machine Home Page");
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			this.mainStage = primaryStage;
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
