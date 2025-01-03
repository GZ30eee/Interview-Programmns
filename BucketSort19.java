import java.util.ArrayList;
import java.util.Collections;

public class BucketSort19 {
    
    // Function to perform Bucket Sort
    public static void bucketSort(float[] arr) {
        // Create empty buckets
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute input array values into buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Assuming arr[i] is in range [0, 1)
            buckets[bucketIndex].add(num);
        }

        // Sort individual buckets and concatenate
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket); // Sort the individual bucket
            for (float num : bucket) {
                arr[index++] = num; // Concatenate sorted buckets into arr
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.12f, 0.24f, 0.53f, 0.51f, 0.43f};

        System.out.println("Original array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        bucketSort(arr);

        System.out.println("Sorted array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}