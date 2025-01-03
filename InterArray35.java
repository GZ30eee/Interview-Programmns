import java.util.Arrays;

public class InterArray35 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] intersection = findIntersection(nums1, nums2);
        
        System.out.println("Intersection: " + Arrays.toString(intersection));
    }

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        int maxSize = Math.min(nums1.length, nums2.length);
        int[] tempResult = new int[maxSize];
        int index = 0;

        // Loop through each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            // Check if nums1[i] exists in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    // Add to result if not already added
                    boolean alreadyAdded = false;
                    for (int k = 0; k < index; k++) {
                        if (tempResult[k] == nums1[i]) {
                            alreadyAdded = true;
                            break;
                        }
                    }
                    if (!alreadyAdded) {
                        tempResult[index++] = nums1[i]; // Add the common element
                    }
                    break; // Move to the next element in nums1
                }
            }
        }

        // Create the final result array with the exact size
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = tempResult[i];
        }

        return result;
    }
}