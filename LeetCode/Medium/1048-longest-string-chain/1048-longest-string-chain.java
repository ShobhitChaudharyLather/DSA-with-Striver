class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); 

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); 

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    private boolean isPredecessor(String shorter, String longer) {
        if (longer.length() - shorter.length() != 1) return false;

        int i = 0, j = 0;
        boolean skipped = false;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++; j++;
            } else {
                if (skipped) return false; 
                skipped = true;
                j++; 
            }
        }

        return true;
    }
}