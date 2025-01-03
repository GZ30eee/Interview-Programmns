import java.util.HashSet;
import java.util.Scanner;

public class HappyNumberChecker58 {

    // Function to calculate the sum of squares of digits of a number
    public static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Function to check if a number is happy
    public static boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>(); // To store the sequence of numbers

        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n); // Add the current number to the set
            n = sumOfSquares(n); // Update n to the sum of squares of its digits
        }

        return n == 1; // If we reach 1, it's a happy number
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it is a happy number: ");
        int number = scanner.nextInt();

        // Store the sequence for output
        HashSet<Integer> sequence = new HashSet<>();
        int originalNumber = number;

        // Check if the number is happy and build the sequence
        while (number != 1 && !sequence.contains(number)) {
            sequence.add(number);
            number = sumOfSquares(number);
        }

        // Print the result based on whether it's happy or not
        if (number == 1) {
            System.out.print(originalNumber + " is a happy number. Sequence: ");
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println(1); // Include 1 in the sequence
        } else {
            System.out.print(originalNumber + " is not a happy number. Sequence: ");
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println(number); // Print the last repeated number
        }

        scanner.close();
    }
}
