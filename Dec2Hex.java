import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.io.IOException;

class Dec2Hex
{
	public static String convert(int decimalNum) {
		
		// Handle if input is 0
		if (decimalNum == 0) {
			return "0";
		}

		// Initialize a char array with all hexadecimal values
		char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		int remainder;

		// Work with only whole numbers
		int num = Math.abs(decimalNum);
		
		// Create an empty string builder object
		StringBuilder hexadecimal = new StringBuilder();

		// While the number is not equal to 0
		while(num != 0)
		{
			// Get the remainder when the number is divided by 16
			remainder = num % 16;

			// Insert the hex character to the first place in the string
			hexadecimal.insert(0, hexChars[remainder]);

			// Divide the number by 16
			num = num / 16;
		}

		// Add a negative symbol back into the string
		if (decimalNum < 0) {
			hexadecimal.insert(0, "-");
		}

		return hexadecimal.toString();
	}

	public static void main(String args[]) throws IOException
	{
		// Read in the logging properties file
		LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
		
		// Create a logger
		Logger logger = Logger.getLogger(Dec2Hex.class.getName());

		// Get the number from the first command line argument
		int decimalNum = Integer.parseInt(args[0]);
	
		// Print a start message using a logger
		logger.info(String.format("Converting the Decimal Value %d to Hex...", decimalNum));
		
		String hexadecimal = Dec2Hex.convert(decimalNum);

		// Print the resulting hexadecimal string
		logger.info(String.format("Hexadecimal representation is: %s", hexadecimal.toString()));
	}
}

