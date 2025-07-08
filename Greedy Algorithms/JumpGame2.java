
class JumpGame2 {
    public int jump(int[] nums) {
        int maxReach = 0, currEnd = 0, jumps = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = maxReach;
            }
            if (currEnd >= nums.length - 1) {
                break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 obj = new JumpGame2();

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps to reach end: " + obj.jump(nums));
    }
}
