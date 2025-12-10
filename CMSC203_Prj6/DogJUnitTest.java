package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogJUnitTest {

	private Dog dog;
	
	@BeforeEach
	void setUp() throws Exception {
		dog = new Dog("Radar", 5, "Golden Retriever", "Yellow");
	}

	@Test
	void testDog() {
		assertEquals("Radar", dog.getName());
		assertEquals(5, dog.getAge());
	}
	
	@Test
	void testGetName() {
		assertEquals("Radar", dog.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(5, dog.getAge());
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Dog dog2 = dog.clone();
		assertTrue(dog.equals(dog2));
	}

	@Test
	void testEqualsObject() {
		Dog dog2 = new Dog("Radar", 5, "Golden Retriever", "Yellow");
		assertTrue(dog.equals(dog2));
	}

	@Test
	void testToString() {
		String test = "Dog[name=Radar, age=5, species=Golden Retriever, color=Yellow]";
		assertEquals(test, dog.toString());
	}

}
