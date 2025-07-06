import java.util.*;

class Pair {
    int row, col, dist;

    Pair(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0, 0));
        grid[0][0] = 1; // mark visited

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int dist = curr.dist;
            int row = curr.row;
            int col = curr.col;

            if (row == n - 1 && col == n - 1) return dist;

            for (int i = 0; i < 8; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 0) {
                    q.add(new Pair(dist + 1, newRow, newCol));
                    grid[newRow][newCol] = 1; // mark visited
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println("Shortest path length: " + obj.shortestPathBinaryMatrix(grid));
    }
}
