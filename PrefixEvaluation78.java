import java.util.Stack;

public class PrefixEvaluation78 {
    
    // Function to evaluate a prefix expression
    public static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();
        
        // Scan the expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            
            // If the scanned character is an operand (number)
            if (Character.isDigit(c)) {
                // Push it to the stack
                stack.push(c - '0'); // Convert char to int
            } 
            // If the scanned character is an operator
            else {
                // Pop two elements from the stack
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                // Perform operation based on operator
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }
        
        // The final result will be at the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExpression = "+9*26"; // Example: + 9 * 2 6
        int result = evaluatePrefix(prefixExpression);
        
        System.out.println("Prefix Expression: " + prefixExpression);
        System.out.println("Evaluated Result: " + result); // Output should be 21
    }
}
