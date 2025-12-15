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
    Map<Integer, Integer> inorderIndx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndx = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            inorderIndx.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = preorder[preIndx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIndx.get(rootVal);
        root.left = build(preorder,inStart,mid-1);
        root.right = build(preorder,mid+1,inEnd);
        return root;
    }
}