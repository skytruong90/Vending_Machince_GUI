package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vmClasses.Dispenser;
import vmClasses.Item;
import vmClasses.RefrigeratedItem;

class DispenserTest {

	@Test
	@DisplayName("testGetQuantity_0")//empty
	void testGetQuantity_0() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 0, 5);
		int actual = dispenser.getQuantity();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetQuantity_1")//quantity 1
	void testGetQuantity_1() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		int actual = dispenser.getQuantity();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetItemType")
	void testGetItemType() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		String expected = "Pringles";
		String actual = dispenser.getItemType();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetItem_0")
	void testGetItem_0() {
		Item item = constructTestItem();
		Dispenser dispenser = new Dispenser(item, 0, 5);
		Item expected = item;
		Item actual = dispenser.getItem();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetItem_1")
	void testGetItem_1() {
		Item test = constructTestItem();
		Dispenser dispenser = new Dispenser(test, 1, 5);
		Item expected = test;
		Item actual = dispenser.getItem();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testGetRefrigeratedItem_0")
	void testGetRefrigeratedItem_0() {
		Dispenser dispenser = new Dispenser(constructTestRefrigeratedItem(), 0, 5);
		Item expected = null;
		RefrigeratedItem actual = dispenser.getRefrigeratedItem();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetRefrigeratedItem_1")
	void testGetRefrigeratedItem_1() {
		RefrigeratedItem test = constructTestRefrigeratedItem();
		Dispenser dispenser = new Dispenser(test, 1, 5);
		RefrigeratedItem expected = test;
		RefrigeratedItem actual = dispenser.getRefrigeratedItem();
		assertEquals(expected, actual);
	}	
	
	@Test
	@DisplayName("testGetAllItems_1")
	void testGetAllItems_1() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		assertEquals(dispenser.items, dispenser.getAllItems());
	}
	
	@Test
	@DisplayName("testGetAllItems_2")
	void testGetAllItems_2() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 2, 5);
		assertEquals(dispenser.items, dispenser.getAllItems());
	}
	
	@Test
	@DisplayName("testReplaceItems")
	void testReplactItems() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 2, 5);
		ArrayList<Item> replace = new ArrayList<>();
		replace.add(constructTestItem2());
		dispenser.replaceItems(replace);
		assertEquals(replace, dispenser.getAllItems());
	}
	
	@Test
	@DisplayName("testGetMax_0")//max 0 (dispenser cannot hold any items)
	void testGetMax_0() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 0, 0);
		int expected = 0;
		int actual = dispenser.getMax();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testGetMax_5")
	void testGetMax_5() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		int expected = 5;
		int actual = dispenser.getMax();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testDispenseItem_1")
	void testDispenseItem_1() {
		Item test = constructTestItem();
		Dispenser dispenser = new Dispenser(test, 1, 5);
		Item expected = test;
		Item actual = dispenser.dispenseItem();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testDispenseItem_0")//quantity 0
	void testDispenseItem_0() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 0, 5);
		Item expected = null;
		Item actual = dispenser.dispenseItem();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testAddItem_Same_Under")//same item, under max
	void testAddItem_Same_Under() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		boolean expected = true;
		boolean actual = dispenser.addItem(1, constructTestItem());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testAddItem_Same_Over")//same item, over max
	void testAddItem_Same_Over() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 5, 5);
		boolean expected = false;
		boolean actual = dispenser.addItem(1, constructTestItem());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testAddItem_Diff_Under")//different item, under max
	void testAddItem_Diff_Under() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		boolean expected = true;
		boolean actual = dispenser.addItem(1, constructTestItem2());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testAddItem_Diff_Over")//different item, over max
	void testAddItem_Diff_Over() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 5, 5);
		boolean expected = false;
		boolean actual = dispenser.addItem(1, constructTestItem2());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("testIsFull_True")//different item, over max
	void testIsFull_True() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 5, 5);
		boolean expected = true;
		boolean actual = dispenser.isFull(1);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testIsFull_False")//different item, over max
	void testIsFull_False() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 4, 5);
		boolean expected = false;
		boolean actual = dispenser.isFull(1);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveItem_0")//quantity 0
	void testRemoveItem_0() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 0, 5);
		boolean expected = false;
		boolean actual = dispenser.removeItem(0);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testRemoveItem_1")//quantity 1
	void testRemoveItem_1() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		boolean expected = true;
		boolean actual = dispenser.removeItem(0);
		assertEquals(expected, actual);
	}
	
	//test hasItems()
	
	@Test
	@DisplayName("testHasItems_True")
	void testHasItems_True() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 1, 5);
		boolean expected = true;
		boolean actual = dispenser.hasItems();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("testHasItems_False")
	void testHasItems_False() {
		Dispenser dispenser = new Dispenser(constructTestItem(), 0, 5);
		boolean expected = false;
		boolean actual = dispenser.hasItems();
		assertEquals(expected, actual);
	}
	
	//helper method(s)
	
	Item constructTestItem() {
		return new Item("Pringles", "Kellogg's", 1.00, 2.00, 11, 26, 2022);
	}
	
	Item constructTestItem2() {
		return new Item("Cookies", "House", 0.50, 1.00, 11, 26, 2023);
	}

	RefrigeratedItem constructTestRefrigeratedItem() {
		return new RefrigeratedItem("Coke","Coca-cola",.50,1.00,11,17,2021,45.0,50.0);
	}
	
}
