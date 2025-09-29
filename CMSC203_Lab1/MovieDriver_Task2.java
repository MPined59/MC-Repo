package movieprj;

import java.util.Scanner;

public class MovieDriver_Task2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
		Movie movie = new Movie();
		
		
		System.out.println("Enter movie: ");
		String movieN = sc.nextLine();
		movie.setTitle(movieN);
		
		System.out.println("Enter movie rating: ");
		String rating = sc.nextLine();
		movie.setRating(rating);
		
		System.out.println("Enter movie tickets sold: ");
		int tickets = sc.nextInt();
		movie.setSoldTickets(tickets);
		
		sc.nextLine();
		
		System.out.println(movie);
		
		System.out.println("Would you like to submit another movie?: (y or n)");
		choice = sc.next().charAt(0);
		
		sc.nextLine();
		
		} while (choice != 'n');
		System.out.println("Bye,");
		sc.close();
	}
}
