public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0, l = 0, r = 0, zeros = 0;
        int n = nums.length;

        while (r < n) {
            if (nums[r] == 0) zeros++;

            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int k = 2;

        int result = longestOnes(nums, k);
        System.out.println("Maximum length of subarray with at most " + k + " zeros flipped: " + result);
        // Expected Output: 7
    }
}
