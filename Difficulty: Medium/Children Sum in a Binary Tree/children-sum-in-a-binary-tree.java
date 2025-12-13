/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int left = (root.left != null) ? root.left.data : 0;
        int right = (root.right != null) ? root.right.data : 0;
        if(root.data != left + right) return false;
        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}