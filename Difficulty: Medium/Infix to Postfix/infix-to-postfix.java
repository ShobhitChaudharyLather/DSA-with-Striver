

class Solution {
    public static boolean isOperand(char ch){
        return Character.isLetterOrDigit(ch);
    }
        
        public static int precedence(char ch){
            switch(ch){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }
    
    public static boolean isRightAssociative(char ch) {
        return ch == '^';
    }
    
    public static String infixToPostfix(String s) {
        // code here
        
        Stack<Character> stack= new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(isOperand(ch)){
                postfix.append(ch);
            }
            
            else if(ch=='('){
                stack.push(ch);
            }
            
            else if(ch==')'){
                
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix.append(stack.pop());
                }
                
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
            }
            else{
                
                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       (precedence(ch) < precedence(stack.peek()) ||
                        (precedence(ch) == precedence(stack.peek()) && !isRightAssociative(ch)))) {
                    postfix.append(stack.pop());
                }
                
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
}