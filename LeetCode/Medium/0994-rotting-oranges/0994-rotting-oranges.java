class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            time = Math.max(time, t);
            for(int[] d : directions){
                int newR = r + d[0];
                int newC = c + d[1];

                if(newR >=0 && newR < row && newC >=0 && newC < col && grid[newR][newC] == 1){
                    grid[newR][newC] = 2;
                    fresh--;
                    q.offer(new int[]{newR, newC, t + 1});
                }
            }
            
        }
        return fresh == 0 ? time : -1;
    }
}