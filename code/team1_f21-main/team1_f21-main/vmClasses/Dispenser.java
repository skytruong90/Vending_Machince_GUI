package vmClasses;
import java.util.ArrayList;

public class Dispenser extends Object{
	
	public ArrayList<Item> items = new ArrayList<>();
	int max;
	String itemType;
	Item item;
	
	public Dispenser (Item item, int quantity ,int max) {//quantity is current amount, max is maxAmount
		this.max = max;
		this.itemType = item.getName();
		this.item = item;
		for(int i=0; i < quantity; i++) {
			items.add(item);
		}
	}
	
	public Dispenser (Item item, int max) {// max is maxAmount
		this.max = max;
		this.itemType = item.getName();
		this.item = item;
	}
	
	public int getQuantity() {
		return items.size();
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public Item getItem() {
		return item;
	}
	
	public RefrigeratedItem getRefrigeratedItem() {
		if(!(items.isEmpty())&& item instanceof RefrigeratedItem){
			return (RefrigeratedItem)item;
		}
		return null;
	}
	
	public ArrayList<Item> getAllItems(){
		return items;
	}
	
	public void replaceItems(ArrayList<Item> replace) {
		items.clear();
		items.addAll(replace);
	}
	
	public int getMax() {
		return max;
	}
	
	
	public Item dispenseItem() {
		if(!(items.isEmpty())){
			return items.remove(0);
		}
		else{
			return null;
		}
	}
	
	public boolean addItem(int quantity, Item item) {
		if(isFull(quantity)) {
			return false;
		}
		else {
			for(int i = 0; i <quantity; i++) {
				items.add(item);
			}
			return true;
		}
	}
	
	public boolean isFull(int quantity) {
		if(quantity + getQuantity() > max) {
			return true;
		}
		return false;
	}
	
	public boolean removeItem(int index) {
		if (!(items.isEmpty())){
			items.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean hasItems() {
		if(getQuantity() > 0) {
			return true;
		}
		return false;
	}
}

