public class RotateArray39 {

    // Function to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array to the right by k steps
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return; // Handle empty array case

        // Normalize k to avoid unnecessary rotations
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // Example input
        int k = 3;

        rotate(nums, k);
        
        // Output the rotated array
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
