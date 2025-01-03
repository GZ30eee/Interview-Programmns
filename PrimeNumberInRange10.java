import java.util.Scanner;

public class PrimeNumberInRange10 {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        for (int i = 2; i * i <= num; i++) { // Check up to the square root of num
            if (num % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input range from user
        System.out.print("Enter the starting number of the range: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter the ending number of the range: ");
        int end = scanner.nextInt();
        
        System.out.println("Prime numbers between " + start + " and " + end + " are:");

        // Find and print prime numbers in the given range
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " "); // Print the prime number
            }
        }
        
        scanner.close();
    }
}
