class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxLen = 0;
        while(r < n){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch) > 1){
                char left = s.charAt(l);
                map.put(left, map.get(left)-1);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}