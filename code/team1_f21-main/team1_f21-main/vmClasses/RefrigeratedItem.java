package vmClasses;
public class RefrigeratedItem extends Item {

	private double minTemp;
	private double maxTemp;
	
	//If the price is known
	public RefrigeratedItem(String name, String manufacturer, double cost, double price, int expirationMonth, int expirationDay, int expirationYear, double minTemp, double maxTemp) {
		super(name,manufacturer,cost,price,expirationMonth,expirationDay,expirationYear);
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}
		
	//If the price isn't known, price is set to $0.00
	public RefrigeratedItem(String name, String manufacturer, double cost, int expirationMonth, int expirationDay, int expirationYear, double minTemp, double maxTemp) {
		super(name,manufacturer,cost,expirationMonth,expirationDay,expirationYear);
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}
	
	//getters
	
	public double getMinTemp() {
		return minTemp;
	}
	
	public double getMaxTemp() {
		return maxTemp;
	}
	
	//setters
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
}
