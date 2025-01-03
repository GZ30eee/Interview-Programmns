import java.util.Stack;

public class ExpressionEvaluator67 {
    public int evaluate(String s) {
        Stack<Integer> numbers = new Stack<>();
        @SuppressWarnings("unused")
        Stack<Character> operators = new Stack<>();
        int num = 0;
        char prevOp = '+'; // Assume '+' for the first number

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build the number
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (prevOp == '+') {
                    numbers.push(num);
                } else if (prevOp == '-') {
                    numbers.push(-num);
                } else if (prevOp == '*') {
                    numbers.push(numbers.pop() * num);
                } else if (prevOp == '/') {
                    numbers.push(numbers.pop() / num);
                }
                prevOp = c; // Update the previous operator
                num = 0; // Reset number
            }
        }

        // Sum up all numbers in the stack
        int result = 0;
        while (!numbers.isEmpty()) {
            result += numbers.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        ExpressionEvaluator67 evaluator = new ExpressionEvaluator67();
        
        String expression = "3 + 5 * 2 - 8 / 4"; // Example expression
        int result = evaluator.evaluate(expression);
        
        System.out.println("Result: " + result); // Output: Result: 10
    }
}
