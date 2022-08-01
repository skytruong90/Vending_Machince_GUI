package tests;

import vmClasses.Dispenser;
import vmClasses.Item;
import vmClasses.RefrigeratedItem;
import vmClasses.RefrigeratedVendingMachine;
import vmClasses.Reports;
import vmClasses.VMManager;
import vmClasses.VendingMachine;

public class ReportsTest {
	public static void main(String args[]) {
		VMManager vm = setupTests();
		Reports report = new Reports(vm);

		testMachineReport(report,vm);
		testProductReport(report);
		testDetailedMachineReport(report,vm);
		testLocationReport(report);
		testCompanyReport(report);
		testDryGoodsReport(report);
		testRefrigeratedGoodsReport(report);
		testGoodsReport(report);
		testManufacturerReport(report);
		testExpiredInventoryReport(report);
	}
	
	public static VMManager setupTests() {
		RefrigeratedVendingMachine rf1 = new RefrigeratedVendingMachine(2,2,3,"Valdosta","Nevins","Coke",42.0);
		RefrigeratedVendingMachine rf2 = new RefrigeratedVendingMachine(2,2,3,"DC","White House","Pepsi",35.0);
		RefrigeratedVendingMachine rf3 = new RefrigeratedVendingMachine(2,2,3,"Valdosta","Dr.Pepper",38.0);
		VendingMachine dg1 = new VendingMachine(2,2,3,"Valdosta","West","Lays");
		VendingMachine dg2 = new VendingMachine(2,2,3,"Valdosta","Bailey","Pringles");
		VendingMachine dg3 = new VendingMachine(2,2,3,"DC","Lays");
		
		RefrigeratedItem rf1I1 = new RefrigeratedItem("Coke","Coca-cola",.50,1.00,11,17,2021,45.0,50.0);
		rf1.addItemTypeToDispenser(0,0,rf1I1);
		rf1.getDispenser(0,0).addItem(3,rf1I1);
		RefrigeratedItem rf1I2 = new RefrigeratedItem("Coke Zero","Coca-cola",.25,1.00,11,20,2021,45.0,50.0);
		rf1.addItemTypeToDispenser(0,1,rf1I2);
		rf1.getDispenser(0,1).addItem(3,rf1I2);
		RefrigeratedItem rf1I3 = new RefrigeratedItem("Orange Fanta","Fanta",.75,1.50,11,18,2021,42.0,50.0);
		rf1.addItemTypeToDispenser(1,0,rf1I3);
		rf1.getDispenser(1,0).addItem(3,rf1I3);
		for(int i= 1;i <= 10; i++) {
			rf1.addDollar_Customer();
		}
		rf1.purchaseItem_Cash(0,0);
		rf1.purchaseItem_Card(0,0);
		rf1.purchaseItem_Card(0,1);
		rf1.purchaseItem_Cash(1,0);
		rf1.purchaseItem_Cash(1,0);
		
		RefrigeratedItem rf2I1 = new RefrigeratedItem("Pepsi","Pepsi",.40,1.00,12,31,2021,35.0,42.0);
		rf2.addItemTypeToDispenser(0,0,rf2I1);
		rf2.getDispenser(0,0).addItem(3,rf2I1);
		RefrigeratedItem rf2I2 = new RefrigeratedItem("Purple Fanta","Fanta",.75,2.00,11,24,2021,42.0,50.0);
		rf2.addItemTypeToDispenser(0,1,rf2I2);
		rf2.getDispenser(0,1).addItem(3,rf2I2);
		RefrigeratedItem rf2I3 = new RefrigeratedItem("Pepsi MAX","Pepsi",.30,1.00,12,31,2022,35.0,42.0);
		rf2.addItemTypeToDispenser(1,0,rf2I3);
		rf2.getDispenser(1,0).addItem(3,rf2I3);
		for(int i= 1;i <= 10; i++) {
			rf2.addDollar_Customer();
		}
		rf2.purchaseItem_Card(0,0);
		rf2.purchaseItem_Card(0,0);
		rf2.purchaseItem_Cash(0,1);
		rf2.purchaseItem_Cash(0,1);
		rf2.purchaseItem_Card(1,0);
		
		RefrigeratedItem rf3I1 = new RefrigeratedItem("Dr.Pepper","Dr.Pepper",1.00,1.00,05,10,2021,38.0,50.0);
		rf3.addItemTypeToDispenser(0,0,rf3I1);
		rf3.getDispenser(0,0).addItem(3,rf3I1);
		RefrigeratedItem rf3I2 = new RefrigeratedItem("Dr.Pepper Cherry","Dr.Pepper",1.25,1.00,12,31,2021,38.0,50.0);
		rf3.addItemTypeToDispenser(0,1,rf3I2);
		rf3.getDispenser(0,1).addItem(3,rf3I2);
		RefrigeratedItem rf3I3 = new RefrigeratedItem("Dr.Pepper Vanilla","Dr.Pepper",1.25,1.00,11,17,2021,38.0,50.0);
		rf3.addItemTypeToDispenser(1,0,rf3I3);
		rf3.getDispenser(1,0).addItem(3,rf3I3);
		rf3.addDollar_Customer();
		rf3.addDollar_Customer();
		rf3.purchaseItem_Cash(0,0);
		rf3.purchaseItem_Card(0,1);
		rf3.purchaseItem_Card(1,0);
		rf3.purchaseItem_Cash(1,0);
		
		Item dg1I1 = new Item("Potato Chips","Lays",.56,1.25,11,18,2020);
		dg1.addItemTypeToDispenser(0,0,dg1I1);
		dg1.getDispenser(0,0).addItem(3,dg1I1);
		Item dg1I2 = new Item("Hot Chettos","Chettos",.75,1.50,11,30,2021);
		dg1.addItemTypeToDispenser(0,1,dg1I2);
		dg1.getDispenser(0,1).addItem(3,dg1I2);
		Item dg1I3 = new Item("Potato Chips","Lays",.55,1.25,11,20,2021);
		dg1.addItemTypeToDispenser(1,0,dg1I3);
		dg1.getDispenser(1,0).addItem(3,dg1I3);
		for(int i= 1;i <= 10; i++) {
			dg1.addDollar_Customer();
		}
		dg1.purchaseItem_Cash(0,0);
		dg1.purchaseItem_Cash(0,0);
		dg1.purchaseItem_Card(1,0);
		dg1.purchaseItem_Cash(1,0);
		
		Item dg2I1 = new Item("Pringles","Pringles",1.00,2.50,11,18,2030);
		dg2.addItemTypeToDispenser(0,0,dg2I1);
		dg2.getDispenser(0,0).addItem(3,dg2I1);
		Item dg2I2 = new Item("Potato Chips","Lays",.50,1.50,05,30,2022);
		dg2.addItemTypeToDispenser(0,1,dg2I2);
		dg2.getDispenser(0,1).addItem(3,dg2I2);
		Item dg2I3 = new Item("Chettos","Chettos",.50,1.75,11,30,2021);
		dg2.addItemTypeToDispenser(1,0,dg2I3);
		dg2.getDispenser(1,0).addItem(3,dg2I3);
		for(int i= 1;i <= 20; i++) {
			dg2.addDollar_Customer();
		}
		dg2.purchaseItem_Cash(0,0);
		dg2.purchaseItem_Cash(0,0);
		dg2.purchaseItem_Card(0,1);
		
		Item dg3I1 = new Item("Pringles","Pringles",1.00,2.50,11,18,2030);
		dg3.addItemTypeToDispenser(0,0,dg3I1);
		dg3.getDispenser(0,0).addItem(3,dg3I1);
		Item dg3I2 = new Item("Potato Chips","Lays",.50,1.50,05,30,2022);
		dg3.addItemTypeToDispenser(0,1,dg3I2);
		dg3.getDispenser(0,1).addItem(3,dg3I2);
		Item dg3I3 = new Item("Chettos","Chettos",.50,1.75,11,30,2021);
		dg3.addItemTypeToDispenser(1,0,dg3I3);
		dg3.getDispenser(1,0).addItem(3,dg3I3);
		dg3.addDollar_Customer();
		dg3.addQuarter_Customer();
		dg3.addQuarter_Customer();
		dg3.purchaseItem_Card(0,0);
		dg3.purchaseItem_Card(0,0);
		dg3.purchaseItem_Cash(0,1);
		
		VendingMachine[] vms = {rf1,dg1,rf2,dg2,rf3,dg3};
		return new VMManager(vms);
	}
	
	public static void testMachineReport(Reports r, VMManager vmm) {
		System.out.println("---Machine Report---");
		VendingMachine vm = vmm.getVM("Valdotsa","Nevins","Coke");
		
		System.out.println("Expected:");
		System.out.println("Value of items sold: $6.00");
		System.out.println("Value of items in Vending Machine: $4.50");
		System.out.println("Value of items sold in cash: $4.00");
		System.out.println("Value of items sold in credit: $2.00");
		System.out.println("");
		
		System.out.println("Actual:");
		System.out.println(r.MachineReport(vm));
		System.out.println("");
	}
	
	public static void testProductReport(Reports r) {
		System.out.println("---Product Report---");
		Item i = new Item("Potato Chips","Lays",.50,1.50,05,30,2022);
		
		System.out.println("Expected:");
		System.out.println("Vending Machine 1: $5.00 worth of Potato Chips sold, $2.50 of Potato Chips left");
		System.out.println("Vending Machine 2: $1.50 worth of Potato Chips sold, $3.00 of Potato Chips left");
		System.out.println("Vending Machine 3: $1.50 worth of Potato Chips sold, $3.00 of Potato Chips left");
		System.out.println("Total cost sold: $8.00");
		System.out.println("Total cost left in vending machines: $8.50");
		System.out.println("");
		
		System.out.println("Actual:");
		System.out.println(r.ProductReport(i));
		System.out.println("");
	}

	public static void testDetailedMachineReport(Reports r, VMManager vmm) {
		System.out.println("---Detailed Machine Report---");
		VendingMachine vm = vmm.getVM("Valdotsa","Nevins","Coke");
		
		System.out.println("Expected:");
		System.out.println("Product 1: Sold: $2.00, Remaining: $1.00");
		System.out.println("Product 2: Sold: $1.00, Remaining: $2.00");
		System.out.println("Product 3: Sold: $3.00, Remaining: $1.50");
		System.out.println("Value of items sold: $6.00");
		System.out.println("Value of items in Vending Machine: $4.50");
		System.out.println("Value of items sold in cash: $4.00");
		System.out.println("Value of items sold in credit: $2.00");
		System.out.println("");
		
		System.out.println("Actual:");
		System.out.println(r.DetailedMachineReport(vm));
		System.out.println("");
	}

	public static void testLocationReport(Reports r) {
		System.out.println("---Location Report---");
		
		System.out.println("Expected:");
		System.out.println("Value of all items sold: $21.50");
		System.out.println("Value of all items in Vending Machines: $27.25");
		System.out.println("Value of all items sold in cash: $14.75");
		System.out.println("Value of all items sold in credit: $6.75");
		System.out.println("");
		
		System.out.println("Actual:");
		System.out.println(r.LocationReport("Valdosta"));
		System.out.println("");
	}

	public static void testCompanyReport(Reports r) {
		System.out.println("---Company Report---");
		System.out.println(r.CompanyReport());
		System.out.println("");
	}

	public static void testDryGoodsReport(Reports r) {
		System.out.println("---Dry Goods Report---");
		System.out.println(r.DryGoodsReport());
		System.out.println("");
	}

	public static void testRefrigeratedGoodsReport(Reports r) {
		System.out.println("---Refrigerated Goods Report---");
		System.out.println(r.RefrigeratedGoodsReport());
		System.out.println("");
	}

	public static void testGoodsReport(Reports r) {
		System.out.println("---Goods Report---");
		System.out.println(r.GoodsReport());
		System.out.println("");
	}

	public static void testManufacturerReport(Reports r) {
		System.out.println("---Manufacturer Report---");
		System.out.println(r.ManufacturerReport("Dr.Pepper"));
		System.out.println("");
	}

	public static void testExpiredInventoryReport(Reports r) {
		System.out.println("---Expired Inventory Report---");
		System.out.println(r.expiredInventoryReport(11,18,2021));
		System.out.println("");
	}
}
