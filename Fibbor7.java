import java.util.Scanner;

public class Fibbor7 {
    
    // Recursive function to find the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base case: return n for n = 0 or 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of terms
        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci series up to " + n + " terms:");

        // Print the Fibonacci series using recursion
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println(); // Move to the next line
        scanner.close();
    }
}