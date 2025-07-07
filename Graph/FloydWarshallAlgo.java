
public class FloydWarshallAlgo {

    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        // cost to reach a node itself
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != 100000000 && dist[k][j] != 100000000) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = 100000000;
        int[][] matrix = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        FloydWarshallAlgo obj = new FloydWarshallAlgo();
        obj.floydWarshall(matrix);

        System.out.println("All pairs shortest path matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == INF)
                    System.out.print("INF ");
                else
                    System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
