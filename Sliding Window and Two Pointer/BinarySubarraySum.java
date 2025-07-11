public class BinarySubarraySum {
    // subarrays with sum <= goal
    public int sumLessOrEqual(int[] nums, int goal) {
        int l = 0, r = 0, sum = 0, cnt = 0;
        if (goal < 0) return 0; 

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            cnt += (r - l + 1);
            r++;
        }

        return cnt;
    }

    // subarrays with exact sum == goal
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sumLessOrEqual(nums, goal) - sumLessOrEqual(nums, goal - 1);
    }

    public static void main(String[] args) {
        BinarySubarraySum obj = new BinarySubarraySum();

        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        int result = obj.numSubarraysWithSum(nums, goal);
        System.out.println("Number of subarrays : " + result);  // Expected: 4
    }
}
