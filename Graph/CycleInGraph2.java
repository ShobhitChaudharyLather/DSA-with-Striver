import java.util.*;

public class CycleInGraph2 {

    // Function to detect cycle in an undirected graph using DFS
    public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    if(dfs(adjNode, node, adj, vis)){
                        return true;
                    }
                } else if (adjNode != parent) {
                    return true; // Cycle detected
                }
            }
            return false;
        }

    // Main function to check if graph contains cycle
    public static boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }

        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 1}
        };

        if (isCycle(V, edges)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle found in the graph.");
        }
    }
}