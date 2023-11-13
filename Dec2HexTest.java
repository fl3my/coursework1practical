import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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


}
