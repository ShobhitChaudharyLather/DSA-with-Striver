class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), res);
        return res;
    }
    public void helper(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        helper(idx + 1, nums, curr, res);
        curr.remove(curr.size()-1);
        helper(idx + 1, nums, curr, res);
    }
}