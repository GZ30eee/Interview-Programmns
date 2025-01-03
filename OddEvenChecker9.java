import java.util.Scanner;

public class OddEvenChecker9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input a number from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check if the number is odd or even using bitwise AND
        if ((number & 1) == 0) {
            System.out.println(number + " is an Even number.");
        } else {
            System.out.println(number + " is an Odd number.");
        }
        
        scanner.close();
    }
}
