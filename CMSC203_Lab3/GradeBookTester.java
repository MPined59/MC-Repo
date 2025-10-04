package lab3junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	private GradeBook grade1;
	private GradeBook grade2;
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade2 = new GradeBook(5);
		grade1.addScore(95);
		grade1.addScore(83);
		grade2.addScore(76);
		grade2.addScore(68);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1 = null;
		grade2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("95 83"));
		assertEquals(2, grade1.getScoreSize());
		
		assertTrue(grade2.toString().equals("76 68"));
		assertEquals(2, grade2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(178, grade1.sum(), 0.0001);
		assertEquals(144, grade2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(83, grade1.minimum(), 0.0001);
		assertEquals(68, grade2.minimum(), 0.0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(95, grade1.finalScore(), 0.0001);
		assertEquals(76, grade2.finalScore(), 0.0001);
	}

	@Test
	void testGetScoreSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}
	

}
