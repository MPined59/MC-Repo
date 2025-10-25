package propertyprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	@Test
	void testManagementCompany() {
		ManagementCompany mc = new ManagementCompany();
		assertEquals("", mc.getName());
		assertEquals("", mc.getTaxID());
		assertEquals(0, mc.getMgmFeePer());
		assertEquals(0, mc.getPropertiesCount());
	}

	@Test
	void testManagementCompanyStringStringDouble() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		assertEquals("Realtor", mc.getName());
		assertEquals("123", mc.getTaxID());
		assertEquals(10, mc.getMgmFeePer());
		assertEquals(0, mc.getPropertiesCount());
	}

	@Test
	void testManagementCompanyStringStringDoubleIntIntIntInt() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10, 1, 2, 1, 2);
		assertEquals("Realtor", mc.getName());
		assertEquals("123", mc.getTaxID());
		assertEquals(10, mc.getMgmFeePer());
		assertEquals(0, mc.getPropertiesCount());
		assertEquals(1, mc.getPlot().getX());
		assertEquals(2, mc.getPlot().getY());
		assertEquals(1, mc.getPlot().getWidth());
		assertEquals(2, mc.getPlot().getDepth());
	}

	@Test
	void testManagementCompanyManagementCompany() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10, 1, 2, 1, 2);
		ManagementCompany comp = new ManagementCompany(mc);
		
		assertEquals(comp.getName(), mc.getName());
		assertEquals(comp.getTaxID(), mc.getTaxID());
		assertEquals(comp.getMgmFeePer(), mc.getMgmFeePer());
		assertEquals(comp.getPropertiesCount(), mc.getPropertiesCount());
		
		
	}

	@Test
	void testGetName() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		assertEquals("Realtor", mc.getName());
	}

	@Test
	void testGetTaxID() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		assertEquals("123", mc.getTaxID());
	}

	@Test
	void testGetMgmFeePer() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		assertEquals(10, mc.getMgmFeePer());	
		}

	@Test
	void testGetProperties() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p = new Property("Estate", "New York", 1200, "Joe Schmoe");
		mc.addProperty(p);
		assertEquals(p.getPropertyName(), mc.getProperties()[0].getPropertyName());	
		}

	@Test
	void testGetPlot() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10, 1, 2, 1, 2);
		Plot p = mc.getPlot();
		assertEquals(1, p.getX());
		assertEquals(2, p.getY());
		assertEquals(1, p.getWidth());
		assertEquals(2, p.getDepth());
	}

	@Test
	void testGetTotalRent() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe");
		Property p2 = new Property("Estate2", "LA", 1800, "Joe Joe");
		mc.addProperty(p1);
		mc.addProperty(p2);
		assertEquals(3000, mc.getTotalRent());
	}

	@Test
	void testGetHighestRentProperty() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe", 0, 0, 2, 2);
		Property p2 = new Property("Estate2", "LA", 1800, "Joe Joe", 1, 1, 2, 2);
		mc.addProperty(p1);
		mc.addProperty(p2);
		assertEquals(1800, mc.getHighestRentProperty().getRentAmount());
	}

	@Test
	void testRemoveLastProperty() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);
		Property p2 = new Property("Estate2", "LA", 1800, "Joe Joe", 5, 5, 1, 1);
		mc.addProperty(p1);
		mc.addProperty(p2);
		mc.removeLastProperty();
		assertEquals(1, mc.getPropertiesCount());
	}

	@Test
	void testIsPropertiesFull() {
		ManagementCompany mc = new ManagementCompany();
		for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
			mc.addProperty(new Property("Property:" + i, "City:" + i, i, "Owner:", i, i, i, i));
		}
		assertTrue(mc.isPropertiesFull());
	}

	@Test
	void testGetPropertiesCount() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe");
		Property p2 = new Property("Estate2", "LA", 1800, "Joe Joe");
		mc.addProperty(p1);
		mc.addProperty(p2);
		assertEquals(1, mc.getPropertiesCount());
	}

	@Test
	void testIsManagementFeeValid() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		assertTrue(mc.isManagementFeeValid());
		
		ManagementCompany mc1 = new ManagementCompany("Realtor", "123", -1);
		assertFalse(mc1.isManagementFeeValid());
		
		ManagementCompany mc2 = new ManagementCompany("Realtor", "123", 101);
		assertFalse(mc2.isManagementFeeValid());
	}

	@Test
	void testAddPropertyProperty() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe");
		int index = mc.addProperty(p1);
		
		assertEquals(0, index);
		assertEquals(p1.getPropertyName(), mc.getProperties()[0].getPropertyName());
	}

	@Test
	void testAddPropertyStringStringDoubleString() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		int index = mc.addProperty("Estate1", "New York", 1200, "Joe Schmoe");
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe");

		assertEquals(0, index);
		assertEquals(p1.getPropertyName(), mc.getProperties()[0].getPropertyName());
	}

	@Test
	void testAddPropertyStringStringDoubleStringIntIntIntInt() {
		ManagementCompany mc = new ManagementCompany("Realtor", "123", 10);
		int index = mc.addProperty("Estate1", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);
		Property p1 = new Property("Estate1", "New York", 1200, "Joe Schmoe", 1, 2, 1, 2);

		assertEquals(0, index);
		assertEquals(p1.getPlot().getX(), mc.getProperties()[0].getPlot().getX());
	}

}
