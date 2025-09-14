class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            int rodLength = i; // because length = i
            for (int len = 0; len <= n; len++) {
                int notTake = dp[i-1][len];
                int take = 0;
                if (rodLength <= len)
                    take = price[i-1] + dp[i][len - rodLength];
                dp[i][len] = Math.max(notTake, take);
            }
        }
        return dp[n][n];
    }
}