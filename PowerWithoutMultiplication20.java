import java.util.Scanner;

public class PowerWithoutMultiplication20 {

    // Method to perform repeated addition
    public static int add(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a; // Add 'a' for 'b' times
        }
        return sum;
    }

    // Recursive method to calculate power
    public static int power(int a, int b) {
        if (b == 0) {
            return 1; // Base case: a^0 = 1
        }
        
        // Calculate a^(b-1)
        int partialResult = power(a, b - 1);
        
        // Use repeated addition to calculate a^b
        return add(partialResult, a); // This effectively computes partialResult + ... + partialResult (a times)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the base (a): ");
        int base = scanner.nextInt();
        
        System.out.print("Enter the exponent (b): ");
        int exponent = scanner.nextInt();
        
        int result = power(base, exponent);
        
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
        
        scanner.close();
    }
}
