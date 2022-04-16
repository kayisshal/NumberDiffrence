package program.NumberDifference;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberDifferenceTest {
	private CalcNUmberDifference sut;
	private Screen screen;    
	private NumberDifferenceFlow ndf;    
	private App app;    
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	/**
	 * Setup = inisiasi sebelum test dijalankan, preparation object
	 * --> pay attention to keep components and test cases small, 
	 * --> the trade-off seems acceptable. 
	 * --> implicit setup can be used to deine the fixture common for all tests. 
	 * --> Small in-line and delegate setup statements may supplement .. 
	 *     the speciic preconditions on per-test basis. 
	 * */
	@Before
	public void setUp() throws Exception {
		sut = new CalcNUmberDifference();
		screen = new Screen();
		ndf = new NumberDifferenceFlow();
	}

	@Test
	public void testInputNBilLuarRange_01() {
		// (1) setup (arrange, build)
		int jumlahDeretBil;
		boolean actual, expected;
		jumlahDeretBil = 15; // bukan berada pada range 1-10
		expected = false;
		
		// (2) exercise (act, operate)
		actual = sut.validateRangeInputMaxDeret(jumlahDeretBil);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInputNBilDalamRange_01() {
		// (1) setup (arrange, build)
		int jumlahDeretBil;
		boolean actual, expected;
		jumlahDeretBil = 5; // berada pada range 1-10
		expected = true;
		
		// (2) exercise (act, operate)
		actual = sut.validateRangeInputMaxDeret(jumlahDeretBil);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_1() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 5; // berada pada range 1-10
		expected = "Difference : 5\nGroup 1, Small Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_1BatasAtas() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 10; // berada pada range 1-10
		expected = "Difference : 10\nGroup 1, Small Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_1BatasBawah() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 1; // berada pada range 1-10
		expected = "Difference : 1\nGroup 1, Small Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_2() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 20; // berada pada range 11-50
		expected = "Difference : 20\nGroup 2, Medium Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_2BatasAtas() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 50; // berada pada range 11-50
		expected = "Difference : 50\nGroup 2, Medium Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_2BatasBawah() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 11; // berada pada range 11-50
		expected = "Difference : 11\nGroup 2, Medium Difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_3() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 99; // berada pada range >50
		expected = "Difference : 99\nGroup 3, Large Differece";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_3BatasBawah() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 51; // berada pada range >50
		expected = "Difference : 51\nGroup 3, Large Differece";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputKelompok_0() {
		// (1) setup (arrange, build)
		int difference;
		String actual, expected;
		difference = 0; // berada pada range 0
		expected = "Difference : 0\nNon Group There's no difference";
		
		// (2) exercise (act, operate)
		actual = sut.groupingDifference(difference);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputDari2InputSama() {
		// (1) setup (arrange, build)
		ArrayList<Integer> deretBil = new ArrayList<Integer>(2);
		deretBil.add(1);
		deretBil.add(1);
		int actual, expected;
		expected = 0;
		
		// (2) exercise (act, operate)
		actual = sut.numberDiffirenceProcess(deretBil);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputDari2InputTidakImbang1() {
		// (1) setup (arrange, build)
		ArrayList<Integer> deretBil = new ArrayList<Integer>(2);
		deretBil.add(10);
		deretBil.add(1);
		int actual, expected;
		expected = 9;
		
		// (2) exercise (act, operate)
		actual = sut.numberDiffirenceProcess(deretBil);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testOtuputDari2InputTidakImbang2() {
		// (1) setup (arrange, build)
		ArrayList<Integer> deretBil = new ArrayList<Integer>(2);
		deretBil.add(1);
		deretBil.add(10);
		int actual, expected;
		expected = 9;
		
		// (2) exercise (act, operate)
		actual = sut.numberDiffirenceProcess(deretBil);
		
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testScreenHeader() {
		// (1) setup (arrange, build)
		screen.printHeader();
		String actual, expected;
		// (2) exercise (act, operate)
		actual = outContent.toString();
		expected = "Number Difference";
		// (3) verify (assert, check)
		assertEquals(expected, actual.trim());
	}

	@Test
	public void testScreenLabelInputNBilangan() {
		
		// (1) setup (arrange, build)
		screen.printLabelInputNBilangan();
		String actual, expected;
		// (2) exercise (act, operate)
		actual = outContent.toString();
		expected = "Input N Number :";
		// (3) verify (assert, check)
		assertEquals(expected, actual.trim());
	}
	
	@Test
	public void testScreenLabelInputDeret() {
		// (1) setup (arrange, build)
		screen.printLabelInputDeret();
		String actual, expected;
		// (2) exercise (act, operate)
		actual = outContent.toString();
		expected = "Input Number Series :";
		// (3) verify (assert, check)
		assertEquals(expected, actual.trim());
	}
	
	@Test
	public void testScreenInputNumberSingleValue() {
		// (1) setup (arrange, build)
		String input = "5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// (2) exercise (act, operate)
		int actual, expected;
		actual = screen.inputNumberSingleValue();
		expected = 5;
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}
	
	@Test
	public void testScreenInputNumberListValue() {
		// (1) setup (arrange, build)
		String input = "2\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// (2) exercise (act, operate)
		ArrayList<Integer> actual;
		ArrayList<Integer> expected = new ArrayList<Integer>(2);
		actual = screen.inputNumberListValue(2);
		expected.add(2);
		expected.add(1);
		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRun() {
		app = new App();
	}
	
	// @Test
	// public void testExecute() {
	// 	// (1) setup (arrange, build)
	// 	String actual, expected;
	// 	String input = "0";
	// 	// (2) exercise (act, operate)
	// 	InputStream in = new ByteArrayInputStream(input.getBytes());
	// 	System.setIn(in);
	// 	ndf.execute();
	// 	expected = "Number Difference\nInput N Number :\n\nNumber difference can not be processed";
	// 	actual = outContent.toString();
	// 	// (3) verify (assert, check)
	// 	assertEquals(expected.trim(), actual.trim());
	// }
}
