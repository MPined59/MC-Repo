package movieprj;

import java.util.Scanner;

public class MovieDriver_Task1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println(movie);
		
		sc.close();
	}
}
