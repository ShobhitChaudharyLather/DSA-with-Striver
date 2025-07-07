
public class CityWithSmallestNeighbors {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Step 1: Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Step 2: Populate direct edge weights (undirected)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Step 3: Floyd-Warshall Algorithm to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Step 4: Find the city with minimum reachable cities within threshold
        int minCount = n;
        int cityNumber = -1;

        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adj = 0; adj < n; adj++) {
                if (dist[city][adj] <= distanceThreshold) {
                    count++;
                }
            }

            // Prefer higher-numbered city in case of tie
            if (count <= minCount) {
                minCount = count;
                cityNumber = city;
            }
        }

        return cityNumber;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1, 3},
            {1, 2, 1},
            {2, 3, 4},
            {0, 3, 7}
        };
        int distanceThreshold = 4;

        CityWithSmallestNeighbors solver = new CityWithSmallestNeighbors();
        int result = solver.findTheCity(n, edges, distanceThreshold);
        System.out.println("City with the smallest number of neighbors within threshold: " + result);
    }
}
