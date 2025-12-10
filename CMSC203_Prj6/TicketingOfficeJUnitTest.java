package circusprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketingOfficeJUnitTest {
	
	TicketingOffice office;
	
	@BeforeEach
	void setUp() throws Exception {
		office = new TicketingOffice("White", 10.11, 50.555);
	}

	@Test
	void testTicketingOffice() {
		assertEquals("White", office.getColor());
		assertEquals(10.11, office.getLength());
		assertEquals(50.555, office.getWidth());
	}

	@Test
	void testSetSize() {
		office.setSize(20.22, 100.333);
		assertEquals(20.22, office.getLength());
		assertEquals(100.333, office.getWidth());
	}

	@Test
	void testGetLength() {
		assertEquals(10.11, office.getLength());
	}

	@Test
	void testGetWidth() {
		assertEquals(50.555, office.getWidth());
	}

	@Test
	void testSetColor() {
		office.setColor("Black");
		assertEquals("Black", office.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("White", office.getColor());
	}

	@Test
	void testSetBuildingType() {
		office.setBuildingType("office2");
		assertEquals("office2", office.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Ticketing Office", office.getBuildingType());
	}

	@Test
	void testToString() {
		String test = "TicketingOffice[color=White, length=10.11, width=50.56, buildingType=Ticketing Office]";
		assertEquals(test, office.toString());
	}
}
