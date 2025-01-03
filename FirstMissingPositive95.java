public class FirstMissingPositive95 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its right place
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Identify the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Return the first index where the condition fails
            }
        }

        // If all numbers are in their correct places, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive95 solution = new FirstMissingPositive95();
        
        // Test cases
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0})); // Output: 3
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1})); // Output: 2
    }
}
