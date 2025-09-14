/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: Reads colors from list then prompts user to guess color in rounds of 3.
 * Due: 09/15/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Martin Pineda
*/



package espgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
	public static void main(String[] args) throws FileNotFoundException {
		// Color constants
		final String COLOR_1 = "black";
		final String COLOR_2 = "white";
		final String COLOR_3 = "gray";
		final String COLOR_4 = "silver";
		final String COLOR_5 = "maroon";
		final String COLOR_6 = "red";
		final String COLOR_7 = "purple";
		final String COLOR_8 = "fuchsia";
		final String COLOR_9 = "green";
		final String COLOR_10 = "lime";
		final String COLOR_11 = "olive";
		final String COLOR_12 = "yellow";
		final String COLOR_13 = "navy";
		final String COLOR_14 = "blue";
		final String COLOR_15 = "teal";
		final String COLOR_16 = "aqua";
		final int ROUNDS = 3;
		final int SHOW_16 = 16;
		final int SHOW_10 = 10;
		final int SHOW_5 = 5;
		
		//Variables
		int choice = 0;
		int guessCount = 0;
		int showColors = 0;
		char next;
		
		//Class objects
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		// Menu
		while (choice != 4) {
			System.out.println("ESP Game");
			System.out.println("\t1- Game with 16 colors");
			System.out.println("\t2- Game with 10 colors");
			System.out.println("\t3- Game with 5 colors");
			System.out.println("\t4- Exit");

			System.out.print("Choose an option: ");
			choice = sc.nextInt();
			sc.nextLine();

			// Select max color

			if (choice == 1)
				showColors = SHOW_16;
			else if (choice == 2)
				showColors = SHOW_10;
			else if (choice == 3)
				showColors = SHOW_5;
			else if (choice == 4)
				break;
			else {
				System.out.println("Invalid choice, try again.");
				continue;
			}
			
			//Read to file
			File file = new File("colors.txt");
			Scanner fileScanner = new Scanner(file);

			for (int i = 0; i < showColors; i++) {
				String tempColor = fileScanner.nextLine();
				System.out.println((i + 1) + ". " + tempColor);
			}
			fileScanner.close();

			//Find selected color and match to constant
			for (int i = 1; i <= ROUNDS; i++) {
				int randomNum = rand.nextInt(showColors) + 1;

				String selectedColor = "";

				if (randomNum == 1)
					selectedColor = COLOR_1;
				else if (randomNum == 2)
					selectedColor = COLOR_2;
				else if (randomNum == 3)
					selectedColor = COLOR_3;
				else if (randomNum == 4)
					selectedColor = COLOR_4;
				else if (randomNum == 5)
					selectedColor = COLOR_5;
				else if (randomNum == 6)
					selectedColor = COLOR_6;
				else if (randomNum == 7)
					selectedColor = COLOR_7;
				else if (randomNum == 8)
					selectedColor = COLOR_8;
				else if (randomNum == 9)
					selectedColor = COLOR_9;
				else if (randomNum == 10)
					selectedColor = COLOR_10;
				else if (randomNum == 11)
					selectedColor = COLOR_11;
				else if (randomNum == 12)
					selectedColor = COLOR_12;
				else if (randomNum == 13)
					selectedColor = COLOR_13;
				else if (randomNum == 14)
					selectedColor = COLOR_14;
				else if (randomNum == 15)
					selectedColor = COLOR_15;
				else if (randomNum == 16)
					selectedColor = COLOR_16;
				
				
				
				//Get input in lowercase to match ttxt file
				System.out.print("Round " + i + ": Guess the color: ");
				String guess;
				guess = sc.nextLine().toLowerCase();
				
				System.out.println("I was thinking of " + selectedColor);

				if (guess.equals(selectedColor)) {
					guessCount++;
				} 
				
				
			}
			
			//Check if want to play again
			System.out.println("You guessed " + guessCount + " out of 3 colors correctly.");
			System.out.println("Would you like to play again? (Y/N)");
			
			next = sc.next().charAt(0);
			sc.nextLine();
			
			if(next == 'y' || next =='Y') {
				guessCount = 0;
				continue;
			} else {
				choice = 4;
			}
			
			//Create final reciept
			String userName, userDescription, dueDate;
			
			
			System.out.print("Enter your name: ");
			userName = sc.nextLine();

			System.out.print("Describe yourself: ");
			userDescription = sc.nextLine();

			System.out.print("Enter due date: ");
			dueDate = sc.nextLine();

			System.out.println("Game Over");
			System.out.println("You guessed " + guessCount + " out of 3 colors correctly.");
			System.out.println("Due Date: " + dueDate);
			System.out.println("Username: " + userName);
			System.out.println("User Description: " + userDescription);
			System.out.println("Date: " + dueDate);

			
			
			PrintWriter writer = new PrintWriter("EspGameResults.txt");
			writer.println("Game Over");
			writer.println("You guessed " + guessCount + " out of 3 colors correctly.");
			writer.println("Due Date: " + dueDate);
			writer.println("Username: " + userName);
			writer.println("User Description: " + userDescription);
			writer.println("Date: " + dueDate);
			writer.close();

		}
		sc.close();
	}
}
