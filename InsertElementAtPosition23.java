import java.util.Scanner;

public class InsertElementAtPosition23 {

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

        // Input element to insert and position
        System.out.print("Enter the position where you want to insert the element (0 to " + n + "): ");
        int pos = scanner.nextInt();
        
        if (pos < 0 || pos > n) {
            System.out.println("Invalid Position");
            return;
        }

        System.out.print("Enter the element you want to insert: ");
        int elementToInsert = scanner.nextInt();

        // Shift elements to make space for new element
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i]; // Shift elements to right
        }

        // Insert the new element at specified position
        arr[pos] = elementToInsert;

        // Output the modified array
        System.out.println("Array after insertion:");
        for (int i = 0; i <= n; i++) { // Print up to n (original size + 1)
            System.out.print(arr[i] + " ");
        }
        
        scanner.close();
    }
}
