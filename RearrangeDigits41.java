import java.util.Arrays;

public class RearrangeDigits41 {
    public static void main(String[] args) {
        int num = 310;
        int result = rearrangeDigits(num);
        System.out.println(result); // Output: 103
    }

    public static int rearrangeDigits(int num) {
        // Handle negative numbers
        boolean isNegative = num < 0;
        String numStr = Integer.toString(Math.abs(num));
        char[] digits = numStr.toCharArray();

        // Sort the digits
        Arrays.sort(digits);

        // If the smallest digit is '0', find the first non-zero digit
        if (digits[0] == '0') {
            int firstNonZeroIndex = 1;
            while (firstNonZeroIndex < digits.length && digits[firstNonZeroIndex] == '0') {
                firstNonZeroIndex++;
            }
            // If there's a non-zero digit, swap it with the first digit
            if (firstNonZeroIndex < digits.length) {
                char temp = digits[0];
                digits[0] = digits[firstNonZeroIndex];
                digits[firstNonZeroIndex] = temp;
            }
        }

        // Convert the sorted character array back to an integer
        int rearrangedNum = Integer.parseInt(new String(digits));

        // Return the rearranged number with the original sign
        return isNegative ? -rearrangedNum : rearrangedNum;
    }
}