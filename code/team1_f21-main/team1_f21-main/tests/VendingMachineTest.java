package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vmClasses.VendingMachine;
import vmClasses.Dispenser;
import vmClasses.Item;
class VendingMachineTest {

	@Test
	@DisplayName("testGetBuilding_Given")//building given
	void testGetBuilding_Given() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		String expected = "Student Union";
		String actual = vm.getBuilding();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetBuilding_NotGiven")//no building given
	void testGetBuilding_NotGiven() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Kellogg's");
		String expected = null;
		String actual = vm.getBuilding();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetLocation")
	void testGetLocation() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		String expected = "VSU";
		String actual = vm.getLocation();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetCompany")
	void testGetCompany() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		String expected = "Kellogg's";
		String actual = vm.getCompany();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetHeight")
	void testGetHeight() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 5;
		int actual = vm.getHeight();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetWidth")
	void testGetWidth() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 5;
		int actual = vm.getWidth();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetCapacity")
	void testGetCapactiy() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 5;
		int actual = vm.getCapacity();
		assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("testGetNumNickels_0")//no coins at start
	void testGetNumNickels_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 0;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumNickels_1_addNickel_Customer")//Added one nickel with customer
	void testGetNumNickels_1_addNickel_Customer() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickel_Customer();
		int expected = 1;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumNickels_1_addNickels_Technician")//Added one nickel with technician
	void testGetNumNickels_1_addNickels_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickels_Technician(1);
		int expected = 1;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumNickels_2_addNickels_Technician")//Added one nickel with technician
	void testGetNumNickels_2_addNickels_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickels_Technician(2);
		int expected = 2;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumDimes_0")//no coins at start
	void testGetNumDimes_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 0;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumDimes_1_addDime_Customer")//Added one dime with customer
	void testGetNumDimes_1_addDime_Customer() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDime_Customer();
		int expected = 1;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumDimes_1_addDimes_Technician")//Added one dime with technician
	void testGetNumDimes_1_addDimes_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDimes_Technician(1);
		int expected = 1;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumDimes_2_addDimes_Technician")//Added two dimes with technician
	void testGetNumDimes_2_addDimes_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDimes_Technician(2);
		int expected = 2;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumQuarters_0")//no coins at start
	void testGetNumQuarters_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 0;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumQuarters_1_addQuarter_Customer")//Added one quarter with customer
	void testGetNumQuarters_1_addQuarter_Customer() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarter_Customer();
		int expected = 1;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumQuarters_1_addQuarters_Technician")//Added one quarter with technician
	void testGetNumQuarters_1_addQuarters_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarters_Technician(1);
		int expected = 1;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumQuarters_2_addQuarters_Technician")//Added two quarters with technician
	void testGetNumQuarters_2_addQuarters_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarters_Technician(2);
		int expected = 2;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumDollars_0")//no bills at start
	void testGetNumDollars_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		int expected = 0;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumDollars_1_addDollar_Customer")//Added one dollar with customer
	void testGetNumDollars_1_addDollar_Customer() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollar_Customer();
		int expected = 1;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetNumDollars_1_addDollars_Technician")//Added one dollar with technician
	void testGetNumDollars_1_addDollars_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollars_Technician(1);
		int expected = 1;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetNumDollars_2_addDollars_Technician")//Added two dollars with technician
	void testGetNumDollars_2_addDollars_Technician() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollars_Technician(2);
		int expected = 2;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetCostSold_NoPurchase")
	void testGetCostSold_NoPurchase() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(0, vm.getCostSold());
	}
	
	@Test
	@DisplayName("testGetCostSold_OnePurchaseCash")
	void testGetCostSold_OnePurchaseCash() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		vm.purchaseItem_Cash(0, 0);
		assertEquals(2, vm.getCostSold());
	}

	@Test
	@DisplayName("testGetCostSold_OnePurchaseCard")
	void testGetCostSold_OnePurchaseCard() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		vm.purchaseItem_Card(0, 0);
		assertEquals(2, vm.getCostSold());
	}
	
	@Test
	@DisplayName("testGetCostSold_MorePurchases")
	void testGetCostSold_MorePurchases() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(2, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		vm.purchaseItem_Cash(0, 0);
		vm.purchaseItem_Card(0, 0);
		assertEquals(4, vm.getCostSold());
	}

	@Test
	@DisplayName("testGetCashSold_NoPurchase")
	void testGetCashSold_NoPurchase() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(0, vm.getCashSold());
	}

	@Test
	@DisplayName("testGetCashSold_OnePurchase")
	void testGetCashSold_OnePurchase() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		vm.purchaseItem_Cash(0, 0);
		assertEquals(2, vm.getCashSold());
	}
	
	@Test
	@DisplayName("testGetCashSold_MorePurchases")
	void testGetCashSold_MorePurchases() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(2, test);
		for(int i = 0; i < 16; i++) {
			vm.addQuarter_Customer();
		}
		vm.purchaseItem_Cash(0, 0);
		vm.purchaseItem_Cash(0, 0);
		assertEquals(4, vm.getCashSold());
	}

	@Test
	@DisplayName("testGetCreditSold_NoPurchase")
	void testGetCreditSold_NoPurchase() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(0, vm.getCreditSold());
	}
	
	@Test
	@DisplayName("testGetCreditSold_OnePurchase")
	void testGetCreditSold_OnePurchase() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(2, test);
		vm.purchaseItem_Card(0, 0);
		assertEquals(2, vm.getCreditSold());
	}
	
	@Test
	@DisplayName("testGetCreditSold_MorePurchases")
	void testGetCreditSold_MorePurchases() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(2, test);
		vm.purchaseItem_Card(0, 0);
		vm.purchaseItem_Card(0, 0);
		assertEquals(4, vm.getCreditSold());
	}

	@Test
	@DisplayName("testHasTemp")
	void testHasTemp() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.hasTemp());
	}
	
	@Test
	@DisplayName("testGetItemsSold_WithPurchase")
	void testGetItemsSold_WithPurchase() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(2, test);
		vm.purchaseItem_Card(0, 0);
		assertEquals(vm.itemsSold, vm.getItemsSold());
	}
	
	@Test
	@DisplayName("testGetItemsSold_WithoutPurchase")
	void testGetItemsSold_WithoutPurchase() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		assertEquals(vm.itemsSold, vm.getItemsSold());
	}

	@Test
	@DisplayName("testGetItem_True")
	void testGetItem_True() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(test, vm.getItem("Pringles"));
	}

	@Test
	@DisplayName("testGetItem_False")
	void testGetItem_False() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(null, vm.getItem("Prongles"));
	}

	@Test
	@DisplayName("testRemoveItem_True")
	void testRemoveItem_True() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(true, vm.removeItem("Pringles"));
	}
	
	@Test
	@DisplayName("testRemoveItem_False")
	void testRemoveItem_False() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(false, vm.removeItem("Prongles"));
	}
	
	@Test
	@DisplayName("testGetDispenser")
	void testGetDispenser() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Dispenser expected = vm.getDispensers()[0][0];
		Dispenser actual = vm.getDispenser(0, 0);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetDispensers")
	void testGetDispensers() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		assertEquals(vm.getDispensers(), vm.getDispensers());
	}

	@Test
	@DisplayName("testAddItemTypeToDispenser")
	void testAddItemTypeToDispenser() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		assertEquals(true, vm.addItemTypeToDispenser(0, 0, test));	
	}

	@Test
	@DisplayName("testPurchaseItem_Card")
	void testPurchaseItem_Card() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(true, vm.purchaseItem_Card(0, 0));
	}

	@Test
	@DisplayName("testIsPurchasable_Card_True")
	void testIsPurchasable_Card_True() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(true, vm.isPurchasable_Card(0, 0));
	}
	
	@Test
	@DisplayName("testIsPurchasable_Card_False")
	void testIsPurchasable_Card_False() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		assertEquals(false, vm.isPurchasable_Card(0, 0));
	}
	
	@Test
	@DisplayName("testPurchaseItem_Cash_Enough")
	void testPurchaseItem_Cash_Enough() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(true, vm.purchaseItem_Cash(0, 0));
	}

	@Test
	@DisplayName("testPurchaseItem_Cash_NotEnough")
	void testPurchaseItem_Cash_NotEnough() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 7; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(false, vm.purchaseItem_Cash(0, 0));
	}

	@Test
	@DisplayName("testIsPurchasable_Cash_HasItems_EnoughFunds")
	void testIsPurchasable_Cash_HasItems_EnoughFunds() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(true, vm.isPurchasable_Cash(0, 0));
	}
	
	@Test
	@DisplayName("testIsPurchasable_Cash_HasItems_NotEnoughFunds")
	void testIsPurchasable_Cash_HasItems_NotEnoughFunds() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 7; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(false, vm.isPurchasable_Cash(0, 0));
	}
	
	@Test
	@DisplayName("testIsPurchasable_Cash_NoItems_EnoughFunds")
	void testIsPurchasable_Cash_NoItems_EnoughFunds() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(false, vm.isPurchasable_Cash(0, 0));
	}
	
	@Test
	@DisplayName("testIsPurchasable_Cash_NoItems_NotEnoughFunds")
	void testIsPurchasable_Cash_NoItems_NotEnoughFunds() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		for(int i = 0; i < 7; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(false, vm.isPurchasable_Cash(0, 0));
	}
	
	@Test
	@DisplayName("testGetItemTypeFromArray")
	void testGetItemTypeFromArray() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals("Pringles", vm.getItemTypeFromArray(0, 0));
	}

	@Test
	@DisplayName("testGetItemFromArray")
	void testGetItemFromArray() {
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(test, vm.getItemFromArray(0, 0));
	}

	@Test
	@DisplayName("testDispenserExists_True")
	void testDispenserExists_True(){
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		assertEquals(true, vm.dispenserExists(0, 0));
	}
	
	@Test
	@DisplayName("testDispenserExists_False")
	void testDispenserExists_False(){
		VendingMachine vm = new VendingMachine(1, 1, 2, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.dispenserExists(0, 0));
	}
	
	@Test
	@DisplayName("testGetItemInventoryCostFound")
	void testGetItemInventoryCostFound() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(2, vm.getItemInventoryCost(test));
	}

	@Test
	@DisplayName("testGetItemInventoryCostNotFound")
	void testGetItemInventoryCostNotFound() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		Item test2 = constructTestItem2();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		assertEquals(0, vm.getItemInventoryCost(test2));
	}
	
	@Test
	@DisplayName("testEditLocation")
	void testEditLocation() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		vm.editLocation("FSU");
		String expected = "FSU";
		assertEquals(expected, vm.getLocation());
	}
	
	@Test
	@DisplayName("testEditBuilding")
	void testEditBuilding() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		vm.editBuilding("Nevins Hall");
		String expected = "Nevins Hall";
		assertEquals(expected, vm.getBuilding());
	}
	
	@Test
	@DisplayName("testEditCompany")
	void testEditCompany() {
		VendingMachine vm = new VendingMachine(1, 1, 1, "VSU", "Student Union", "Kellogg's");
		vm.editCompany("PepsiCo");
		String expected = "PepsiCo";
		assertEquals(expected, vm.getCompany());
	}
	
	@Test
	@DisplayName("testRemoveNickels_Technician_3_to_0")
	void testRemoveNickels_Technician_3_to_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickels_Technician(3);
		vm.removeNickels_Technician(3);
		int expected = 0;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveNickels_Technician_3_to_1")
	void testRemoveNickels_Technician_3_to_1() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickels_Technician(3);
		vm.removeNickels_Technician(2);
		int expected = 1;
		int actual = vm.getNumNickels();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveNickels_Technician_5_from_3")
	void testRemoveNickels_Technician_5_from_3() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addNickels_Technician(3);
		assertEquals(false, vm.removeNickels_Technician(5));
	}
	
	@Test
	@DisplayName("testRemoveNickels_Technician_0")
	void testRemoveNickels_Technician_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.removeNickels_Technician(3));
	}
	
	@Test
	@DisplayName("testRemoveDimes_Technician_3_to_0")
	void testRemoveDimes_Technician_3_to_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDimes_Technician(3);
		vm.removeDimes_Technician(3);
		int expected = 0;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveDimes_Technician_3_to_1")
	void testRemoveDimes_Technician_3_to_1() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDimes_Technician(3);
		vm.removeDimes_Technician(2);
		int expected = 1;
		int actual = vm.getNumDimes();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveDimes_Technician_5_from_3")
	void testRemoveDimes_Technician_5_from_3() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDimes_Technician(3);
		assertEquals(false, vm.removeDimes_Technician(5));
	}
	
	@Test
	@DisplayName("testRemoveDimes_Technician_0")
	void testRemoveDimes_Technician_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.removeDimes_Technician(3));
	}
	
	@Test
	@DisplayName("testRemoveQuarters_Technician_3_to_0")
	void testRemoveQuarters_Technician_3_to_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarters_Technician(3);
		vm.removeQuarters_Technician(3);
		int expected = 0;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveQuarters_Technician_3_to_1")
	void testRemoveQuarters_Technician_3_to_1() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarters_Technician(3);
		vm.removeQuarters_Technician(2);
		int expected = 1;
		int actual = vm.getNumQuarters();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveQuarters_Technician_5_from_3")
	void testRemoveQuarters_Technician_5_from_3() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addQuarters_Technician(3);
		assertEquals(false, vm.removeQuarters_Technician(5));
	}
	
	@Test
	@DisplayName("testRemoveQuarters_Technician_0")
	void testRemoveQuarters_Technician_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.removeQuarters_Technician(3));
	}

	@Test
	@DisplayName("testRemoveDollars_Technician_3_to_0")
	void testRemoveDollars_Technician_3_to_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollars_Technician(3);
		vm.removeDollars_Technician(3);
		int expected = 0;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveDollars_Technician_3_to_1")
	void testRemoveDollars_Technician_3_to_1() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollars_Technician(3);
		vm.removeDollars_Technician(2);
		int expected = 1;
		int actual = vm.getNumDollars();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveDollars_Technician_5_from_3")
	void testRemoveDollars_Technician_5_from_3() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		vm.addDollars_Technician(3);
		assertEquals(false, vm.removeDollars_Technician(5));
	}
	
	@Test
	@DisplayName("testRemoveDollars_Technician_0")
	void testRemoveDollars_Technician_0() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		assertEquals(false, vm.removeDollars_Technician(3));
	}

	@Test
	@DisplayName("testAffordableWithCurrentBal_True")
	void testAffordableWithCurrentBal_True() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(true, vm.affordableWithCurrentBal(0, 0));
	}
	
	@Test
	@DisplayName("testAffordableWithCurrentBal_False")
	void testAffordableWithCurrentBal_False() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 7; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(false, vm.affordableWithCurrentBal(0, 0));
	}

	@Test
	@DisplayName("testEnoughChange_TrueMore")
	void testEnoughChange_TrueMore() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 9; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(true, vm.enoughChange(0, 0));
	}
	
	@Test
	@DisplayName("testEnoughChange_TrueExact")
	void testEnoughChange_TrueExact() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 8; i++) {
			vm.addQuarter_Customer();
		}
		assertEquals(true, vm.enoughChange(0, 0));
	}

	@Test
	@DisplayName("testEnoughChange_False")
	void testEnoughChange_False() {
		VendingMachine vm = new VendingMachine(5, 5, 5, "VSU", "Student Union", "Kellogg's");
		Item test = constructTestItem();
		vm.addItemTypeToDispenser(0, 0, test);
		vm.getDispenser(0, 0).addItem(1, test);
		for(int i = 0; i < 5; i++) {
			vm.addQuarter_Customer();
			//1.25
		}
		for(int i = 0; i < 8; i++) {
			vm.addDime_Customer();
			//2.05
		}
		assertEquals(false, vm.enoughChange(0, 0));
	}
	
	//helper method(s)
	
	Item constructTestItem() {
		return new Item("Pringles", "Kellogg's", 1.00, 2.00, 11, 26, 2022);
	}
	
	Item constructTestItem2() {
		return new Item("Cookies", "House", 0.50, 1.00, 11, 26, 2023);
	}
	
}

