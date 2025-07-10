import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKdistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring with at most " + k + " distinct characters: " +
                lengthOfLongestSubstringKDistinct(s, k));
        // Output: 3 ("ece")
    }
}
