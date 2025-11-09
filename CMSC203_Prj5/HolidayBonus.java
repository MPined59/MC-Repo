package holidayprj;
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Calculates bonuses based on arrays provided
 * Due: 11/10/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Martin Pineda
*/


public class HolidayBonus {
	public static final double HIGH_BONUS = 5000;
	public static final double LOW_BONUS = 1000;
	public static final double OTHER_BONUS = 2000;

	
	public static double[] calculateHolidayBonus(double[][] data) {
		int numStr = data.length;
		double[] bonus = new double[numStr];
		
		
		int maxCol = 0;
		//Finds num of columns
		for(double[] row : data) {
			if(row.length > maxCol) {
				maxCol = row.length;
			}
		}
		
		//Loops through each col
		for(int i = 0; i < maxCol; i++ ) {
			//Finds store with highest and lowest in col
			double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
			double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
			
			//Loops through rows to find values then assigns bonus
			for(int row = 0; row < data.length; row++) {
				if(i < data[row].length) {
					double sale = data[row][i];
					if(sale == highest) {
						bonus[row] += HIGH_BONUS;
					} else if (sale == lowest) {
						bonus[row] += LOW_BONUS;
					} else {
						bonus[row] += OTHER_BONUS;
					}
				}
			}
		}
		return bonus;
	}
	
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bonuses = calculateHolidayBonus(data);
		double total=0;
		//Adds all bonuses together
		for(double bonus: bonuses) {
			total+= bonus;
		}
		
		return total;
	}
	
	
	
	
	
	
	
}
