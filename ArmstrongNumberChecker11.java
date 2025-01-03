import java.util.Scanner;

public class ArmstrongNumberChecker11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input a number from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check if the number is an Armstrong number
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
        scanner.close();
    }

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = countDigits(num);

        // Calculate the sum of each digit raised to the power of digits
        while (num > 0) {
            int digit = num % 10; // Get last digit
            sum += Math.pow(digit, digits); // Raise digit to power of digits and add to sum
            num /= 10; // Remove last digit
        }

        // Compare sum with original number
        return sum == originalNum;
    }

    // Method to count the number of digits in a number
    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10; // Remove last digit
            count++;   // Increment count
        }
        return count;
    }
}
