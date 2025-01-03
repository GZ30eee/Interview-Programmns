import java.util.Scanner;

public class OddEvenDigitCounter8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input a number from user
        System.out.print("Enter a number: ");
        long number = scanner.nextLong(); // Use long to accommodate large numbers
        
        int oddCount = 0; // Counter for odd digits
        int evenCount = 0; // Counter for even digits
        
        // Process each digit
        while (number > 0) {
            int digit = (int)(number % 10); // Get the last digit
            
            if (digit % 2 == 0) {
                evenCount++; // Increment even counter
            } else {
                oddCount++; // Increment odd counter
            }
            
            number /= 10; // Remove the last digit
        }

        // Output results
        System.out.println("Total Even Digits: " + evenCount);
        System.out.println("Total Odd Digits: " + oddCount);
        
        scanner.close();
    }
}
