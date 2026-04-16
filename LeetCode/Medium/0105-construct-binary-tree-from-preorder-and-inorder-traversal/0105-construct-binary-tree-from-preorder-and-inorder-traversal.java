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
    int preIndx = 0;
    Map<Integer, Integer> inOrderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIdx = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrderIdx.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = preorder[preIndx++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndx = inOrderIdx.get(rootVal);
        root.left = helper(preorder, inStart, rootIndx - 1);
        root.right = helper(preorder, rootIndx + 1, inEnd);
        return root;
    }
}