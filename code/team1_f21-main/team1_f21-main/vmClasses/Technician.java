package vmClasses;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
public class Technician {
/*
 * Methods to do:
 * expiredReport(VendingMachine vm)
 * 
 */
	public Technician() {}
	
	public ArrayList <Item> expiredItems = new ArrayList <Item>();
	
	//Have to know what vending machine and from what location to restock
	public void restockItem(VendingMachine vm, int height, int width) {
		//If the Quantity currently in the machine is < the Max amount it can have
		//Get the Item, how many to restock it till its full, then add it to the dispenser
		Item item = new Item(vm.getDispenser(height, width).getItemType(), vm.getDispenser(height, width).getItem().getManufacturer(), vm.getDispenser(height, width).getItem().getCost(), vm.getDispenser(height, width).getItem().getPrice(), vm.getDispenser(height, width).getItem().getExpiredMonth(), vm.getDispenser(height, width).getItem().getExpiredDay(), vm.getDispenser(height, width).getItem().getExpiredYear());
		if (vm.getDispenser(height, width).getQuantity() < vm.getDispenser(height, width).getMax()) {
			String [] newExpirationDate = getNewExpirationDate();
			int newExpirationDay = Integer.parseInt(newExpirationDate[2]);
			int newExpirationMonth = Integer.parseInt(newExpirationDate[1]);
			int newExpirationYear = Integer.parseInt(newExpirationDate[0]);
			item.setExpirationDate(newExpirationMonth, newExpirationDay, newExpirationYear);
			int toBeRestocked = (vm.getDispenser(height, width).getMax() - vm.getDispenser(height, width).getQuantity());
			vm.getDispenser(height, width).addItem(toBeRestocked, item);
			//Change this message to reflect a successful add in the GUI
			System.out.println("Restock of Item: " + item.getName() + ", Successful. Added: " + toBeRestocked);
		}
		else {
			System.out.println("Restock was not needed.");
		}
		sortItems(vm, height, width);
	}
	
	public void removeExpired(VendingMachine vm, int height, int width) {
		//Get the ArrayList containing the items in that Dispenser
		ArrayList<Item> currentDispenser = vm.getDispenser(height, width).getAllItems();
		int currentYear = getYear();
		int currentMonth = getMonth();
		int currentDay = getDay();
		//Loop through the Items, and see which is Expired, then remove;
		//Add it to another data structure for Expired Report
		for (int i = 0; i < vm.getDispenser(height, width).getMax()-1; i++) {
			Item item = currentDispenser.get(i); 
			if (item.getExpiredYear() - currentYear <= 0) {
				if (item.getExpiredMonth() - currentMonth <= 0) {
					if (item.getExpiredDay() - currentDay <= 0) {
						//Add to structure for expired report
						expiredItems.add(item);
						vm.getDispenser(height, width).removeItem(i);
						//Add GUI output for print statement
						System.out.println(vm.getDispenser(height, width).getItemType() + " has been successfully removed. <Reason>: Expired.");
					}
				}
			}
		}
	}
	
	//Method that uses the Calendar class to add 7 days to the current date,
	//splits the date to a string array,
	//and then returns it to be set to the new item added in Restock method
	public String[] getNewExpirationDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		long millis = System.currentTimeMillis();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(millis)); // Current Date
		c.add(Calendar.DATE, 14); // Adding 2 weeks from current day for new expiration date
		String date = sdf.format(c.getTime());
		String todayDate = date.toString();
		String [] today = new String[3];
		today = todayDate.split("/");
		
		return today;
	}
	
	public void sortItems(VendingMachine vm, int height, int width) {
		ArrayList<Item> sortItemArray = vm.getDispenser(height, width).getAllItems();
		ArrayList<Date> itemDates = new ArrayList<Date>();
		ArrayList<Item> sortedItems = new ArrayList<Item>();
		//Loop through and save the dates into an array to be sorted
		for (int i = 0; i < sortItemArray.size()-1; i++) {
			//Because the Expiration Date of each item is saved as three integer numbers (yeah I know), I
			//have to "rejoin" these numbers to represent dates that I can then use to sort.
			//A HUGE run-around 
			String day = String.valueOf(sortItemArray.get(i).getExpiredDay());
			if (sortItemArray.get(i).getExpiredDay() < 10) {
				day = "0" + sortItemArray.get(i).getExpiredDay();
			}
			String itemTime = "00:00:00";
			String itemExpireDate = sortItemArray.get(i).getExpiredYear() + "-" + sortItemArray.get(i).getExpiredMonth() + "-" + day;
			LocalDate startingDate = LocalDate.parse(itemExpireDate);
			LocalTime startingTime = LocalTime.parse(itemTime);
			LocalDateTime dt = LocalDateTime.of(startingDate, startingTime);
			Date expirationDateinDateFormat = Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());
			itemDates.add(expirationDateinDateFormat);
		}
		Collections.sort(itemDates);
		
		for (int i = 0; i < sortItemArray.size()-1; i++) {
			//Grab the Expiration date as a date from sortItemArray, then loop through and 
			//compare that date and the already sorted array of dates
			//Add them to the sorted items arraylist if equal, they should be sorted by ascending
			//expiration date
			String day = String.valueOf(sortItemArray.get(i).getExpiredDay());
			if (sortItemArray.get(i).getExpiredDay() < 10) {
				day = "0" + sortItemArray.get(i).getExpiredDay();
			}
			String itemTime = "00:00:00";
			String itemExpireDate = sortItemArray.get(i).getExpiredYear() + "-" + sortItemArray.get(i).getExpiredMonth() + "-" + day;
			LocalDate startingDate = LocalDate.parse(itemExpireDate);
			LocalTime startingTime = LocalTime.parse(itemTime);
			LocalDateTime dt = LocalDateTime.of(startingDate, startingTime);
			Date expirationDateinDateFormat = Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());
			for (int j = 0; j < sortItemArray.size()-1; j++) {
				if (itemDates.get(i) == expirationDateinDateFormat) {
					Item item = sortItemArray.get(i);
					sortedItems.add(item);
				}
			}
		}
		vm.getDispenser(height, width).replaceItems(sortedItems);
	}
	
	public void restockCoins(VendingMachine vm) {
		//Method that will restock the coins/dollars in the Vending Machine
		//Current change in Vending Machine
		int currentNickels = vm.getNumNickels();
		int currentDimes = vm.getNumDimes();
		int currentQuarters = vm.getNumQuarters();
		int currentDollars = vm.getNumDollars();
		int [] defaultCoins = vm.startingCoinsInMachine();
		if (defaultCoins[0] - currentNickels > 0) {
			vm.addNickels_Technician(defaultCoins[0]-currentNickels);
		}
		if(defaultCoins[1] - currentDimes > 0) {
			vm.addDimes_Technician(defaultCoins[1]-currentDimes);
		}
		if(defaultCoins[2] - currentQuarters > 0) {
			vm.addQuarters_Technician(defaultCoins[2]-currentQuarters);
		}
		if(defaultCoins[3] - currentDollars > 0) {
			vm.addDollars_Technician(defaultCoins[3]-currentDollars);
		}
	}
	
	//Helper methods to shorten main methods in Technician. Getting Current Month/Day/Year
	public int getMonth() {
		long millis = System.currentTimeMillis();  
		Date date = new Date(millis);
		String todayDate = date.toString();
		String [] today = new String[3];
		today = todayDate.split("/");
		int currentMonth = Integer.parseInt(today[1]);
		
		return currentMonth;
	}
	
	public int getDay() {
		long millis = System.currentTimeMillis();  
		Date date = new Date(millis);
		String todayDate = date.toString();
		String [] today = new String[3];
		today = todayDate.split("/");
		int currentDay = Integer.parseInt(today[2]);
		
		return currentDay;
	}
	
	public int getYear() {
		long millis = System.currentTimeMillis();  
		Date date = new Date(millis);
		String todayDate = date.toString();
		String [] today = new String[3];
		today = todayDate.split("/");
		int currentYear = Integer.parseInt(today[0]);
		
		return currentYear;
	}
}
