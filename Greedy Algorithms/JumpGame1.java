
public class JumpGame1{

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        int lastIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= lastIndex) return true;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 0, 4};
        boolean result = canJump(nums);
        System.out.println("Can reach the end: " + result);
    }
}
