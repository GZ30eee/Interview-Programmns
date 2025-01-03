public class NextLexicographicalPermutation62 {

    public String nextPermutation(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Find the pivot
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        // If there is no pivot, reverse the entire string
        if (i < 0) {
            reverse(chars, 0, n - 1);
            return new String(chars);
        }

        // Step 2: Find the successor
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap pivot and successor
        swap(chars, i, j);

        // Step 4: Reverse the suffix
        reverse(chars, i + 1, n - 1);

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    public static void main(String[] args) {
        NextLexicographicalPermutation62 solution = new NextLexicographicalPermutation62();
        
        String input = "abc"; // Example input
        String result = solution.nextPermutation(input);
        
        System.out.println("Next lexicographical permutation of " + input + " is: " + result); // Output: acb
    }
}
