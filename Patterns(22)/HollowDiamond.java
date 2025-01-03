public class HollowDiamond {
    public static void main(String[] args) {
        int n = 5; // Number of rows for half diamond
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*"); // Print stars
                } else {
                    System.out.print(" "); // Print spaces
                }
            }
            System.out.println(); // Move to the next line
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" "); // Print spaces
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*"); // Print stars
                } else {
                    System.out.print(" "); // Print spaces
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}

//     *    
//    * *   
//   *   *  
//  *     * 
// *       *
//  *     * 
//   *   *  
//    * *   
//     *    