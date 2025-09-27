// User function Template for Java

class Solution {
    
    public static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }
    
    static String postToPre(String post_exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (int i = 0; i< post_exp.length(); i++) {
            char ch = post_exp.charAt(i);

            if (isOperand(ch)) {
                stack.push(Character.toString(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String exp = ch + op1 + op2;
                stack.push(exp);
            }
        }

        return stack.peek();
    }
}
