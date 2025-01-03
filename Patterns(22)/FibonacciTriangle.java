public class FibonacciTriangle {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a + " "); // Print Fibonacci number
                int next = a + b; // Calculate next Fibonacci number
                a = b;
                b = next;
            }
            System.out.println(); // Move to the next line
        }
    }
}

// 0 
// 1 1 
// 2 3 5 
// 8 13 21 34 
// 55 89 144 233 377 