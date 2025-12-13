/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static class Pair {
            Node node;
            int hd;
            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            map.put(hd, curr.data);

            if (curr.left != null) {
                q.offer(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                q.offer(new Pair(curr.right, hd + 1));
            }
        }
        
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}