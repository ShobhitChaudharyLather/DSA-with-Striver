// User function Template for Java

class Solution {
    public static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }
    
    static String postToInfix(String exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (isOperand(ch)) {
                stack.push(Character.toString(ch));
            } else { // operator
                String op2 = stack.pop();
                String op1 = stack.pop();
                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }

        return stack.peek();
    }
}
