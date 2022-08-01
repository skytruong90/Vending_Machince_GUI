package vmClasses;

import java.util.ArrayList;

public class Reports {
	VMManager vmm;
	
	public Reports(VMManager vmm) {
		this.vmm = vmm;
	}

	public String MachineReport(VendingMachine vm) {
		double costCurrent = 0;
		for(int height = 0; height < vm.getHeight(); height++) {
			for(int width = 0; width < vm.getWidth(); width++) {
				Dispenser d = vm.getDispenser(height, width);
				if(d != null) {
					Item i = d.getItem();
					if(i != null) {
						costCurrent += i.getPrice() * d.getQuantity();
					}
				}
			}
		}
		
		String report = "";
		report += String.format("Value of items sold: $%.2f\n",vm.getCostSold());
		report += String.format("Value of items in Vending Machine: $%.2f\n",costCurrent);
		report += String.format("Value of items sold in cash: $%.2f\n",vm.getCashSold());
		report += String.format("Value of items sold in credit: $%.2f\n",vm.getCreditSold());
		return report;
	}
	
	public String ProductReport(Item item) {
		String name = item.getName();
		double totalCost = 0;
		double totalCostRemaining = 0;
		String report = "";
		ArrayList<Integer> vms = new ArrayList<>();		
		for(int x = 0; x < vmm.numVMs(); x++) {
			VendingMachine vm = vmm.getVM(x);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item i = d.getItem();
						if((i.getName().equals(name))&&(!(vms.contains(x)))) {
							double costSold = getCostSold(i,vm);
							double costRemaining = getCostNotSold(i,vm);
							report += String.format("Vending Machine %d: $%.2f worth of %s sold, $%.2f of %s left\n",x,costSold,name,costRemaining,name);
							totalCost += costSold;
							totalCostRemaining += costRemaining;
							vms.add(x);
						}
					}
				}
			}
			ArrayList<Item> sold = vm.getItemsSold();
			for(int index = 0; index < sold.size();index++) {
				Item i = sold.get(index);
				if((i.getName().equals(name))&&(!(vms.contains(x)))) {
					double costSold = getCostSold(i,vm);
					double costRemaining = getCostNotSold(i,vm);
					report += String.format("Vending Machine %d: $%.2f worth of %s sold, $%.2f of %s left\n",x,costSold,name,costRemaining,name);
					totalCost += costSold;
					totalCostRemaining += costRemaining;
					vms.add(x);
				}
			}
		}
		report += String.format("Total cost sold: $%.2f\n",totalCost);
		report += String.format("Total cost left in vending machines: $%.2f\n",totalCostRemaining);
		return report;
	}
	
	public String DetailedMachineReport(VendingMachine vm) {
		String report = "";
		
		int itemNum = 1;
		for(int h = 0; h < vm.getHeight(); h++) {
			for(int w = 0; w < vm.getWidth(); w++) {
				Dispenser d = vm.getDispenser(h,w);
				if(d != null) {
					Item i = d.getItem();
					if(i != null) {
						ArrayList<Item> soldItems = vm.getItemsSold();
						double costSold = 0;
						for(int index = 0; index < soldItems.size(); index++) {
							if(soldItems.get(index).getName().equals(i.getName())) {
								costSold += soldItems.get(index).getPrice();
							}
						}
					report += String.format("Product %d: Sold: $%.2f, Remaining: $%.2f\n",itemNum,costSold,vm.getItemInventoryCost(i));
					itemNum++;
					}
				}
			}
		}
		report += MachineReport(vm);
		return report;
	}
	
	public String LocationReport(String location) {
		double totalCostSold = 0;
		double totalCostCurrent = 0;
		double totalCashSold = 0;
		double totalCreditSold = 0;
		String report = "";
		for(int index = 0; index < vmm.numVMs();index++) {
			VendingMachine vm = vmm.getVM(index);
			if(vm.getLocation().equals(location)) {
				report += String.format("*Vending Machine %d*\n", index);
				report += MachineReport(vm);
				totalCostSold += vm.getCostSold();
				totalCashSold += vm.getCashSold();
				totalCreditSold += vm.getCreditSold();
				
				double costCurrent = 0;
				for(int height = 0; height < vm.getHeight(); height++) {
					for(int width = 0; width < vm.getWidth(); width++) {
						Dispenser d = vm.getDispenser(height, width);
						if(d != null) {
							Item i = d.getItem();
							if(i != null) {
								costCurrent += i.getPrice() * d.getQuantity();
							}
						}
					}
				}
				totalCostCurrent += costCurrent;
			}
		}
		report += String.format("Value of all items sold: $%.2f\n",totalCostSold);
		report += String.format("Value of all items in Vending Machine: $%.2f\n",totalCostCurrent);
		report += String.format("Value of all items sold in cash: $%.2f\n",totalCashSold);
		report += String.format("Value of all items sold in credit: $%.2f\n",totalCreditSold);
		return report;
	}
	
	public String CompanyReport() {
		String report = "";
		ArrayList<String> locations = new ArrayList<>();
		double companyTotalCostSold = 0;
		double companyTotalCostCurrent = 0;
		double companyTotalCashSold = 0;
		double companyTotalCreditSold = 0;
		for(int x = 0; x < vmm.numVMs(); x++) {
			String location = vmm.getVM(x).getLocation();
			if(!(locations.contains(location))) {
				VendingMachine[] vms = vmm.getVMs(location);
				double totalCostSold = 0;
				double totalCostCurrent = 0;
				double totalCashSold = 0;
				double totalCreditSold = 0;
				for(int i = 0; i < vms.length; i++) {
					report += MachineReport(vms[i]);
					totalCostSold += vms[i].getCostSold();
					totalCashSold += vms[i].getCashSold();
					for(int height = 0; height < vms[i].getHeight(); height++) {
						for(int width = 0; width < vms[i].getWidth(); width++) {
							Dispenser d = vms[i].getDispenser(height, width);
							if(d != null) {
								Item item = d.getItem();
								if(item != null) {
									totalCostCurrent += item.getPrice() * d.getQuantity();
								}
							}
						}
					}
				}
				report += String.format("Value of all items sold at %s: $%.2f\n",location,totalCostSold);
				report += String.format("Value of all items in Vending Machine at %s: $%.2f\n",location,totalCostCurrent);
				report += String.format("Value of all items sold in cash at %s: $%.2f\n",location,totalCashSold);
				report += String.format("Value of all items sold in credit at %s: $%.2f\n",location,totalCreditSold);
				report += "--------";
				companyTotalCostSold += totalCostSold;
				companyTotalCostCurrent += totalCostCurrent;
				companyTotalCashSold += totalCashSold;
				companyTotalCreditSold += totalCreditSold;
			}
		}
		report += String.format("Value of all items sold: $%.2f\n",companyTotalCostSold);
		report += String.format("Value of all items in Vending Machine: $%.2f\n",companyTotalCostCurrent);
		report += String.format("Value of all items sold in cash: $%.2f\n",companyTotalCashSold);
		report += String.format("Value of all items sold in credit: $%.2f\n",companyTotalCreditSold);
		return report;
	}
	
	public String DryGoodsReport() {
		String report = "";
		ArrayList<String> items = new ArrayList<>();
		double totalCostSold = 0;
		double totalCostCurrent = 0;
		
		for(int i = 0; i < vmm.numVMs(); i++) {
			VendingMachine vm = vmm.getVM(i);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((!(item instanceof RefrigeratedItem))&&(!(items.contains(item.getName())))) {
							double costSold = getCostSold(item);
							double costCurrent = getCostNotSold(item);
							report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
							totalCostSold += costSold;
							totalCostCurrent += costCurrent;
							items.add(item.getName());
						}
					}
				}
			}
				ArrayList<Item> sold = vm.getItemsSold();
				for(int index = 0; index < sold.size();index++) {
					Item item = sold.get(index);
					if((!(item instanceof RefrigeratedItem))&&(!(items.contains(item.getName())))) {
						double costSold = getCostSold(item);
						double costCurrent = getCostNotSold(item);
						report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
						totalCostSold += costSold;
						totalCostCurrent += costCurrent;
						items.add(item.getName());
					}
				}
			}
		report += String.format("Totals- Total Sales: $%.2f, Total Value in inventory: $%.2f",totalCostSold,totalCostCurrent);
			
		return report;
	}
	
	public String RefrigeratedGoodsReport() {
		String report = "";
		ArrayList<String> items = new ArrayList<>();
		double totalCostSold = 0;
		double totalCostCurrent = 0;
		
		for(int i = 0; i < vmm.numVMs(); i++) {
			VendingMachine vm = vmm.getVM(i);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((item instanceof RefrigeratedItem)&&(!(items.contains(item.getName())))) {
							double costSold = getCostSold(item);
							double costCurrent = getCostNotSold(item);
							report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
							totalCostSold += costSold;
							totalCostCurrent += costCurrent;
							items.add(item.getName());
						}
					}
				}
			}
				ArrayList<Item> sold = vm.getItemsSold();
				for(int index = 0; index < sold.size();index++) {
					Item item = sold.get(index);
					if((item instanceof RefrigeratedItem)&&(!(items.contains(item.getName())))) {
						double costSold = getCostSold(item);
						double costCurrent = getCostNotSold(item);
						report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
						totalCostSold += costSold;
						totalCostCurrent += costCurrent;
						items.add(item.getName());
					}
				}
			}
		report += String.format("Totals- Total Sales: $%.2f, Total Value in inventory: $%.2f",totalCostSold,totalCostCurrent);
			
		return report;
	}
	
	public String GoodsReport() {
		String report = "";
		ArrayList<String> items = new ArrayList<>();
		double totalCostSold = 0;
		double totalCostCurrent = 0;
		
		for(int i = 0; i < vmm.numVMs(); i++) {
			VendingMachine vm = vmm.getVM(i);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if(!(items.contains(item.getName()))) {
							double costSold = getCostSold(item);
							double costCurrent = getCostNotSold(item);
							report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
							totalCostSold += costSold;
							totalCostCurrent += costCurrent;
							items.add(item.getName());
						}
					}
				}
			}
				ArrayList<Item> sold = vm.getItemsSold();
				for(int index = 0; index < sold.size();index++) {
					Item item = sold.get(index);
					if(!(items.contains(item.getName()))) {
						double costSold = getCostSold(item);
						double costCurrent = getCostNotSold(item);
						report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
						totalCostSold += costSold;
						totalCostCurrent += costCurrent;
						items.add(item.getName());
					}
				}
			}
		report += String.format("Totals- Total Sales: $%.2f, Total Value in inventory: $%.2f",totalCostSold,totalCostCurrent);
			
		return report;
	}

	public String ManufacturerReport(String m) {
		String report = "";
		ArrayList<String> items = new ArrayList<>();
		double totalCostSold = 0;
		double totalCostCurrent = 0;
		
		for(int i = 0; i < vmm.numVMs(); i++) {
			VendingMachine vm = vmm.getVM(i);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((!(items.contains(item.getName())))&&(item.getManufacturer().equals(m))) {
							double costSold = getCostSold(item,m);
							double costCurrent = getCostNotSold(item,m);
							report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
							totalCostSold += costSold;
							totalCostCurrent += costCurrent;
							items.add(item.getName());
						}
					}
				}
			}
				ArrayList<Item> sold = vm.getItemsSold();
				for(int index = 0; index < sold.size();index++) {
					Item item = sold.get(index);
					if((!(items.contains(item.getName())))&&(item.getManufacturer().equals(m))) {
						double costSold = getCostSold(item,m);
						double costCurrent = getCostNotSold(item,m);
						report += String.format("Product(%s)- Total Sales: $%.2f, Total Value in Inventory: $%.2f\n",item.getName(),costSold,costCurrent);
						totalCostSold += costSold;
						totalCostCurrent += costCurrent;
						items.add(item.getName());
					}
				}
			}
		report += String.format("Totals- Total Sales: $%.2f, Total Value in inventory: $%.2f",totalCostSold,totalCostCurrent);
			
		return report;
	}
	
	public String expiredInventoryReport(int curMonth,int curDay,int curYear) {
		String report = "";
		ArrayList<String> items = new ArrayList<>();
		double totalCostCurrent = 0;
		
		for(int i = 0; i < vmm.numVMs(); i++) {
			VendingMachine vm = vmm.getVM(i);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((!(items.contains(item.getName())))&&(item.isExpired(curMonth, curDay, curYear))) {
							double costCurrent = getCostNotSold(item,curMonth, curDay, curYear);
							report += String.format("Product(%s)- Total Value in inventory: $%.2f\n",item.getName(),costCurrent);
							totalCostCurrent += costCurrent;
							items.add(item.getName());
						}
					}
				}
			}
		}
		report += String.format("Totals- Total Value in inventory: $%.2f\n",totalCostCurrent);
		return report;
	}
	
	//helper methods
	public double getCostSold(Item i) {
		double output = 0.0;
		ArrayList<Item> sold = new ArrayList<>();
		for(int index = 0; index < vmm.numVMs(); index++) {
			sold.addAll(vmm.getVM(index).getItemsSold());
		}
		for(int x = 0; x < sold.size(); x++) {
			Item item = sold.get(x);
			if(item.getName().equals(i.getName())) {
				output += item.getPrice();
			}
		}
		return output;
	}
	
	public double getCostNotSold(Item i) {
		double output = 0.0;
		for(int x = 0; x < vmm.numVMs(); x++) {
			VendingMachine vm = vmm.getVM(x);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if(item.getName().contentEquals(i.getName())) {
							output += item.getPrice()*d.getQuantity();
						}
					}
				}
			}
		}
		return output;
	}
	
	public double getCostSold(Item i,String m) {
		double output = 0.0;
		ArrayList<Item> sold = new ArrayList<>();
		for(int index = 0; index < vmm.numVMs(); index++) {
			sold.addAll(vmm.getVM(index).getItemsSold());
		}
		for(int x = 0; x < sold.size(); x++) {
			Item item = sold.get(x);
			if((item.getName().equals(i.getName())&&(item.getManufacturer().equals(m)))) {
				output += item.getPrice();
			}
		}
		return output;
	}
	
	public double getCostNotSold(Item i,String m) {
		double output = 0.0;
		for(int x = 0; x < vmm.numVMs(); x++) {
			VendingMachine vm = vmm.getVM(x);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((item.getName().contentEquals(i.getName())&&(item.getManufacturer().equals(m)))) {
							output += item.getPrice()*d.getQuantity();
						}
					}
				}
			}
		}
		return output;
	}
	
	public double getCostNotSold(Item i,int month, int day, int year) {
		double output = 0.0;
		for(int x = 0; x < vmm.numVMs(); x++) {
			VendingMachine vm = vmm.getVM(x);
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if((item.getName().contentEquals(i.getName())&&(item.isExpired(month, day, year)))) {
							output += item.getPrice()*d.getQuantity();
						}
					}
				}
			}
		}
		return output;
	}
	
	public double getCostSold(Item i,VendingMachine vm) {
		double output = 0.0;
		ArrayList<Item> sold = vm.getItemsSold();
		for(int x = 0; x < sold.size(); x++) {
			Item item = sold.get(x);
			if(item.getName().equals(i.getName())) {
				output += item.getPrice();
			}
		}
		return output;
	}
	
	public double getCostNotSold(Item i,VendingMachine vm) {
		double output = 0.0;
			for(int h = 0; h < vm.getHeight(); h++) {
				for(int w = 0; w < vm.getWidth(); w++) {
					Dispenser d = vm.getDispenser(h,w);
					if(d != null) {
						Item item = d.getItem();
						if(item.getName().contentEquals(i.getName())) {
							output += item.getPrice()*d.getQuantity();
						}
					}
				}
			}
		return output;
	}
}
