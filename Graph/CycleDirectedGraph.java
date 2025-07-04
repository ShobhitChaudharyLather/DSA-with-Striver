import java.util.*;

class CycleDirectedGraph {

    // DFS helper to detect cycle using pathVis
    public static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfsCheck(neighbor, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true; // cycle found
            }
        }

        pathVis[node] = false; // backtrack
        return false;
    }
    public static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfsCheck(i, adj, vis, pathVis)) {
                    return true; // cycle detected
                }
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1}  
        };

        boolean hasCycle = isCyclic(V, edges);
        System.out.println("Cycle Detected: " + hasCycle);  // Output: true
    }
}
