import java.util.*;
class BridgesInGraph {
    private int timer = 1;

    private void dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;

            if (!vis[it]) {
                dfs(it, node, vis, adj, tin, low, bridges); // 🔥 FIXED here
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it)); // from node to it
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }
    public static void main(String[] args) {
        BridgesInGraph sol = new BridgesInGraph();

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        int n = 4;

        List<List<Integer>> bridges = sol.criticalConnections(n, connections);
        System.out.println("Bridges: " + bridges);
        // Output: [[1, 3]] or [[3, 1]]
    }
}
