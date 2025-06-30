class FloodFill {

    private void dfs(int row, int col,
                     int[][] ans,
                     int[][] image,
                     int newColor,
                     int[] delRow, int[] delCol,
                     int iniColor) {

        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                image[nrow][ncol] == iniColor &&
                ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         ans[i][j] = image[i][j];
        //     }
        // }
        ans = image;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        if (iniColor != newColor) {
            dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        }

        return ans;
    }

    public static void main(String[] args) {
        FloodFill s = new FloodFill();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = s.floodFill(image, sr, sc, newColor);

        System.out.println("Flood Filled Image:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
