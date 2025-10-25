/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: ManagementCompany class creates a company that can perform a number of functions on plots and properties.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Martin Pineda
*/

package propertyprj;

public class ManagementCompany {
	//Consts
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	//Variables
	private String name;
	private String taxID;
	private double mgmFeePer;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	//Constructors
	public ManagementCompany() {
		this.name = "";
		this.taxID ="";
		this.mgmFeePer = 0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(ManagementCompany otherCompany){
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		
		this.properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < otherCompany.numberOfProperties; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
		
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;
	}
	
	//Getters
	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public Property[] getProperties() {
		return properties;
	}

	public Plot getPlot() {
		return plot;
	}
	
	public double getTotalRent() {
		double total = 0;
		for(int i = 0; i < numberOfProperties; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	public Property getHighestRentProperty() {
		Property highest = properties[0];
		
		for(int i = 0; i < numberOfProperties; i++) {
			if(properties[i].getRentAmount() > highest.getRentAmount()) {
				highest = properties[i];
			}
		}
		return highest;
	}
	
	public void removeLastProperty() {
		properties[numberOfProperties - 1] = null;
		numberOfProperties -= 1;
	}
	
	public boolean isPropertiesFull() {
		return numberOfProperties == MAX_PROPERTY;
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public boolean isManagementFeeValid() {
		return mgmFeePer >= 0 && mgmFeePer <= 100;
	}
	
	public int addProperty(Property property) {
		if (isPropertiesFull()) {
			return -1;
		} else if (property == null) {
			return -2;
		} else if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < numberOfProperties; i++) {
			if(properties[i] != null && properties[i].getPlot().overlaps(property.getPlot()) ) {
				return -4;
			}
		}
		
		properties[numberOfProperties] = new Property(property);
		numberOfProperties++;
		return numberOfProperties - 1;
		
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property p = new Property(name, city, rent, owner);
		return addProperty(p);
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(p);
	}
	@Override
	
	public String toString() {
		String strRtn = "List of the properties for " + name + ", taxID: " + taxID +
				"\n______________________________________________________\n";
		for(int i = 0; i < numberOfProperties; i++) {
			strRtn += properties[i].toString() + "\n";
		}
		strRtn += "______________________________________________________\n";
		double totalManage = this.getTotalRent() * (mgmFeePer /100);
		strRtn += "\n total management Fee: " + totalManage;
		return strRtn;
				
	}
	
	
	
}
