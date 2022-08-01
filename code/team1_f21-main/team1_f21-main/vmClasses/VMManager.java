package vmClasses;
import java.util.ArrayList;

public class VMManager {
	//instance variables
	VendingMachine[] vms = new VendingMachine[0];
	
	//constructors
	public VMManager() {}
	
	public VMManager(VendingMachine[] vms) {
		this.vms = vms;
	}
	
	//number of vending machines methods
	public int numVMs() {
		return vms.length;
	}
	
	public int numVMs(String location) {
		return getVMs(location).length;
	}
	
	public int numVMs(String location, String building) {
		return getVMs(location,building).length;
	}
	
	//get vending machines methods
	public VendingMachine getVM(int index) {
		if(vms[index].hasTemp()) {
			return (RefrigeratedVendingMachine)vms[index];
		}
		else {
			return vms[index];
		}
	}
	
	public VendingMachine[] getVMs() {
		return vms;
	}
	
	public VendingMachine[] getVMs(String location) {
		ArrayList<VendingMachine> locations = new ArrayList<VendingMachine>();
		for(int i = 0; i < vms.length; i++) {
			if(vms[i].getLocation().equals(location)) {
				locations.add(vms[i]);
			}
		}
		VendingMachine[] output = new VendingMachine[locations.size()];
		return locations.toArray(output);
	}
	
	public VendingMachine[] getVMs(String location, String building) {
		VendingMachine[] in = getVMs(location);
		ArrayList<VendingMachine> buildings = new ArrayList<VendingMachine>();
		for(int i = 0; i < in.length; i++) {
			if(in[i].getLocation().equals(location)) {
				buildings.add(in[i]);
			}
		}
		VendingMachine[] output = new VendingMachine[buildings.size()];
		return buildings.toArray(output);
	}
	
	//remove vending machine methods
	public VendingMachine removeVM(String location, String building, String company) {
		VendingMachine vm = null;
		if(vms.length == 0) {
			return null;
		}
		VendingMachine[] newVms = new VendingMachine[vms.length-1];
		int index = 0;
		for(int i = 0; i < vms.length; i++) {
			if(!(vms[i].getLocation().equals(location))||
			  (!(vms[i].getBuilding().equals(building)))||
			  (!(vms[i].getCompany().equals(company)))) {
				newVms[index] = vms[i];
				index++;
			}
			else {
				vm = vms[i];
			}
		}
		this.vms = newVms;
		return vm;
	}
	
	public VendingMachine removeVM(String location, String company) {
		VendingMachine vm = null;
		if(vms.length == 0) {
			return null;
		}
		VendingMachine[] newVms = new VendingMachine[vms.length-1];
		int index = 0;
		for(int i = 0; i < vms.length; i++) {
			if(!(vms[i].getLocation().equals(location))||
			  (!(vms[i].getCompany().equals(company)))) {
				newVms[index] = vms[i];
				index++;
			}
			else {
				vm = vms[i];
			}
		}
		this.vms = newVms;
		return vm;
	}
	
	//get vending machine methods
	public VendingMachine getVM(String location, String building, String company) {
		if(vms.length == 0) {
			return null;
		}
		for(int i = 0; i < vms.length; i++) {
			if((vms[i].getLocation().equals(location))&&
			  ((vms[i].getBuilding().equals(building)))&&
			  ((vms[i].getCompany().equals(company)))) {
				return vms[i];
			}
		}
		return null;
	}
	
	public VendingMachine getVM(String location, String company) {
		if(vms.length == 0) {
			return null;
		}
		for(int i = 0; i < vms.length; i++) {
			if((vms[i].getLocation().equals(location))&&
			  ((vms[i].getCompany().equals(company)))) {
				return vms[i];
			}
		}
		return null;
	}
	
	//adding vending machines
	public boolean addVM(int height, int width, int capacity, String location, String building, String company) {
		VendingMachine vm = new VendingMachine(height,width,capacity,location,building,company);
		VendingMachine[] newVms = new VendingMachine[vms.length+1];
		if(getVM(location,building,company)!=null) {
			return false;
		}
		for(int i = 0; i < vms.length; i++) {
			newVms[i] = vms[i];
			}
		newVms[newVms.length-1] = vm;
		this.vms = newVms;
		return true;
	}
	
	public boolean addVM(int height, int width, int capacity, String location, String company) {
		VendingMachine vm = new VendingMachine(height,width,capacity,location,company);
		VendingMachine[] newVms = new VendingMachine[vms.length+1];
		if(getVM(location,company)!=null) {
			return false;
		}
		for(int i = 0; i < vms.length; i++) {
			newVms[i] = vms[i];
			}
		newVms[newVms.length-1] = vm;
		this.vms = newVms;
		return true;
	}
	
	public boolean addRVM(int height, int width, int capacity, String location, String building, String company, double maxTemp) {
		RefrigeratedVendingMachine vm = new RefrigeratedVendingMachine(height,width,capacity,location,building,company,maxTemp);
		VendingMachine[] newVms = new VendingMachine[vms.length+1];
		if(getVM(location,building,company)!=null) {
			return false;
		}
		for(int i = 0; i < vms.length; i++) {
			newVms[i] = vms[i];
			}
		newVms[newVms.length-1] = vm;
		this.vms = newVms;
		return true;
	}
	
	public boolean addRVM(int height, int width, int capacity, String location, String company, double maxTemp) {
		RefrigeratedVendingMachine vm = new RefrigeratedVendingMachine(height,width,capacity,location,company,maxTemp);
		VendingMachine[] newVms = new VendingMachine[vms.length+1];
		if(getVM(location,company)!=null) {
			return false;
		}
		for(int i = 0; i < vms.length; i++) {
			newVms[i] = vms[i];
			}
		newVms[newVms.length-1] = vm;
		this.vms = newVms;
		return true;
	}
	
	public boolean replace(int index, VendingMachine vm) {
		if((index >= vms.length)||(index < 0)) {
			return false;
		}
		vms[index] = vm;
		return true;
	}
	
	//return vending machine index
	public int getVMIndex(String location, String building, String company) {
		if(vms.length == 0) {
			return -1;
		}
		for(int i = 0; i < vms.length; i++) {
			if((vms[i].getLocation().equals(location))&&
			  ((vms[i].getBuilding().equals(building)))&&
			  ((vms[i].getCompany().equals(company)))) {
				return i;
			}
		}
		return -2;
	}
	
	public int getVMIndex(String location, String company) {
		if(vms.length == 0) {
			return -1;
		}
		for(int i = 0; i < vms.length; i++) {
			if((vms[i].getLocation().equals(location))&&
			  ((vms[i].getCompany().equals(company)))) {
				return i;
			}
		}
		return -2;
	}
	
	//helpers for gui
	public String[] getAddresses() {
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < vms.length; i++) {
			if(!(strings.contains(vms[i].getLocation()))){
				strings.add(vms[i].getLocation());
			}
		}
		String[] output = new String[strings.size()];
		return strings.toArray(output);
	}
	
	public String[] getBuildings(String location) {
		VendingMachine[] list = getVMs(location);
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < list.length; i++) {
			if(!(strings.contains(list[i].getBuilding()))){
				strings.add(list[i].getBuilding());
			}
		}
		String[] output = new String[strings.size()];
		return strings.toArray(output);
	}
	
	public String[] getCompanys(String location) {
		VendingMachine[] list = getVMs(location);
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < list.length; i++) {
			if(!(strings.contains(list[i].getCompany()))){
				strings.add(list[i].getCompany());
			}
		}
		String[] output = new String[strings.size()];
		return strings.toArray(output);
	}
	
	public String[] getCompanys(String location, String building) {
		VendingMachine[] list = getVMs(location,building);
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < list.length; i++) {
			if(!(strings.contains(list[i].getCompany()))){
				strings.add(list[i].getCompany());
			}
		}
		String[] output = new String[strings.size()];
		return strings.toArray(output);
	}
	
	public String[] getItemTypes(VendingMachine vm) {
		int height = vm.getHeight();
		int width = vm.getWidth();
		ArrayList<String> items = new ArrayList<String>();
		for(int x = 0;x < height; x++) {
			for(int y = 0;y < width; y++) {
				if((vm.getItemTypeFromArray(x,y) != null)&&(!(items.contains(vm.getItemTypeFromArray(x,y))))) {
					items.add(vm.getItemTypeFromArray(x,y));
				}
			}
		}
		String[] output = new String[items.size()];
		return items.toArray(output);
	}
	
	public String getHeightWidth(String name,VendingMachine v) {
		int height = v.getHeight();
		int width = v.getWidth();
		for(int x = 0;x < height; x++) {
			for(int y = 0;y < width; y++) {
				if(v.getItemTypeFromArray(x,y) != null) {
					if(v.getItemTypeFromArray(x,y).equals(name)) {
						return x + "/" + y;
				}
				}
			}
		}
		return null;
	}
}
