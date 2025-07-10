import java.util.HashMap;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0, maxLen = 0;

        while (r < n) {
            char ch = s.charAt(r);

            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= l) {
                l = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s));
        // Output: 3
    }
}
