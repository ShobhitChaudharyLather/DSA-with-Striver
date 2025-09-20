class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c + 2];
        arr[0] = 0;
        arr[c + 1] = n;
        for (int i = 0; i < c; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);

        int[][] dp = new int[c + 2][c + 2];

        for (int len = 2; len < c + 2; len++) {
            for (int i = 0; i + len < c + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            arr[j] - arr[i] + dp[i][k] + dp[k][j]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) dp[i][j] = 0;
            }
        }
        return dp[0][c + 1];
    }
}