package propertyprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	@Test
	void testPlot() {
		Plot p = new Plot();
		assertEquals(0, p.getX());
		assertEquals(0, p.getY());
		assertEquals(1, p.getWidth());
		assertEquals(1, p.getDepth());
	}

	@Test
	void testPlotIntIntIntInt() {
		Plot p = new Plot(2, 3, 4, 5);
        assertEquals(2, p.getX());
        assertEquals(3, p.getY());
        assertEquals(4, p.getWidth());
        assertEquals(5, p.getDepth());
	}

	@Test
	void testPlotPlot() {
		Plot p = new Plot(1, 2, 3, 4);
        Plot c = new Plot(p);
        assertEquals(p.getX(), c.getX());
        assertEquals(p.getY(), c.getY());
        assertEquals(p.getWidth(), c.getWidth());
        assertEquals(p.getDepth(), c.getDepth());
	}

	@Test
	void testGetX() {
		Plot p = new Plot();
		assertEquals(0, p.getX());
    }

	@Test
	void testSetX() {
		Plot p = new Plot();
        p.setX(10);
        assertEquals(10, p.getX());
	}

	@Test
	void testGetY() {
		Plot p = new Plot();
        assertEquals(0, p.getY());
	}

	@Test
	void testSetY() {
		Plot p = new Plot();
        p.setY(20);
        assertEquals(20, p.getY());
	}

	@Test
	void testGetWidth() {
		Plot p = new Plot();
        assertEquals(1, p.getWidth());
	}

	@Test
	void testSetWidth() {
		Plot p = new Plot();
        p.setWidth(15);
        assertEquals(15, p.getWidth());
	}

	@Test
	void testGetDepth() {
		Plot p = new Plot();
        assertEquals(1, p.getDepth());
	}

	@Test
	void testSetDepth() {
		Plot p = new Plot();
        p.setDepth(25);
        assertEquals(25, p.getDepth());
	}

	@Test
	void testOverlaps() {
		Plot p1 = new Plot(0, 0, 5, 5);
        Plot p2 = new Plot(4, 4, 3, 3);
        Plot p3 = new Plot(5, 5, 2, 2);
        Plot p4 = new Plot(6, 6, 2, 2);

        assertTrue(p1.overlaps(p2));
        assertFalse(p1.overlaps(p3));
        assertFalse(p1.overlaps(p4));
	}

	@Test
	void testEncompasses() {
		Plot p1 = new Plot(0, 0, 10, 10);
        Plot p2 = new Plot(2, 2, 5, 5);
        Plot p3 = new Plot(-1, 0, 5, 5);
        Plot p4 = new Plot(0, 0, 11, 5);

        assertTrue(p1.encompasses(p2));
        assertFalse(p1.encompasses(p3));
        assertFalse(p1.encompasses(p4));
	}

	@Test
	void testToString() {
		Plot p = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", p.toString());
	}

}
