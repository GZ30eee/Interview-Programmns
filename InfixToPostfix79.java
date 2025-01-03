import java.util.Stack;

public class InfixToPostfix79 {
    
    // Function to return precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    // Function to perform infix to postfix conversion
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } 
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            } 
            // If the scanned character is ')', pop and add to output until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            } 
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExpression = infixToPostfix(infixExpression);
        
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
