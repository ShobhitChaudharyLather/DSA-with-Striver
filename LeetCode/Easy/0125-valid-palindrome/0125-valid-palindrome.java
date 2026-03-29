class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int l = 0;
        int r = sb.length() - 1;
        while(l<r){
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}