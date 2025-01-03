import java.util.Scanner;

public class NoIsPresentArray25 {

    // Recursive function to check if the element is in the array
    public static int isInArray(int[] a, int m) {
        return isInArrayHelper(a, m, 0);
    }

    // Helper function to perform the recursive search
    private static int isInArrayHelper(int[] a, int m, int index) {
        // Base case: if index reaches the length of the array, return 0 (not found)
        if (index >= a.length) {
            return 0; // Element not found
        }
        // Check if the current element matches m
        if (a[index] == m) {
            return 1; // Element found
        }
        // Recursive call for the next element
        return isInArrayHelper(a, m, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] a = new int[n];

        // Input the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Input the element to be searched
        System.out.print("Enter the element to search: ");
        int m = scanner.nextInt();

        // Check if the element is in the array
        if (isInArray(a, m) == 1) {
            System.out.println(m + " is present in the array.");
        } else {
            System.out.println(m + " is not present in the array.");
        }

        scanner.close();
    }
}