import java.util.Scanner;

public class DecimalToBCDConverter15 {

    // Method to convert a single decimal digit to its 4-bit binary equivalent
    public static String decimalDigitToBCD(int digit) {
        // Convert digit to binary and format it as a 4-bit string
        return String.format("%04d", Integer.parseInt(Integer.toBinaryString(digit)));
    }

    // Method to convert a decimal number to BCD
    public static String decimalToBCD(int decimal) {
        StringBuilder bcd = new StringBuilder();
        
        // Extract each digit and convert to BCD
        while (decimal > 0) {
            int digit = decimal % 10; // Get the last digit
            bcd.insert(0, decimalDigitToBCD(digit)); // Convert and prepend to BCD result
            decimal /= 10; // Remove the last digit
        }

        return bcd.toString(); // Return the complete BCD representation
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        
        String bcdResult = decimalToBCD(decimalNumber);
        
        System.out.println("BCD representation: " + bcdResult);
        
        scanner.close();
    }
}
