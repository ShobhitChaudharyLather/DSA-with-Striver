import java.util.*;

public class NumberOfDistinctIslands {

    private static void dfs(int row, int col, boolean[][] vis, int[][] grid,
                     ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = true;
        vec.add(toString(row - row0, col - col0));

        int n = grid.length;
        int m = grid[0].length;
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delR[i];
            int nCol = col + delC[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, vis, grid, vec, row0, col0);
            }
        }
    }

    private static  String toString(int r, int c) {
        return r + " " + c;
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }

    // Main method to run the code
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0}
        };

        int result = countDistinctIslands(grid);
        System.out.println("Number of distinct islands: " + result);
    }
}
