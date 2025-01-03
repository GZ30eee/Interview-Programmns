import java.util.Scanner;

public class Fibboi7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of terms
        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci series up to " + n + " terms:");

        // First two terms
        int a = 0, b = 1;

        // Print the Fibonacci series
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b; // Calculate the next term
            a = b; // Update a to the next term
            b = nextTerm; // Update b to the next term
        }

        System.out.println(); // Move to the next line
        scanner.close();
    }
}