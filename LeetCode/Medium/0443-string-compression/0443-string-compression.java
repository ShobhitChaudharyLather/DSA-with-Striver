class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int k = 0;
        int freq = 0;
        String str = "";
        while(i < n){
            int j = i;
            while(j < n && chars[i] == chars[j]){
                j++;
            }
            freq = j - i;
            chars[k++] = chars[i];
            if(freq > 1){
                String count = Integer.toString(freq);
                for(char ch : count.toCharArray()){
                    chars[k++] = ch;
                }
            }
            i = j;
        }
        return k;
    }
}