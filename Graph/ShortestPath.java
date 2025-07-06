import java.util.*;

public class ShortestPath {

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];

                if (d + edgeWt < dist[adjNode]) {
                    dist[adjNode] = d + edgeWt;
                    parent[adjNode] = node;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);      // total weight at the front
        result.addAll(path);      // then the path
        return result;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };

        List<Integer> result = shortestPath(n, m, edges);
        if (result.size() == 1 && result.get(0) == -1) {
            System.out.println("-1");
        } else {
            System.out.println("Shortest path weight: " + result.get(0));
            System.out.print("Path: ");
            for (int i = 1; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }
    }
}
