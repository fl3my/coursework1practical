
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
		char hexChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		int remainder;
		int num = decimalNum;
		
		// Initialize a string to store the hexidecimal output
		String hexadecimal = "";
		
		// Print a start message
		System.out.println("Converting the Decimal Value " + num + " to Hex...");

		// While the number is not equal to 0
		while(num != 0)
		{
			// Get the remainder when the number is divided by 16
			remainder = num % 16;

			// Append the string with approriate string character
			hexadecimal = hexChars[remainder] + hexadecimal;

			// Divide the number by 16
			num = num / 16;
		}
		
		// Print the resulting hexadecimal string
		System.out.println("Hexadecimal representation is: " + hexadecimal);
	}
}

