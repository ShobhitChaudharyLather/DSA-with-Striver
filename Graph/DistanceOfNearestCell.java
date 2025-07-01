import java.util.*;

public class DistanceOfNearestCell {
    public static int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0}); // {row, col, distance}
                    vis[i][j] = true;
                }
            }
        }

        // Directions: up, right, down, left
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // BFS Traversal
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];
            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    q.add(new int[]{nRow, nCol, steps + 1});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 0}
        };

        int[][] result = nearest(grid);

        System.out.println("Distance of nearest 1 for each cell:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
