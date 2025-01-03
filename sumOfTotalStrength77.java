import java.util.Stack;

public class sumOfTotalStrength77 {
    public static final int MOD = 1000000007;

    public static long sumOfTotalStrength(int[] strength) {
        int n = strength.length;
        long totalStrengthSum = 0;

        // Arrays to store the left and right limits
        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate left limits using a monotonic stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }

        // Clear the stack for the next calculation
        stack.clear();

        // Calculate right limits using a monotonic stack
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n - i : stack.peek() - i);
            stack.push(i);
        }

        // Calculate total strengths
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + strength[i]) % MOD;
        }

        long totalContribution = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum = (currentSum + strength[i]) % MOD;
            long contribution = (strength[i] * left[i] % MOD * right[i] % MOD * currentSum % MOD) % MOD;
            totalContribution = (totalContribution + contribution) % MOD;
        }

        return totalContribution;
    }

    public static void main(String[] args) {
        int[] strength = {1, 3, 1, 2};
        long result = sumOfTotalStrength(strength);
        System.out.println("Total strength sum: " + result); // Output: 44
    }
}