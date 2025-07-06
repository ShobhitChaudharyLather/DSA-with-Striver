import java.util.*;

class Pair {
    long first;
    int second;

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class WaysToArriveAtDestination {
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            int wt = road[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        pq.add(new Pair(0L, 0)); // {distance, node}

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long d = curr.first;
            int node = curr.second;

            if (d > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.second;
                long edgeWt = neighbor.first;

                if (d + edgeWt < dist[adjNode]) {
                    dist[adjNode] = d + edgeWt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                } else if (d + edgeWt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int[][] roads1 = {
            {0, 1, 1}, {1, 2, 1}, {0, 2, 2}
        };
        int n1 = 3;
        System.out.println("Test 1 Output: " + countPaths(n1, roads1)); // Expected: 2

       
    }
}
