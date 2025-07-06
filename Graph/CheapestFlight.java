import java.util.*;

public class CheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            adj.get(u).add(new int[]{v, price});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});  // node, cost, stops

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k) continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];

                if (cost + price < minCost[nextNode]) {
                    minCost[nextNode] = cost + price;
                    q.offer(new int[]{nextNode, cost + price, stops + 1});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 3, 500}
        };

        int cheapestPrice = findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + cheapestPrice);
    }
}
