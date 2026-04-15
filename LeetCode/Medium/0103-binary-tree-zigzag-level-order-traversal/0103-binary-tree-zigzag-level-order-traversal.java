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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            LinkedList<Integer> zigzag = new LinkedList<>();
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();
                // left -> right
                if (level % 2 == 0) {
                    zigzag.addLast(curr.val);
                }
                // right -> left
                else{
                    zigzag.addFirst(curr.val);
                }


                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
            res.add(zigzag);
        }
        return res;
    }
}