import java.util.Scanner;

public class IntegerSquareRoot52 {

    // Recursive function to compute integer square root
    public static int integerSqrt(int n) {
        // Base case
        if (n < 2) {
            return n; // Return n itself for 0 and 1
        }

        // Recursive call
        int i = integerSqrt(n / 4);

        // Check if (2 * i)^2 <= n < (2 * i + 1)^2
        if ((2 * i) * (2 * i) <= n && n < (2 * i + 1) * (2 * i + 1)) {
            return 2 * i; // Return 2 * i if it satisfies the condition
        } else {
            return 2 * i + 1; // Otherwise return 2 * i + 1
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        
        int result = integerSqrt(number);
        
        System.out.println("The integer square root of " + number + " is: " + result);
        
        scanner.close();
    }
}
