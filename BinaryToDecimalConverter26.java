import java.util.Scanner;

public class BinaryToDecimalConverter26 {

    // Method to convert binary string to decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1; // Initialize base value (2^0)

        // Process each bit from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char ch = binary.charAt(i);
            if (ch == '1') {
                decimal += base; // Add base value if bit is 1
            }
            base *= 2; // Update base value for next bit
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a binary number: ");
        String binaryNumber = scanner.nextLine();
        
        // Convert and print the decimal representation
        int decimalResult = binaryToDecimal(binaryNumber);
        
        System.out.println("Decimal representation: " + decimalResult);
        
        scanner.close();
    }
}
