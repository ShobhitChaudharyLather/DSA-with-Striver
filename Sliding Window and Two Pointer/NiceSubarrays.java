public class NiceSubarrays {
    public int sumLessOrEqual(int[] nums, int goal) {
        int l = 0, r = 0, sum = 0, cnt = 0;
        if (goal < 0) return 0;

        while (r < nums.length) {
            sum += nums[r] % 2; // 1 if odd, 0 if even

            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }

            cnt += (r - l + 1); 
            r++;
        }

        return cnt;
    }

    //subarrays with exactly k odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        return sumLessOrEqual(nums, k) - sumLessOrEqual(nums, k - 1);
    }

    public static void main(String[] args) {
        NiceSubarrays obj = new NiceSubarrays();

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = obj.numberOfSubarrays(nums, k);
        System.out.println("Number of subarrays with " + k + " odd numbers = " + result);  // Expected: 2
    }
}
