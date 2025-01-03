public class RadixSort21 {
    // Function to get the maximum element from the array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to perform counting sort on the array based on the digit
    public static void countingSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];

        // Initialize count array as 0
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construct the output array
                int i = n - 1;
        while (i >= 0) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            i--;
        }

        // Storing the sorted array in arr[]
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Function to implement Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Apply counting sort to sort elements based on place value
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, arr.length, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        radixSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}