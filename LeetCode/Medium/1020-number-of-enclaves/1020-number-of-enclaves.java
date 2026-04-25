class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            dfs(grid, i, 0); // left column
            dfs(grid, i, m-1); // right column
        }
        for(int j = 0; j < m; j++){
            dfs(grid, 0, j); // upper row
            dfs(grid, n-1, j); // lower row
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}