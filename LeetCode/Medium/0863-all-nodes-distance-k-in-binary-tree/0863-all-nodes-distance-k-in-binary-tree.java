/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode node : q) ans.add(node.val);
                return ans;
            }

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode p = parent.get(curr);
                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    q.offer(p);
                }
            }
            dist++;
        }

        return new ArrayList<>();
    }
    private void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}