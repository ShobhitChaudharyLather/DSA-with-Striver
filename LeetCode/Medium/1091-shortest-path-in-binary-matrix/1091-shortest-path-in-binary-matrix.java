class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int[][] dir = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});//r, c, dist
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            if(r == n-1 && c == n-1){
                return dist;
            }
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0){
                    q.offer(new int[]{nr, nc, dist + 1});
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
    }
}