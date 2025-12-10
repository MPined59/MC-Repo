/*
 * Class: CMSC203 
 * Instructor: Professor Evazi
 * Description: Acrobatic class that extends Person class
 * Due: 12/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Martin Pineda
*/


package circusprj;

public class Acrobatic extends Person {

	private String job;

	public Acrobatic(String name, int age, int yearsWorked, String job) {
		super(name, age, yearsWorked);
		this.job = job;
	}

	@Override

	public String toString() {
		return String.format("Acrobatic[name=%s, age=%d, yearsWorked=%d, job=%s]", getName(), getAge(),
				getYearsWorked(), job);
	}

}
