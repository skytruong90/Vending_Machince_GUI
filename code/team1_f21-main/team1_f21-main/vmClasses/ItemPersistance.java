package vmClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemPersistance 
{
	VMManager vm;
	
	public ItemPersistance(VMManager vm) 
	{
		this.vm = vm;
	}
	
	public ItemPersistance() {}
	
	public ArrayList<Item> readItems() 
	{
		String file = ("../ItemList.txt");
		File infile = new File(file);
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			Scanner input = new Scanner(infile);
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] array = new String[5];
				array = line.split(",\\s+");
				double cost = Double.parseDouble(array[2]);
				double price = Double.parseDouble(array[3]);
				String [] date = new String[3];
				date = array[4].split("/");
				int month = Integer.parseInt(date[0]); 
				int day = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);
				Item a = new Item(array[0], array[1], cost, price, month, day, year);
				
				//add structure that would store all the items to be sorted into different vending machines
				list.add(a);
			}
			input.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		return list;
	}
	
	public void saveItems()
	{
		try 
		{
			FileWriter fw = new FileWriter("../ItemList.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(VendingMachine v : vm.vms)
			{
				ArrayList<Item> items;
				Dispenser[][] dispensers = v.getDispensers();
				for(int i = 0; i < dispensers.length; i++)
				{
					for(int j = 0; j < dispensers.length; i++)
					{
						Dispenser d = dispensers[i][j];
						items = d.getAllItems();
						for(Item item : items)
						{
							pw.println(""+ v.getLocation() + ", " + v.getBuilding() + ", " + v.getCompany() + ", " + i + ", " + j + ", " + d.getItemType() + ", " + d.getQuantity() + ", " + d.getMax() + ", " + item.getName() + ", " + item.getManufacturer() + ", " + item.getCost() + ", " + item.getPrice() + ", " + item.getExpiredMonth() +
									"/" + item.getExpiredDay()+ "/" + item.getExpiredYear());
						}
					}
				}
			}
			
			pw.close();
		}
		catch (IOException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
