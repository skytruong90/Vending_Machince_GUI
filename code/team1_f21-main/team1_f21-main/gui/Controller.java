package gui;

import vmClasses.VendingMachine;

public class Controller 
{
	//Set up for lists		
		public static void generateAddresses() 
		{
			Main.lvwAddresses.getItems().clear();
			String[] vms = Main.vm.getAddresses();
			for(int i = 0; i < vms.length; i++) {
				Main.lvwAddresses.getItems().add(vms[i]);
			}
		}
		
		public static void generateBuildings(String address) 
		{
			Main.lvwBuildings.getItems().clear();
			String[] vms = Main.vm.getBuildings(address);
			for(int i = 0; i < vms.length; i++) {
				Main.lvwBuildings.getItems().add(vms[i]);
			}
		}

		
		public static void generateVMs(String address) 
		{
			Main.lvwVendingMachines.getItems().clear();
			String[] vms = Main.vm.getCompanys(address);
			for(int i = 0; i < vms.length; i++) {
				Main.lvwVendingMachines.getItems().add(vms[i]);
			}
		}
		
		public static void generateVMs(String address, String building) 
		{
			Main.lvwVendingMachines.getItems().clear();
			String[] vms = Main.vm.getCompanys(address,building);
			for(int i = 0; i < vms.length; i++) 
			{
				Main.lvwVendingMachines.getItems().add(vms[i]);
			}
		}
		
		public static void generateItems(VendingMachine v) 
		{
			String[] items = Main.vm.getItemTypes(v);
			for(int i = 0; i < items.length; i++) 
			{
				Main.lvwItems.getItems().add(items[i]);
			}
		}
		
		public static boolean isInt(String string) 
		{
			char[] c = string.toCharArray();
			for(int i = 0; i < c.length; i++) 
			{
				if(!(Character.isDigit(c[i]))) 
				{
					return false;
				}
			}
			return true;
		}
		
		public static boolean isDouble(String string) 
		{
			char[] c = string.toCharArray();
			boolean foundDot = false;
			for(int i = 0; i < c.length; i++) 
			{
				if(!(Character.isDigit(c[i]))) 
				{
					if((c[i] == '.')&&(i < c.length-2)&&(!(foundDot))) 
					{
						foundDot = true;
					}
					else
					{
						return false;
					}
				}
			}
			return true;
		}
}
