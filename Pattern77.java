public class Pattern77 {
    public static boolean recognizesPattern(String str) {
        int n = str.length();
        
        // Check for odd-length strings only
        for (int i = 1; i < n - 1; i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'b') {
                // Check the left and right substrings
                String left = str.substring(0, i);
                String right = str.substring(i + 1);
                
                // Check if the right substring is the reverse of the left substring
                if (isReverse(left, right)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isReverse(String left, String right) {
        int leftLen = left.length();
        int rightLen = right.length();
        
        // They must be of the same length to be reverses
        if (leftLen != rightLen) {
            return false;
        }
        
        // Check if left is the reverse of right
        for (int i = 0; i < leftLen; i++) {
            if (left.charAt(i) != right.charAt(rightLen - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "abacaba"; // Matches pattern: abac(a)aba
        String test2 = "abcba";   // Does not match
        String test3 = "aabbaaa"; // Matches pattern: aab(a)aa
        String test4 = "a";       // Does not match
        String test5 = "abba";    // Matches pattern: ab(b)a

        System.out.println("Does \"" + test1 + "\" match the pattern? " + recognizesPattern(test1));
        System.out.println("Does \"" + test2 + "\" match the pattern? " + recognizesPattern(test2));
        System.out.println("Does \"" + test3 + "\" match the pattern? " + recognizesPattern(test3));
        System.out.println("Does \"" + test4 + "\" match the pattern? " + recognizesPattern(test4));
        System.out.println("Does \"" + test5 + "\" match the pattern? " + recognizesPattern(test5));
    }
}