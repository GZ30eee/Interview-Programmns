public class AlphabetNumberPyramid {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print((char) ('A' + j - 1) + " "); // Print letters
                } else {
                    System.out.print(j + " "); // Print numbers
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}

//     1 
//    A B 
//   1 2 3 
//  D E F G 
// 1 2 3 4 5 