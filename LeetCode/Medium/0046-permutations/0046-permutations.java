class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>(), res);
        return res;
    }
    public void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                curr.add(nums[i]);
                used[i] = true;
                helper(nums, used, curr, res);
                used[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }
}