import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class MSTPrimsAlgo {

    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int wt = curr.distance;
            int node = curr.node;

            if (vis[node]) continue;

            vis[node] = true;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i)[0];
                int edgeWeight = adj.get(node).get(i)[1];

                if (!vis[adjNode]) {
                    pq.add(new Pair(edgeWeight, adjNode));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 6;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7}
        };

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int mstWeight = spanningTree(V, E, adj);
        System.out.println("Total weight of MST: " + mstWeight);
    }
}
