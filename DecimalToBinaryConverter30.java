import java.util.Scanner;

public class DecimalToBinaryConverter30 {

    // Method to convert decimal to binary
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0"; // Handle case for zero
        }

        StringBuilder binary = new StringBuilder(); // Use StringBuilder for efficiency

        while (decimal > 0) {
            int remainder = decimal % 2; // Get remainder
            binary.append(remainder); // Append remainder to binary string
            decimal /= 2; // Update decimal number
        }

        return binary.reverse().toString(); // Reverse and return the result
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        
        String binaryResult = decimalToBinary(decimalNumber);
        
        System.out.println("Binary representation: " + binaryResult);
        
        scanner.close();
    }
}
