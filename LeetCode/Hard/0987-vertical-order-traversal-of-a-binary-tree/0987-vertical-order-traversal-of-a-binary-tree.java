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
    static class NodeInfo{
        int row;
        int val;
        NodeInfo(int row, int val){
            this.row = row;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //vertical -> (row/level, val)
        TreeMap<Integer,List<NodeInfo>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        //node, col/vertical, row/level
        q.offer(new Object[]{root, 0, 0});

        while(!q.isEmpty()){
            Object [] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int col = (int) arr[1];
            int row = (int) arr[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new NodeInfo(row, node.val));

            if(node.left != null){
                q.offer(new Object[]{node.left, col-1, row+1});
            }
            if(node.right != null){
                q.offer(new Object[]{node.right, col+1, row+1});
            }

        }

        List<List<Integer>> res = new ArrayList<>();
        for(int col : map.keySet()){
            List<NodeInfo> list = map.get(col);
            Collections.sort(list, (a,b)->{
                if (a.row != b.row)
                    return a.row - b.row;
                return a.val - b.val;
            });
            List<Integer> colValues = new ArrayList<>();
            for (NodeInfo n : list)
                colValues.add(n.val);

            res.add(colValues);
        }
        return res;
    }
}