class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int j = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            currSum += arr[i];
            if(i-j+1 > k){
                currSum -= arr[j];
                j++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}