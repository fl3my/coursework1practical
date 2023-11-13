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

	@Test
	public void testConvertValidNumberToHex() {
		assertEquals("2a", dec2hex.convert(42));
	}
}
