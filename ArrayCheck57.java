public class ArrayCheck57 {

    // Function to check if the array is in ascending order and count occurrences
    public static int checkArray(int[] A, int number) {
        // Check if the array is in ascending order
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return 0; // Not in ascending order
            }
        }

        // Count occurrences of the specified number
        int count = 0;
        for (int num : A) {
            if (num == number) {
                count++;
            }
        }

        // Check if the occurrence is at least 3
        if (count >= 3) {
            return 1; // Conditions satisfied
        } else {
            return 0; // Conditions not satisfied
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] A1 = {1, 1, 1, 2, 2};
        int[] A2 = {1, 1, 1, 3, 3, 3, 3};
        int[] A3 = {2, 2, 2, 1, 1, 1};

        System.out.println(checkArray(A1, 1)); // Output: 0
        System.out.println(checkArray(A2, 3)); // Output: 1
        System.out.println(checkArray(A3, 2)); // Output: 0
    }
}
