/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        currPath(root,curr,res);
        return res;
    }
    public static void currPath(Node node, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        curr.add(node.data);
        if(node.left == null && node.right == null){
            res.add(new ArrayList<>(curr));
        }
        else{
            if(node.left != null){
                currPath(node.left,curr,res);
            }
            if(node.right != null){
                currPath(node.right,curr,res);
            }
        }
        curr.remove(curr.size()-1);
    }
}