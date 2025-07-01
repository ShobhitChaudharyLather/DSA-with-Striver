import java.util.*;

public class CycleInGraph {

    // Function to detect cycle in an undirected graph using BFS
    public static boolean detectCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1}); // {currentNode, parentNode}

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new int[]{adjNode, node});
                } else if (parent != adjNode) {
                    return true; // Cycle detected
                }
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
                if (detectCycle(i, V, adj, vis)) {
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
