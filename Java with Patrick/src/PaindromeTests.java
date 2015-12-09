import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaindromeTests {
	
	IPalindromeDetector detector = null;

	@Before
	public void setUp() throws Exception {
		detector = new ScottPalindromeDetector();
	}

	@Test
	public void testPanamaNoSpaces() {
		assertTrue(detector.isPalindrome("amanaplanacanalpanama"));
	}

	@Test
	public void testPanama() {
		assertTrue(detector.isPalindrome("a man a plan a canal panama"));
	}

	@Test
	public void testPanamaPerf() {
		for (int i = 0; i < 1000000; i++) {
			detector.isPalindrome("a man a plan a canal panama");
		}
		assertTrue(true);
	}

	@Test
	public void testBogus() {
		assertFalse(detector.isPalindrome("abc"));
	}

	@Test
	public void testAbba() {
		assertTrue(detector.isPalindrome("ABBA"));
	}

	@Test
	public void testIgnoreCase() {
		assertTrue(detector.isPalindrome("ABba"));
	}

	@Test
	public void testNull() {
		assertFalse(detector.isPalindrome(null));
	}

	@Test
	public void testEmpty() {
		assertFalse(detector.isPalindrome(""));
	}

}
