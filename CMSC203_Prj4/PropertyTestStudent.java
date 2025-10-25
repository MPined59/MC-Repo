package propertyprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	@Test
	void testProperty() {
		Property p = new Property();
		assertEquals("", p.getPropertyName());
		assertEquals("", p.getCity());
		assertEquals(0, p.getRentAmount());
		assertEquals("", p.getOwner());
	}

	@Test
	void testPropertyStringStringDoubleString() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		assertEquals("Estate", p.getPropertyName());
		assertEquals("New York", p.getCity());
		assertEquals(1200, p.getRentAmount());
		assertEquals("Joe Schmoe", p.getOwner());
	}

	@Test
	void testPropertyStringStringDoubleStringIntIntIntInt() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);
		assertEquals("Estate", p.getPropertyName());
		assertEquals("New York", p.getCity());
		assertEquals(1200, p.getRentAmount());
		assertEquals("Joe Schmoe", p.getOwner());
		assertEquals(1, p.getPlot().getX());
		assertEquals(2, p.getPlot().getY());
		assertEquals(1, p.getPlot().getWidth());
		assertEquals(2, p.getPlot().getDepth());
	}

	@Test
	void testPropertyProperty() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);
		Property pc = new Property(p);
		
		assertEquals(p.getPropertyName(), pc.getPropertyName());
		assertEquals(p.getCity(), pc.getCity());
		assertEquals(p.getRentAmount(), pc.getRentAmount());
		assertEquals(p.getOwner(), pc.getOwner());
		
		assertEquals(p.getPlot().getX(), pc.getPlot().getX());
		assertEquals(p.getPlot().getY(), pc.getPlot().getY());
		assertEquals(p.getPlot().getWidth(), pc.getPlot().getWidth());
		assertEquals(p.getPlot().getDepth(), pc.getPlot().getDepth());
	}

	@Test
	void testGetPropertyName() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		assertEquals("Estate", p.getPropertyName());
	}

	@Test
	void testSetPropertyName() {
		Property p = new Property("", "New York", 1200, "Joe Schmoe");
		p.setPropertyName("Estate");
		assertEquals("Estate", p.getPropertyName());
	}

	@Test
	void testGetCity() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		assertEquals("New York", p.getCity());
	}

	@Test
	void testSetCity() {
		Property p = new Property("Estate", "", 1200, "Joe Schmoe");
		p.setCity("New York");
		assertEquals("New York", p.getCity());
	}

	@Test
	void testGetRentAmount() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		assertEquals(1200, p.getRentAmount());
	}

	@Test
	void testSetRentAmount() {
		Property p = new Property("Estate", "New York", 0, "Joe Schmoe");
		p.setRentAmount(1200);
		assertEquals(1200, p.getRentAmount());
	}

	@Test
	void testGetOwner() {
		Property p = new Property("Estate", "New York", 0, "Joe Schmoe");
		assertEquals("Joe Schmoe", p.getOwner());
	}

	@Test
	void testSetOwner() {
		Property p = new Property("Estate", "New York", 1200, "");
		p.setOwner("Joe Schmoe");
		assertEquals("Joe Schmoe", p.getOwner());
	}

	@Test
	void testGetPlot() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);
		assertEquals(1, p.getPlot().getX());
		assertEquals(2, p.getPlot().getY());
		assertEquals(1, p.getPlot().getWidth());
		assertEquals(2, p.getPlot().getDepth());
	}

	@Test
	void testSetPlot() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe", 0, 0, 0, 0);
		Plot pl = new Plot(1, 2, 1, 2);
		p.setPlot(pl);
		assertEquals(1, p.getPlot().getX());
		assertEquals(2, p.getPlot().getY());
		assertEquals(1, p.getPlot().getWidth());
		assertEquals(2, p.getPlot().getDepth());
	}

	@Test
	void testToString() {
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		assertEquals("Estate,New York,Joe Schmoe,1200.0", p.toString());
	}

}
