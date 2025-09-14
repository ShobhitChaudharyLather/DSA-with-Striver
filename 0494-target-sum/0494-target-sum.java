class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((total + target) % 2 != 0 || total < Math.abs(target)) return 0;

        int sum = (total + target) / 2;
        return countSubsets(nums, sum);
    }
    private int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;

        if (nums[0] <= sum) dp[0][nums[0]] += 1;
        if (nums[0] == 0) dp[0][0] = 2; 

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= sum; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (nums[i] <= t) take = dp[i - 1][t - nums[i]];
                dp[i][t] = take + notTake;
            }
        }
        return dp[n - 1][sum];
    }
}