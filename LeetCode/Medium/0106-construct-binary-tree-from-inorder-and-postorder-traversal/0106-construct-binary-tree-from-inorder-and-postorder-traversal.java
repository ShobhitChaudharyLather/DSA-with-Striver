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
    int postIndx;
    Map<Integer,Integer> inorderIndx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndx = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndx.put(inorder[i],i);
        }
        postIndx = postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = postorder[postIndx--];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIndx.get(rootVal);
        root.right = build(inorder,postorder,mid+1,inEnd);
        root.left = build(inorder,postorder,inStart,mid-1);
        return root;
    }
}