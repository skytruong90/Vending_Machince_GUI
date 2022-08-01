package vmClasses;

import java.util.ArrayList;

public class VendingMachine {
	
	final double nickelValue = .05;
	final double dimeValue = .10;
	final double quarterValue = .25;
	final double dollarValue = 1.00;
	
	int capacity;
	Dispenser[][] dispensers;
	int numNickels = 0;
	int numDimes = 0;
	int numQuarters = 0;
	int numDollars = 0;
	int height, width;
	double customerBal = 0;
	double costSold = 0.0;
	double creditSold = 0.0;
	double cashSold = 0.0;
	public ArrayList<Item> itemsSold = new ArrayList<>();
	
	String company, location, building; //location is address, building is area within location
	
	public VendingMachine (int height, int width, int capacity, String location, String building, String company) {
		dispensers = new Dispenser[height][width];
		this.capacity = capacity;
		this.location = location;
		this.building = building;
		this.company = company;
		this.height = height;
		this.width = width;
	}
	
	public VendingMachine (int height, int width, int capacity, String location, String company) {
		dispensers = new Dispenser[height][width];
		this.capacity = capacity;
		this.building = null;
		this.location = location;
		this.company = company;
		this.height = height;
		this.width = width;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getNumNickels() {
		return numNickels;
	}
	
	public int getNumDimes() {
		return numDimes;
	}
	
	public int getNumQuarters() {
		return numQuarters;
	}
	
	public int getNumDollars() {
		return numDollars;
	}
	
	public double getCostSold() {
		return costSold;
	}
	
	public double getCashSold() {
		return cashSold;
	}
	
	public double getCreditSold() {
		return creditSold;
	}
	
	public boolean hasTemp() {
		return false;
	}
	
	public ArrayList<Item> getItemsSold() {
		return itemsSold;
	}
	
	public Item getItem(String name) {
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				Dispenser d = dispensers[h][w];
				Item i = d.getItem();
				if(i.getName().equals(name)) {
					return i;
				}
			}
		}
		return null;
	}
	
	public boolean removeItem(String name){
		boolean removeFlag = false;
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				Dispenser d = dispensers[h][w];
				ArrayList<Item>items = d.getAllItems();
				for(int i = 0; i < items.size(); i++){
					Item item = items.get(i);
					if(item.getName().equals(name)) {
						d.removeItem(w);
						removeFlag = true;
					}
				}
			}
		}
		return removeFlag;
	}
	
	public Dispenser getDispenser(int height,int width) {
		return dispensers[height][width];
	}
	
	public Dispenser[][] getDispensers(){
		return dispensers;
	}
	
	public boolean addItemTypeToDispenser(int height, int width, Item item) 
	{
		if(!dispenserExists(height, width)) 
		{
			dispensers[height][width] = new Dispenser(item, capacity);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean purchaseItem_Card(int height, int width) {
		if(isPurchasable_Card(height, width)) {
			costSold += dispensers[height][width].getItem().getPrice();
			creditSold += dispensers[height][width].getItem().getPrice();
			itemsSold.add(dispensers[height][width].getItem());
			dispensers[height][width].dispenseItem();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPurchasable_Card(int height, int width) {
		if(dispenserExists(height, width) && dispensers[height][width].hasItems()) {
			return true;
		}
		return false;
	}
	
	public boolean purchaseItem_Cash(int height, int width) {
		if(isPurchasable_Cash(height, width)) {
			costSold += dispensers[height][width].getItem().getPrice();
			cashSold += dispensers[height][width].getItem().getPrice();
			itemsSold.add(dispensers[height][width].getItem());
			giveChange(height, width);
			dispensers[height][width].dispenseItem();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPurchasable_Cash(int height, int width) {
		if(dispenserExists(height, width) && dispensers[height][width].hasItems()) {
			if(affordableWithCurrentBal(height, width) && enoughChange(height, width)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public String getItemTypeFromArray(int height, int width) {
		if(dispenserExists(height, width)) {
			String name = dispensers[height][width].getItemType();
			return name;
		}
		else {
			return null;
		}
	}
	
	public Item getItemFromArray(int height, int width) {
		if(dispenserExists(height, width)) {
			Item item = dispensers[height][width].getItem();
			return item;
		}
		else {
			return null;
		}
	}
	
	public boolean dispenserExists(int height, int width) {
		if(dispensers[height][width] != null) {
			return true;
		}
		return false;
	}
	
	public double getItemInventoryCost(Item item) {
		double price = 0;
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				Dispenser d = getDispenser(h,w);
				if(dispenserExists(h,w)) {
					if(d.getItem().getName().equals(item.getName())) {
						price += d.getQuantity() * d.getItem().getPrice();
					}
				}
			}
		}
		return price;
	}
	
	public void editLocation(String s) {
		this.location = s;
	}
	
	public void editBuilding(String s) {
		this.building = s;
	}

	public void editCompany(String s) {
		this.company = s;
	}
	
	//The addSomething_Customer() methods are for customers adding payment for non-card purchases  
	public void addNickel_Customer() {
		numNickels++;
		customerBal += nickelValue;
		return;
	}
	
	public void addDime_Customer() {
		numDimes++;
		customerBal += dimeValue;
		return;
	}
	
	public void addQuarter_Customer() {
		numQuarters++;
		customerBal += quarterValue;
		return;
	}
	
	public void addDollar_Customer() {
		numDollars++;
		customerBal += dollarValue;
		return;
	}
	
	//addSomething_Technician() methods are for the Technician adding change to the machine for proper change return
	
	public void addNickels_Technician(int num) {
		numNickels += num;
	}
	
	public void addDimes_Technician(int num) {
		numDimes += num;
	}
	
	public void addQuarters_Technician(int num) {
		numQuarters += num;
	}
	
	public void addDollars_Technician(int num) {
		numDollars += num;
	}
	
	//removeSomething_Technician() methods are for the Technician to remove the requested change
	
	public boolean removeNickels_Technician(int num) {
		if(num<=numNickels) {
			numNickels -= num;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeDimes_Technician(int num) {
		if(num<=numDimes) {
			numDimes -= num;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeQuarters_Technician(int num) {
		if(num<=numQuarters) {
			numQuarters -= num;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeDollars_Technician(int num) {
		if(num<=numDollars) {
			numDollars -= num;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean affordableWithCurrentBal(int height, int width) {
		if(getItemFromArray(height, width).getPrice() <= customerBal) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean enoughChange(int height, int width) {//checks for affordability first (meaning changeNeeded should never be below 0)
		double changeNeeded = customerBal - getItemFromArray(height, width).getPrice();
		if(changeNeeded == 0 ) {//exact change paid
			return true;
		}
		else {
			double holder = changeNeeded;
         
			int dollars = (int)(holder / dollarValue);
			if(dollars > numDollars) {
				dollars = numDollars;
			}
			holder -= (dollars * dollarValue);
         
			int quarters = (int)(holder / quarterValue);
			if(dollars > numQuarters) {
				dollars = numQuarters;
			}
			holder -= (quarters * quarterValue);
			
			int dimes = (int)(holder / dimeValue);
			if(dimes > numDimes) {
				dimes = numDimes;
			}
			holder -= (dimes * dimeValue);
			
            int nickels = (int)(holder / nickelValue);
			if(nickels > numNickels) {
				nickels = numNickels;
			}
			holder -= (nickels * nickelValue);
			
			holder = Math.round(holder*100.0)/100.0;
            if(holder > 0) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	public void giveChange(int height, int width) {
		double changeNeeded = customerBal - getItemFromArray(height, width).getPrice();
		if(changeNeeded == 0 ) {//exact change paid
			return;
		}
		else {
			double holder = changeNeeded;
         
			int dollars = (int)(holder / dollarValue);
			if(dollars > numDollars) {
				dollars = numDollars;
			}
			numDollars -= dollars;
			holder -= (dollars * dollarValue);
         
			int quarters = (int)(holder / quarterValue);
			if(quarters > numQuarters) {
				quarters = numQuarters;
			}
			numQuarters -= quarters;
			holder -= (quarters * quarterValue);
			
			int dimes = (int)(holder / dimeValue);
			if(dimes > numDimes) {
				dimes = numDimes;
			}
			numDimes -= dimes; 
			holder -= (dimes * dimeValue);
			
            int nickels = (int)(holder / nickelValue);
			if(nickels > numNickels) {
				nickels = numNickels;
			}
			numNickels -= nickels;
			holder -= (nickels * nickelValue);
		}
	}
	
	public int[] startingCoinsInMachine() {
		//These are the amounts of each coin/dollar that each vending machine should have
		int [] coins = new int[4];
		coins[0] = 40;
		coins[1] = 30;
		coins[2]= 20;
		coins[3] = 25;
		return coins;
	}
}
