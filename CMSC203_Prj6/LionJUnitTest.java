package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LionJUnitTest {

	Lion lion;
	
	@BeforeEach
	void setUp() throws Exception {
		lion = new Lion("Simba", 4, "Savannah", "Yellow");
	}

	@Test
	void testLion() {
		assertEquals("Simba", lion.getName());
		assertEquals(4, lion.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("Simba", lion.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(4, lion.getAge());
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Lion lion2 = lion.clone();
		assertTrue(lion.equals(lion2));
	}

	@Test
	void testEqualsObject() {
		Lion lion2 = new Lion("Simba", 4, "Savannah", "Yellow");
		assertTrue(lion.equals(lion2));
	}

	@Test
	void testToString() {
		String test = "Lion[name=Simba, age=4, species=Savannah, color=Yellow]";
		assertEquals(test, lion.toString());
	}
}
