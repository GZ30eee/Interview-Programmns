import java.util.Scanner;

public class MaxMinAverage12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number of values
        System.out.print("Enter the number of values (n): ");
        int n = scanner.nextInt();
        
        // Check if n is positive
        if (n <= 0) {
            System.out.println("Please enter a positive integer for n.");
            return;
        }

        // Initialize variables
        int max = Integer.MIN_VALUE; // Smallest possible integer
        int min = Integer.MAX_VALUE; // Largest possible integer
        double sum = 0;

        // Loop to read n values
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();
            
            // Update max and min
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            
            // Update sum
            sum += value;
        }

        // Calculate average
        double average = sum / n;

        // Output results
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}
