import java.util.HashMap;

public class TargetSumWays71 {
    private HashMap<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return calculateWays(nums, 0, 0, target);
    }

    private int calculateWays(int[] nums, int index, int currentSum, int target) {
        // Base case: If we've processed all numbers
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Create a unique key for memoization
        String key = index + "," + currentSum;

        // Check if result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Calculate ways by adding and subtracting the current number
        int add = calculateWays(nums, index + 1, currentSum + nums[index], target);
        int subtract = calculateWays(nums, index + 1, currentSum - nums[index], target);

        // Store result in memoization map
        memo.put(key, add + subtract);

        return add + subtract;
    }

    public static void main(String[] args) {
        TargetSumWays71 tsw = new TargetSumWays71();
        
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        
        int result = tsw.findTargetSumWays(nums, target);
        
        System.out.println("Number of ways to achieve target " + target + ": " + result); // Output: 5
    }
}
