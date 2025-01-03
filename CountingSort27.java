import java.util.Arrays;

public class CountingSort27 {

    // Function to perform Counting Sort
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Find the maximum value in the array
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Create a count array to store the count of each unique value
        int range = max - min + 1; // Range of the input values
        int[] count = new int[range];

        // Store the count of each number
        for (int num : arr) {
            count[num - min]++;
        }

        // Modify the count array to store the cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Output array to hold the sorted values
        int[] output = new int[arr.length];

        // Build the output array using the count array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted values back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}