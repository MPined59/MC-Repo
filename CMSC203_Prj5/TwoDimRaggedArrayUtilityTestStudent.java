package holidayprj;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	double data[][];
	
	@BeforeEach
	void setUp() throws Exception {
		data = new double[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
	}

	@Test
	void testGetTotal() {
		assertEquals(45, TwoDimRaggedArrayUtility.getTotal(data));
	}

	@Test
	void testGetRowTotal() {
		assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(data, 0));
		assertEquals(15, TwoDimRaggedArrayUtility.getRowTotal(data, 1));
		assertEquals(24, TwoDimRaggedArrayUtility.getRowTotal(data, 2));

	}

	@Test
	void testGetColumnTotal() {
		assertEquals(12, TwoDimRaggedArrayUtility.getColumnTotal(data, 0));
		assertEquals(15, TwoDimRaggedArrayUtility.getColumnTotal(data, 1));
		assertEquals(18, TwoDimRaggedArrayUtility.getColumnTotal(data, 2));
	}

	@Test
	void testGetAverage() {
		assertEquals(45 / 9, TwoDimRaggedArrayUtility.getAverage(data));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(data));
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(data));
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(data, 0));
		assertEquals(6, TwoDimRaggedArrayUtility.getHighestInRow(data, 1));
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInRow(data, 2));
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2));	
}
	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(data, 0));
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(data, 1));
		assertEquals(7, TwoDimRaggedArrayUtility.getLowestInRow(data, 2));
	}

	@Test
	void testGetHighestInColumn() {
        assertEquals(7, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0));
        assertEquals(8, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1));
        assertEquals(9, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2));
	}

	@Test
	void testGetHighestInColumnIndex() {
		 assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));
	        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
	        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2));
	}

	@Test
	void testGetLowestInColumn() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2));
	}

	@Test
	void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2));
	}

	@Test
	void testReadFile() throws FileNotFoundException {
		File file = new File("test.txt");
		PrintWriter write = new PrintWriter(file);
		write.println("1 2 3");
		write.println("4 5 6");
		write.println("7 8 9");
		write.close();
		
		double[][] test = TwoDimRaggedArrayUtility.readFile(file);
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				assertEquals(data[i][j], test[i][j]);
			}
		}
	}

	@Test
	void testWriteToFile() throws FileNotFoundException {
		File file = new File("test.txt");
		TwoDimRaggedArrayUtility.writeToFile(data, file);
		assertTrue(file.exists());
	}

}
