class Solution {
    public int jump(int[] nums) {
        int maxReach =0, currEnd = 0, jumps =0;
        if(nums.length==1){
            return 0;
        }
        for(int i=0; i<nums.length;i++){
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = maxReach;
            }
            if(currEnd>=nums.length-1){
                break;
            }
        }
        return jumps;
    }
}