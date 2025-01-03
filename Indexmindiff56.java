public class Indexmindiff56 {
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];

        // Calculate prefix sums
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long minDiff = Long.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < n; i++) {
            // Calculate average of the first i + 1 elements
            long leftSum = prefixSum[i];
            int leftCount = i + 1;
            long leftAvg = leftSum / leftCount;

            // Calculate average of the last n - i - 1 elements
            long rightSum = (i == n - 1) ? 0 : (prefixSum[n - 1] - leftSum);
            int rightCount = n - i - 1;
            long rightAvg = (rightCount == 0) ? 0 : rightSum / rightCount;

            // Calculate the absolute difference
            long diff = Math.abs(leftAvg - rightAvg);

            // Update minimum difference and index
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 9, 5, 3};
        int result = minimumAverageDifference(nums);
        System.out.println("Index with minimum average difference: " + result); // Output: 3
    }
}