public class PerfectSquares68 {
    public int numSquares(int n) {
        // Create a DP array to store the minimum number of perfect squares for each value up to n
        int[] dp = new int[n + 1];
        
        // Initialize the DP array with a maximum value (infinity)
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: 0 perfect squares are needed to sum to 0
        dp[0] = 0;

        // Iterate through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check for all perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        // The last element in the dp array will hold the result for n
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares68 solution = new PerfectSquares68();
        
        // Test cases
        System.out.println(solution.numSquares(12)); // Output: 3
        System.out.println(solution.numSquares(13)); // Output: 2
    }
}
