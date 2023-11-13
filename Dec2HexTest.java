import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Dec2HexTest {
	
	public Dec2HexTest() {}

	Dec2Hex dec2hex;

	@Before
	public void setUp() {
		dec2hex = new Dec2Hex();
	}
	
	// Test basic cases
	@Test
	public void testConvertValidNumberToHex() {
		assertEquals("2A", dec2hex.convert(42));
	}
	
	@Test
	public void testConvertZeroToHex() {
		assertEquals("0", dec2hex.convert(0));
	}
	
	// Test edge cases
	@Test
	public void testConvertOneToHex() {
		assertEquals("1", dec2hex.convert(1));
	}

	@Test
	public void testConvertMaxEdgeCaseToHex() {
		assertEquals("FFF", dec2hex.convert(4095));
	}

	@Test
	public void testConvertLargeNumberToHex() {
		assertEquals("FFFF", dec2hex.convert(65535));
	}

	// Test negative numbers
	@Test
	public void testConvertNegativeNumberToHex() {
		assertEquals("-2A", dec2hex.convert(-42));
	}

	// Test the command line input
	@Test
	public void testValidUserInput() {
		// Create command line arg
		String[] args = {"42"};
		Integer result = Dec2Hex.validateInput(args);
		assertEquals(Integer.valueOf(42), result);		
	}

	@Test
	public void testMissingUserInput() {
		String[] args = {};
		Integer result = Dec2Hex.validateInput(args);
		assertNull(result);
	}

	@Test
	public void testStringUserInput() {
		String[] args = {"FourtyTwo"};
		Integer result = Dec2Hex.validateInput(args);
		assertNull(result);
	}


}
