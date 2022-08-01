package vmClasses;
public class Item {
	private String name,manufacturer;
	//Cost = how much it costs the manager, Price = how much the manager wants to sell it for
	private double cost,price;
	private int expirationMonth, expirationDay, expirationYear;
	
	//If the price is known
	public Item(String name, String manufacturer, double cost, double price, int expirationMonth, int expirationDay, int expirationYear) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.cost = cost;
		this.price = price;
		//Set expiration date as "mm/dd/yyyy"
		this.expirationMonth = expirationMonth;
		this.expirationDay = expirationDay;
		this.expirationYear = expirationYear;
	}
	
	//If the price isn't known, price is set to $0.00
	public Item(String name, String manufacturer, double cost, int expirationMonth, int expirationDay, int expirationYear) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.cost = cost;
		this.price = 0.00;
		//Set expiration date as "mm/dd/yyyy"
		this.expirationMonth = expirationMonth;
		this.expirationDay = expirationDay;
		this.expirationYear = expirationYear;
	}
		
	//Getters
	public String getName() {
		return name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getExpiredMonth() {
		return expirationMonth;
	}
	
	public int getExpiredDay() {
		return expirationDay;
	}
	
	public int getExpiredYear() {
		return expirationYear;
	}
	
	//Setters (to change aspects of the item after creation)
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Setter for Technician when restocking
	public void setExpirationDate(int month, int day, int year) {
		this.expirationMonth = month;
		this.expirationDay = day;
		this.expirationYear = year;
	}
	
	public boolean isExpired(int curMonth,int curDay,int curYear) {
		if(curYear > expirationYear) {
			return true;
		}
		else if(curYear == expirationYear) {
			if(curMonth > expirationMonth) {
				return true;
			}
			else if(curMonth == expirationMonth){
				if(curDay >= expirationDay) {
					return true;
				}
			}
		}
		return false;
	}
}
