public class MixedPattern {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 1) {
                    System.out.print(j + " "); // Print numbers
                } else {
                    System.out.print((char) ('A' + (j - 1)) + " "); // Print letters
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}

// 1 
// 1 A 
// 1 A 3 
// 1 A 3 B 
// 1 A 3 B 5 