import java.util.*;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        // Add all boundary 1s to the queue and mark them visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new int[] { i, j });
                        vis[i][j] = true;
                    }
                }
            }
        }

        int[] delR = { -1, 0, 1, 0 };
        int[] delC = { 0, 1, 0, -1 };

        // BFS to mark all land cells connected to boundary
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int nRow = row + delR[i];
                int nCol = col + delC[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                    q.add(new int[] { nRow, nCol });
                    vis[nRow][nCol] = true;
                }
            }
        }

        // Count unvisited land cells
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfEnclaves obj = new NumberOfEnclaves();

        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        int result = obj.numEnclaves(grid);
        System.out.println("Number of Enclaves: " + result);
    }
}
