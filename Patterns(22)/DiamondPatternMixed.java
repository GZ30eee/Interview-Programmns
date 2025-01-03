public class DiamondPatternMixed {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        // Upper part
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j % 2 == 1) {
                    System.out.print(i + " "); // Print numbers
                } else {
                    System.out.print((char) ('A' + (j - 2)) + " "); // Print letters
                }
            }
            System.out.println(); // Move to the next line
        }
        // Lower part
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j % 2 == 1) {
                    System.out.print(i + " "); // Print numbers
                } else {
                    System.out.print((char) ('A' + (j - 2)) + " "); // Print letters
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}

//     1 
//    2 A 2 
//   3 B 3 C 3 
//  4 D 4 E 4 D 
// 5 E 5 F 5 E 5 
//  4 D 4 E 4 D 
//  3 B 3 C 3 
//    2 A 2 
//     1 