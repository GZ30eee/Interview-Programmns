public class Knapsack87 {
    // Function to solve 0/1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = values.length; // Number of items
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case
                } else if (weights[i - 1] <= w) {
                    // Maximum of including or excluding the current item
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w]; // Exclude current item
                }
            }
        }

        return dp[n][W]; // The last cell contains the maximum value
    }

    public static void main(String[] args) {
        int[] values = {10, 5, 15, 7, 6, 18, 3}; // Values of items
        int[] weights = {2, 3, 5, 7, 1, 4, 1}; // Weights of items
        int W = 15; // Maximum weight capacity

        int maxValue = knapsack(weights, values, W);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
