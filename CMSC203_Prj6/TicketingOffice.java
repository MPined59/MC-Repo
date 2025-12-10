/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: TicketingOffice class that implements Building interface
 * Due: 12/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Martin Pineda
*/
package circusprj;

public class TicketingOffice implements Building {
	// instance variables
	private String color;
	private double length;
	private double width;
	private String buildingType;

	// constructor
	public TicketingOffice(String color, double length, double width) {
		this.color = color;
		this.length = length;
		this.width = width;
		this.buildingType = "Ticketing Office";
	}

	@Override
	public void setSize(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setBuildingType(String type) {
		this.buildingType = type;
	}

	@Override
	public String getBuildingType() {
		return buildingType;
	}

	@Override
	public String toString() {
		return String.format("TicketingOffice[color=%s, length=%.2f, width=%.2f, buildingType=%s]", getColor(),
				getLength(), getWidth(), getBuildingType());
	}

}
