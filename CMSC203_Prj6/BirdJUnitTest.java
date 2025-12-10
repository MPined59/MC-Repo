package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BirdJUnitTest {

	private Bird bird;
	
	@BeforeEach
	void setUp() throws Exception {
		bird = new Bird("Bill", 3, "Parrot", "Green");
	}

	@Test
	void testBird() {
		assertEquals("Bill", bird.getName());
		assertEquals(3, bird.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("Bill", bird.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(3, bird.getAge());
	}

	@Test
	void testEqualsObject() {
		Bird bird2 = new Bird("Bill", 3, "Parrot", "Green");
		assertTrue(bird.equals(bird2));
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		Bird bird2 = bird.clone();
		assertTrue(bird.equals(bird2));
	}

	@Test
	void testToString() {
		String test = "Bird[name=Bill, age=3, species=Parrot, color=Green]";
		assertEquals(test, bird.toString());
	}
}
