public class NonDecreasingArray40 {

    public static boolean checkPossibility(int[] nums) {
        int count = 0; // Count of modifications needed

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                // If more than one modification is needed, return false
                if (count > 1) {
                    return false;
                }

                // Modify nums[i] or nums[i + 1]
                // If i is 0 or nums[i - 1] <= nums[i + 1], modify nums[i]
                // Otherwise, modify nums[i + 1]
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1]; // Modify current element
                } else {
                    nums[i + 1] = nums[i]; // Modify next element
                }
            }
        }

        return true; // If we reach here, it's possible to make it non-decreasing
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3}; // Example input
        boolean result = checkPossibility(nums);
        
        System.out.println("Can the array become non-decreasing? " + result); // Output: true
    }
}
