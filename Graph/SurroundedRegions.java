public class SurroundedRegions {

    public static void dfs(int row, int col, int[][] vis, char[][] board) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delR[i];
            int nCol = col + delC[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, board);
            }
        }
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        // First row and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board);
            }
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board);
            }
        }

        // First col and last col
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board);
            }
        }

        // Replace all unvisited 'O's with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        System.out.println("Original Board:");
        printBoard(board);

        solve(board);

        System.out.println("\nBoard After Solving:");
        printBoard(board);
    }
}
