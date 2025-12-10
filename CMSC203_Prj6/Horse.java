/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Horse class that implements Animal interface
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

public class Horse implements Animal, Cloneable {
	
	//instance variables
	private String name;
    private int age;
    private String species;
    private String color;
    
    //constructor
    public Horse(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	public void move() {
    	System.out.println(name + " the " + species + " runs.");
    }
	
    @Override
	public void makeSound() {
    	System.out.println(name + " the " + species + " neighs.");
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
    public Horse clone() throws CloneNotSupportedException {
		return (Horse) super.clone();
	}
  
    @Override
	public boolean equals(Object o) {
    	
		// Check for reference equality
    	if (this == o)  { 
    		return true;
    	}
		// Check for null or different class
    	if (o == null || getClass() != o.getClass())  {
    		return false;
    	}
		// Compare fields for logical equality
    	Horse horse = (Horse) o;
		return age == horse.age &&
			   Objects.equals(name, horse.name) &&
			   Objects.equals(species, horse.species) &&
			   Objects.equals(color, horse.color);
    }
    
    @Override
	public String toString() {
    	return String.format("Horse[name=%s, age=%d, species=%s, color=%s]", 
				name, age, species, color);
    }
 
}
