package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArenaJUnitTest {
	
	private Arena arena;
	
	@BeforeEach
	void setUp() throws Exception {
		arena = new Arena("Red", 10, 50);
	}
	
	@Test
	void testArena() {
		assertEquals("Red", arena.getColor());
		assertEquals(10, arena.getLength());
		assertEquals(50, arena.getWidth());
		assertEquals("Arena", arena.getBuildingType());
	}

	@Test
	void testSetSize() {
		arena.setSize(20, 100);
		assertEquals(20, arena.getLength());
		assertEquals(100, arena.getWidth());
	}

	@Test
	void testGetLength() {
		assertEquals(10, arena.getLength());
	}

	@Test
	void testGetWidth() {
		assertEquals(50, arena.getWidth());
	}

	@Test
	void testSetColor() {
		arena.setColor("Blue");
		assertEquals("Blue", arena.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("Red", arena.getColor());
	}

	@Test
	void testSetBuildingType() {
		arena.setBuildingType("Arena1");
		assertEquals("Arena1", arena.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Arena", arena.getBuildingType());
	}

	@Test
	void testToString() {
		String test = "Arena[color=Red, length=10.00, width=50.00, buildingType=Arena]";
		assertEquals(test, arena.toString());
	}


	

}
