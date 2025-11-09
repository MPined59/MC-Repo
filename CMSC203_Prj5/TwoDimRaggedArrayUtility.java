package holidayprj;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Provides various methods for array utility
 * Due: 11/10/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Martin Pineda
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	
	
	public static double getTotal(double[][] data) {
		double total = 0;
		//Loop through store each data, then add to total
		for (double[] row : data) {
			for (double num : row) {
				total += num;
			}
		}
		return total;
	}

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		//Loop through just rows
		for(double num: data[row]) {
			total+= num;
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		//Loop through each row, if given in right col position, it will add to toal
		for(double[] row: data) {
			if(col < row.length) {
				total += row[col];
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] data) {
		double total = getTotal(data); 
		int count = 0;
		//Gets number of data entries, row by row
		for(double[] row: data) {
			count+= row.length;
		}
		
		return total/count;
	}
	
	public static double getHighestInArray(double[][] data) {
		double high = data[0][0];
		
		//Loops by row, then by column, checks if higher than prev high value
		for(double[] row: data ) {
			for(double num: row) {
				if(num > high) {
					high  = num;
				}
			}
		}
		return high;
	}
	
	public static double getLowestInArray(double[][] data) {
		double low = data[0][0];
		//Loops by row, then by column, checks if lower than prev low value
		for(double[] row: data ) {
			for(double num: row) {
				if(num < low) {
					low  = num;
				}
			}
		}
		return low;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double high = data[row][0];
		
		//Loops through a given row, then finds high value
		for (double num: data[row]) {
			if (num > high) {
				high = num;
			}
		}
		return high;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		//Loops through a given row, then checks if data at row highest is greater at certain index, if so index = new highest index
		for(int i  = 0; i < data[row].length; i++) {
			if(data[row][i] > data[row][index]) {
				index = i;
			}
		}
		return index;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		//Loops through a given row, then checks if data at row loweest is less than at certain index, if so index = new lowest index
		for(int i  = 0; i < data[row].length; i++) {
			if(data[row][i] < data[row][index]) {
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double low = data[row][0];
		//Loops through a given row, then finds low value
		for (double num: data[row]) {
			if (num < low) {
				low = num;
			}
		}
		return low;
		
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		double high = data[0][col];
		//Loops through a given col, then finds high value
		for (double[] row : data) {
			if (col < row.length && row[col] > high) {
				high = row[col];
			}
		}
		return high;
	}
	
	public static double getHighestInColumnIndex(double[][] data, int col) {
		double high = data[0][col];
		int index = 0;
		//Loops through a given col, then checks if data at col highest is greater than at certain index, if so index = new highest index

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] > high) {
				high = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double low = data[0][col];
		//Loops through a given col, then finds low value
		for (double[] row : data) {
			if (col < row.length && row[col] < low) {
				low = row[col];
			}
		}
		return low;
	}
	
	public static double getLowestInColumnIndex(double[][] data, int col) {
		double low = data[0][col];
		int index = 0;
		//Loops through a given col, then checks if data at col lowest is less than than at certain index, if so index = new lowest index
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] < low) {
				low = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		
		double[][] temp = new double[10][10];
		int row = 0;
		
		//Loops through each row
		while(sc.hasNextLine() && row < 10) {
			String line = sc.nextLine();
			if (line.isEmpty()) {
				continue;
			}
			//Tokenizes each value into string array
			String[] tokens = line.split(" ");
			temp[row] = new double[tokens.length];
			
			//Parses bacl to double and into array
			for (int i = 0; i < tokens.length; i++) {
				temp[row][i] = Double.parseDouble(tokens[i]);
			}
			row++;
		}
		
		sc.close();
		//Fills proper array to return
		double[][] data = new double[row][];
		for (int i = 0; i < row; i++) {
			data[i] = temp[i];
		}
		
		return data;
		
	}
	
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		PrintWriter writer = new PrintWriter(file);
		
		//Loops through each row and col, adding col val then space, then after all row is done, new line for next row
		for(double[] row : data) {
			for(int i = 0; i < row.length; i++) {
				sb.append(row[i]);
				if(i < row.length -1) {
					sb.append(" ");
				}
	
			}
			sb.append("\n");
		}
		
		//Prints full string to file
		writer.print(sb.toString());
		writer.close();
		
	}
	
	
	
	
}
