import java.util.*;

class Dec2Hex
{
	public static String convert(int decimal) {
		return "test";
	}

	public static void main(String args[])
	{
		// Get the number from the first command line argument
		int decimalNum = Integer.parseInt(args[0]);
		
		// Initialize a char array with all hexadecimal values
		char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		int remainder;
		int num = decimalNum;
		
		// Print a start message
		System.out.println("Converting the Decimal Value " + num + " to Hex...");
		
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
		
		// Print the resulting hexadecimal string
		System.out.println("Hexadecimal representation is: " + hexadecimal.toString());
	}
}

