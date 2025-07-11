public class LongestSubstringRepeatingCharacters {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxlen = 0, maxFreq = 0;
        int[] hash = new int[26];

        while (r < s.length()) {
            char ch = s.charAt(r);
            hash[ch - 'A']++;
            maxFreq = Math.max(maxFreq, hash[ch - 'A']);

            // Shrink the window if replacements needed > k
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubstringRepeatingCharacters obj = new LongestSubstringRepeatingCharacters();
        String s = "AABABBA";
        int k = 1;
        int result = obj.characterReplacement(s, k);
        System.out.println("Longest valid substring length = " + result); // Output: 4
    }
}
