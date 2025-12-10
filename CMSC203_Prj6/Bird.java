/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Bird class that implements Animal interface
 * Due: 12/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Martin Pineda
*/

package circusprj;

import java.util.Objects;

public class Bird implements Animal, Cloneable {
	// instance variables

	private String name;

	private int age;

	private String species;

	private String color;

	// constructor

	public Bird(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	@Override
	public void move() {
		System.out.println(name + " the " + species + " is flies.");
	}

	@Override
	public void makeSound() {
		System.out.println(name + " the " + species + " chirps.");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object o) {
		// Check for reference equality
		if (this == o) {
			return true;
		}
		// Check for null or different class
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		// Compare fields for logical equality
		Bird bird = (Bird) o;
		return age == bird.age && Objects.equals(name, bird.name) && Objects.equals(species, bird.species)
				&& Objects.equals(color, bird.color);
	}

	@Override
	public Bird clone() throws CloneNotSupportedException {
		return (Bird) super.clone();
	}

	@Override
	public String toString() {
		return String.format("Bird[name=%s, age=%d, species=%s, color=%s]", name, age, species, color);
	}

}
