public class NthDigitFinder69 {
    public int findNthDigit(int n) {
        // Step 1: Determine the length of the number
        long len = 1; // Current length of numbers (1 for single-digit numbers)
        long count = 9; // Count of numbers with current length
        long start = 1; // Starting number for current length

        // Step 2: Find the range in which n falls
        while (n > len * count) {
            n -= len * count; // Reduce n by the total digits in this range
            len++; // Move to next length
            count *= 10; // Update count for next length (10, 100, ...)
            start *= 10; // Update start for next length (1, 10, ...)
        }

        // Step 3: Find the actual number that contains the nth digit
        // The number is found by moving forward from 'start'
        long num = start + (n - 1) / len; // Find the exact number
        String numStr = Long.toString(num); // Convert to string to access digits

        // Step 4: Find the specific digit we need
        return Character.getNumericValue(numStr.charAt((int)((n - 1) % len))); // Return specific digit
    }

    public static void main(String[] args) {
        NthDigitFinder69 solution = new NthDigitFinder69();
        
        // Test case
        int n = 9;
        int result = solution.findNthDigit(n);
        
        // Print result
        System.out.println(result); // Output: 0
    }
}
