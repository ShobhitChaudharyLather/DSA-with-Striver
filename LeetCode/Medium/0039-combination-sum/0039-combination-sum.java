class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    public void helper(int idx, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || idx == candidates.length){
            return;
        }
        curr.add(candidates[idx]);
        helper(idx, candidates, target - candidates[idx], curr, res);
        curr.remove(curr.size()-1);
        helper(idx + 1, candidates, target, curr, res);
    }
}