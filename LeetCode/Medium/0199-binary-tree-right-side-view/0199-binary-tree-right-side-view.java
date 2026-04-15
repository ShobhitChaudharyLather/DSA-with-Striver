/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,0,res);
        return res;
    }
    public void helper(TreeNode curr, int level, List<Integer> res){
        if(curr == null) return;
        if(res.size() == level){
            res.add(curr.val);
        }
        helper(curr.right, level + 1, res);
        helper(curr.left, level + 1, res);
    }
}