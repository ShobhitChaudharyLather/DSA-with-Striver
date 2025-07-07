import java.util.*;

public class BellmanFordAlgo {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        long[] dist = new long[V];
        Arrays.fill(dist, (long) 1e8);  // A large number representing infinity
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] + wt < dist[v]) {
                return new int[]{ -1 };
            }
        }

        // Convert to int[] for final output
        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            result[i] = (int) dist[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 6},
            {0, 2, 7},
            {1, 2, 8},
            {1, 3, 5},
            {1, 4, -4},
            {2, 3, -3},
            {2, 4, 9},
            {3, 1, -2},
            {4, 0, 2},
            {4, 3, 7}
        };
        int src = 0;

        BellmanFordAlgo obj = new BellmanFordAlgo();
        int[] result = obj.bellmanFord(V, edges, src);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative weight cycle detected");
        } else {
            for (int val : result) {
                System.out.print(val + " ");
            }
        }
    }
}
