package holidayprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	double[][] data;
	
	@BeforeEach
	void setUp() throws Exception {
		data = new double[][] {
			{1, 2},
			{3, 4}
		};
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] bonus = HolidayBonus.calculateHolidayBonus(data);
		assertEquals(2000, bonus[0]);
		assertEquals(10000, bonus[1]);

	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(12000, HolidayBonus.calculateTotalHolidayBonus(data));
	}

}
