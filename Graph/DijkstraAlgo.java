import java.util.*;
// Class to represent a pair of (distance, node)
class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class DijkstraAlgo {
    public static int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});  
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            int d = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWt = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];

                if (d + edgeWt < dist[adjNode]) {
                    dist[adjNode] = d + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 8},
            {1, 4, 6},
            {2, 3, 2},
            {3, 4, 10}
        };
        int src = 0;

        int[] result = dijkstra(V, edges, src);

        System.out.println("Shortest distances from node " + src + ":");
        System.out.println(Arrays.toString(result));
    }
}
