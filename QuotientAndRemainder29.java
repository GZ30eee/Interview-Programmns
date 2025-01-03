import java.util.Scanner;

public class QuotientAndRemainder29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter the bigger number (dividend): ");
        int dividend = scanner.nextInt();
        
        System.out.print("Enter the smaller number (divisor): ");
        int divisor = scanner.nextInt();
        
        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        // Calculate quotient and remainder
        int quotient = 0;
        int remainder = dividend;

        // Repeated subtraction to find quotient and remainder
        while (remainder >= divisor) {
            remainder -= divisor; // Subtract divisor from remainder
            quotient++; // Increment quotient
        }

        // Output results
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
        
        scanner.close();
    }
}
