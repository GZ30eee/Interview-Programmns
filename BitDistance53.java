import java.util.Scanner;

public class BitDistance53 {

    // Function to calculate the distance between two numbers
    public static int calculateDistance(int num1, int num2) {
        // Perform XOR operation
        int xorResult = num1 ^ num2;

        // Count the number of 1s in the binary representation of xorResult
        int distance = 0;
        while (xorResult > 0) {
            // Increment distance for each 1 found
            distance += (xorResult & 1); // Check if the least significant bit is 1
            xorResult >>= 1; // Right shift to check the next bit
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take two numbers as input from user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate and display the distance
        int distance = calculateDistance(num1, num2);
        System.out.println("The distance between " + num1 + " and " + num2 + " is: " + distance);

        scanner.close();
    }
}
