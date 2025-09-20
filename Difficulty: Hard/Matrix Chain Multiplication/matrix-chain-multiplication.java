class Solution {
    public static int solve(int i, int j, int [] arr, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + solve(i,k,arr,dp) + solve(k+1,j,arr,dp);
            if(steps < mini) mini = steps;
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }
        return solve(1,n-1,arr,dp);
    }
}