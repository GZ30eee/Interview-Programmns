public class PalindromicNumberPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            int start = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(start + " ");
                start--;
            }
            start = 2;
            for (int j = 1; j < i; j++) {
                System.out.print(start + " ");
                start++;
            }
            System.out.println();
        }
    }
}


//         1 
//       2 1 2 
//     3 2 1 2 3 
//   4 3 2 1 2 3 4 
// 5 4 3 2 1 2 3 4 5