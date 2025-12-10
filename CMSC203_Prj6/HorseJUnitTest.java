package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorseJUnitTest {

	Horse horse;
	
	@BeforeEach
	void setUp() throws Exception {
		horse = new Horse("Rider", 7, "Plains", "Brown");
	}

	@Test
	void testHorse() {
		assertEquals("Rider", horse.getName());
		assertEquals(7, horse.getAge());
	}
	
	@Test
	void testGetName() {
		assertEquals("Rider", horse.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(7, horse.getAge());
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Horse horse2 = horse.clone();
		assertTrue(horse.equals(horse2));
	}
	

	@Test
	void testEqualsObject() {
		Horse horse2 = new Horse("Rider", 7, "Plains", "Brown");
		assertTrue(horse.equals(horse2));
	}

	@Test
	void testToString() {
		String test = "Horse[name=Rider, age=7, species=Plains, color=Brown]";
		assertEquals(test, horse.toString());
	}

}
