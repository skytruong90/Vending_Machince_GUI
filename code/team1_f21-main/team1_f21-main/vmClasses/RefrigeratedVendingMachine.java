package vmClasses;

public class RefrigeratedVendingMachine extends VendingMachine{
	private double temp;
	
	public RefrigeratedVendingMachine (int height, int width, int capacity, String location, String building, String company, double temp) {
		super(height,width,capacity,location,building,company);
		this.temp = temp;
	}
	
	public RefrigeratedVendingMachine (int height, int width, int capacity, String location, String company, double temp) {
		super(height,width,capacity,location,company);
		this.temp = temp;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public boolean hasTemp() {
		return true;
	}
	
	public void setTemp(double minTemp) {
		if(minTemp < temp) {
			temp = minTemp;
		}
	}
	
	public boolean addItemTypeToDispenser(int height, int width, Item item) 
	{
		if((dispensers[height][width] == null)&&(item instanceof RefrigeratedItem)) 
		{
			dispensers[height][width] = new Dispenser(item, capacity);
			RefrigeratedItem r = (RefrigeratedItem)item;
			setTemp(r.getMinTemp());
			return true;
		}
		else
		{
			return false;
		}
	}
}
