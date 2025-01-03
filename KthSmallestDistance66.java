import java.util.Arrays;

public class KthSmallestDistance66 {
    
    public int findKthSmallestDistance(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        
        // Step 2: Binary search for the k-th smallest distance
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1; // Move right if we have fewer than k pairs
            } else {
                high = mid; // Move left if we have at least k pairs
            }
        }
        
        return low; // The k-th smallest distance
    }

    private int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int left = 0;
        
        // Step 3: Count pairs with distance <= maxDist
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++; // Move left pointer to maintain the condition
            }
            count += right - left; // Count how many pairs can be formed with nums[right]
        }
        
        return count;
    }

    public static void main(String[] args) {
        KthSmallestDistance66 solution = new KthSmallestDistance66();
        
        int[] nums = {1, 3, 1, 2};
        int k = 3;
        
        int result = solution.findKthSmallestDistance(nums, k);
        
        System.out.println("The " + k + "-th smallest distance is: " + result); // Output: 1
    }
}
