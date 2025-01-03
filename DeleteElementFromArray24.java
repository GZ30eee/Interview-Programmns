import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementFromArray24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size and elements
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input element to delete
        System.out.print("Enter the element to delete: ");
        int elementToDelete = scanner.nextInt();

        // Call method to delete element
        int[] newArray = deleteElement(arr, elementToDelete);

        // Print results
        if (newArray != null) {
            System.out.println("Array after deletion: " + Arrays.toString(newArray));
        } else {
            System.out.println("Element is not found.");
        }
        
        scanner.close();
    }

    public static int[] deleteElement(int[] arr, int element) {
        boolean found = false;
        int count = 0;

        // Count occurrences of the element to delete
        for (int num : arr) {
            if (num == element) {
                found = true;
                count++;
            }
        }

        // If element is not found, return null
        if (!found) {
            return null;
        }

        // Create a new array with reduced size
        int[] newArray = new int[arr.length - count];
        
        // Copy elements except the one to be deleted
        int index = 0;
        for (int num : arr) {
            if (num != element) {
                newArray[index++] = num;
            }
        }

        return newArray; // Return the new array
    }
}
