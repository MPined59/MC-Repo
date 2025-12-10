/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Ticket class that handles ticket info
 * Due: 12/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Martin Pineda
*/

package circusprj;

public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }

    // Calculate ticket price based on day of week and age
    public double calculatePrice() {
    	double price = basePrice;
    
        // Apply discounts for weekdays
    	switch (dayOfWeek) {
			case "monday":
			case "tuesday":
			case "wednesday":
			case "thursday":
			case "friday":
				price *= 0.9; 
				break;
		}
    	
        // Apply age-based discounts
    	switch (age) { 
    	 	case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10:
    	 				price *= 0.5; 
		 				break;
    	}
    	return price;
    }
    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}

