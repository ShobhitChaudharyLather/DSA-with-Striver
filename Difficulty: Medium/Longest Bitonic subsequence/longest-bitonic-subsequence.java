
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >=i; j--) {
                if (nums[j] < nums[i] && lds[j] + 1 > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
            }
        }

        return maxLen;
    }
}
