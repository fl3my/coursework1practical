import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.io.IOException;

class Dec2Hex
{
	private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

	public static void main(String[] args) throws IOException
	{
		// Read in the logging properties file
		LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
	 
		Integer inputNum = validateInput(args);

		if (inputNum != null) {
			// Print a start message using a logger
			logger.info(String.format("Converting the Decimal Value %d to Hex...", inputNum));
					
			String hexadecimal = Dec2Hex.convert(inputNum);

			// Print the resulting hexadecimal string
			logger.info(String.format("Hexadecimal representation is: %s", hexadecimal));
		}
	}
	
	/** 
	 * Convert the command line input value to an integer or return null if invalid
	 * */
	public static Integer validateInput(String[] args) {
		// Check if there are cmd args
		if (args.length == 0) {
			logger.info("Usage: java Dec2Hex <integer>");
			return null;
		}

		// Get the first command line arg
		String inputStr = args[0];

		try {
			// Parse input as an int
			return Integer.parseInt(inputStr);
		} catch (NumberFormatException e) {
			//Handle a non integer input
			logger.severe("Error: input is not a valid integer");
			return null;
		}
	
		
	}
	
	/**
	 * Convert a integer into a positive or negative hexadecimal
	 * */
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
}

