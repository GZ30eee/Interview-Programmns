import java.util.Scanner;

public class MatrixMultiplication13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions for the first matrix
        System.out.print("Enter number of rows for first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter number of columns for first matrix: ");
        int cols1 = scanner.nextInt();

        // Input dimensions for the second matrix
        System.out.print("Enter number of rows for second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter number of columns for second matrix: ");
        int cols2 = scanner.nextInt();

        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }

        // Initialize matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] resultMatrix = new int[rows1][cols2];

        // Input values for the first matrix
        System.out.println("Enter values for first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input values for the second matrix
        System.out.println("Enter values for second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Perform multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                resultMatrix[i][j] = 0; // Initialize result cell
                for (int k = 0; k < cols1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j]; // Multiply and accumulate
                }
            }
        }

        // Output the resulting matrix
        System.out.println("Resulting Matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }

        scanner.close();
    }
}
