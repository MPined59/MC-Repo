/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Circus class that manages animals, persons, buildings, and tickets
 * Due: 12/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Martin Pineda
*/

package circusprj;

import java.util.ArrayList;
import java.util.List;

public class Circus {
	private List<Animal> animals;
	private List<Person> persons;
	private List<Building> buildings;
	private List<Ticket> tickets;

	public Circus() {
		animals = new ArrayList<>();
		persons = new ArrayList<>();
		buildings = new ArrayList<>();
		tickets = new ArrayList<>();
	}

	// Add building
	public void addBuilding(Building building) {
		buildings.add(building);
	}

	// Display building
	public void displayAllBuildings() {
		for (Building building : buildings) {
			System.out.println(building);
		}
	}

	// Add person
	public void addPerson(Person person) {
		persons.add(person);
	}

	// Display person
	public void displayAllPersons() {
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	// Add animal
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	// Display animal using toString() method
	public void displayAllAnimals() {
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}

	// Selection sort to sort animals by age
	public void sortAnimalsByAge() {
		int n = animals.size();
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (animals.get(j).getAge() < animals.get(min).getAge()) {
					min = j;
				}
			}
			Animal temp = animals.get(min);
			animals.set(min, animals.get(i));
			animals.set(i, temp);
		}
	}

	// Selection sort to sort animals by name
	public void sortAnimalsByName() {
		int n = animals.size();
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (animals.get(j).getName().compareTo(animals.get(min).getName()) < 0) {
					min = j;
				}
			}
			Animal temp = animals.get(min);
			animals.set(min, animals.get(i));
			animals.set(i, temp);
		}
	}

	// Search for an animal by name
	public Animal searchAnimalByName(String name) {
		for (Animal animal : animals) {
			if (animal.getName().equalsIgnoreCase(name)) {
				return animal;
			}
		}
		return null;
	}

	// Add ticket
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	// Generate ticket
	public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
		Ticket ticket = new Ticket(dayOfWeek, basePrice, age); // Pass dayOfWeek, basePrice, age to Ticket constructor
		addTicket(ticket);
		return ticket;
	}

}
