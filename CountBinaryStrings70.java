public class CountBinaryStrings70 {

    public static int countNumbers(int n) {
        // Convert n to binary and find its length
        String binaryString = Integer.toBinaryString(n);
        int length = binaryString.length();

        // Dynamic programming array
        int[] dp = new int[length + 1];
        dp[0] = 1; // Base case for length 0
        dp[1] = 2; // Base case for length 1 ("0", "1")

        // Fill dp array using the relation
        for (int i = 2; i <= length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Count valid numbers
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (binaryString.charAt(length - 1 - i) == '1') {
                count += dp[i]; // Add all combinations with '0' at this position
                if (i > 0 && binaryString.charAt(length - i) == '1') {
                    break; // Stop if we encounter '11'
                }
            }
        }

        return count + 1; // Include the number itself if it doesn't have consecutive ones
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        int result = countNumbers(n);
        System.out.println("Count of numbers from 0 to " + n + " without consecutive ones: " + result);
    }
}
