public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int l = 0, r = 0, cnt = 0, minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int[] hash = new int[256];

        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                cnt++;
            }
            hash[s.charAt(r)]--;

            // If all characters of t are matched
            while (cnt == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    cnt--;
                }
                l++;
            }

            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring solution = new MinWindowSubstring();
        
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result);  // Output: "BANC"
    }
}
