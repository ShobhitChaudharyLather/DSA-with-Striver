// User function Template for Java

class Solution {
    
    public static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }
    
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            if (isOperand(ch)) {
                stack.push(Character.toString(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = op1 + op2 + ch;
                stack.push(exp);
            }
        }

        return stack.peek();
    }
}
