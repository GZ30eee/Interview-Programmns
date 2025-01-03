public class NumberPyramid2 {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " "); // Print the current row number
            }
            System.out.println(); // Move to the next line
        }
    }
}

//      1 
//     2 2 
//    3 3 3 
//   4 4 4 4 
//  5 5 5 5 5 