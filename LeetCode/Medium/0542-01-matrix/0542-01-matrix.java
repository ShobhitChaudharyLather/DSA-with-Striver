class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for(int[] dir : directions){
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n){
                    if(dist[ni][nj] > dist[i][j] + 1){
                        dist[ni][nj] = dist[i][j] + 1;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return dist;
    }
}