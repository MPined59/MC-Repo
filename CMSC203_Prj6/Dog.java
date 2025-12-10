/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Dog class that implements Animal interface
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

public class Dog implements Animal, Cloneable {
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    public Dog(String name, int age, String species, String color) {
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
    	System.out.println(name + " the " + species + " barks.");
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
	public Dog clone() throws CloneNotSupportedException {
    	return (Dog) super.clone();
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
    	Dog dog = (Dog) o;
    	return age == dog.age &&
			   Objects.equals(name, dog.name) &&
			   Objects.equals(species, dog.species) &&
			   Objects.equals(color, dog.color);
    }

    @Override
	public String toString() {
		return String.format("Dog[name=%s, age=%d, species=%s, color=%s]", 
				name, age, species, color);      
	}
    
}    

