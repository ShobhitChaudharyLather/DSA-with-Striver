public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                low--;   // treat '*' as ')'
                high++;  // or treat '*' as '('
            }

            if (high < 0) return false; 
            if(low<0) low=0;
        }

        return low == 0; 
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println("Is valid? " + checkValidString(s));
    }
}
