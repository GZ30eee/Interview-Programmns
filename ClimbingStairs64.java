public class ClimbingStairs64 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1; // There's only one way to climb 0 or 1 step
        }

        // Initialize base cases
        int first = 1; // f(0)
        int second = 1; // f(1)
        int ways = 0;

        for (int i = 2; i <= n; i++) {
            ways = first + second; // f(n) = f(n-1) + f(n-2)
            first = second; // Move forward in the sequence
            second = ways; // Update second to current ways
        }

        return ways;
    }

    public static void main(String[] args) {
        ClimbingStairs64 solution = new ClimbingStairs64();
        
        // Test cases
        System.out.println(solution.climbStairs(2)); // Output: 2
        System.out.println(solution.climbStairs(3)); // Output: 3
        System.out.println(solution.climbStairs(4)); // Output: 5
        System.out.println(solution.climbStairs(5)); // Output: 8
    }
}
