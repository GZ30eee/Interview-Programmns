public class Box55 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n + 1];
        return dfs(boxes, 0, n - 1, 0, dp);
    }

    private int dfs(int[] boxes, int l, int r, int k, int[][][] dp) {
        if (l > r) return 0; // No boxes left
        if (dp[l][r][k] > 0) return dp[l][r][k]; // Return memoized result

        // Merge adjacent boxes of the same color
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++; // Increase k for each adjacent box of the same color
        }

        // Calculate the points for removing boxes from l to r
        int points = (k + 1) * (k + 1) + dfs(boxes, l, r - 1, 0, dp);

        // Try to find the maximum points by merging with other boxes
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                points = Math.max(points, dfs(boxes, l, i, k + 1, dp) + dfs(boxes, i + 1, r - 1, 0, dp));
            }
        }

        dp[l][r][k] = points; // Memoize the result
        return points;
    }

    public static void main(String[] args) {
        BoxRemoval boxRemoval = new BoxRemoval();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        int result = boxRemoval.removeBoxes(boxes);
        System.out.println("Maximum points: " + result); // Output: 23
    }
}