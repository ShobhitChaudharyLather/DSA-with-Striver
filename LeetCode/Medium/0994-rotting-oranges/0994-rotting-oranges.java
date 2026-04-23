class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue <int[]> q= new LinkedList<>();
        int fresh=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.offer(new int[]{r,c,0});
                }
                else if(grid[r][c]==1){
                    fresh++;
                }
            }
        }
        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        int time=0;
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int r=curr[0], c=curr[1], t=curr[2];
            time=Math.max(time,t);
            for(int[]dir:direction){
                int newR= r + dir[0];
                int newC= c + dir[1];
                if(newR>=0 && newR<rows && newC>=0 && newC<cols && grid[newR][newC]==1){
                    grid[newR][newC]=2;
                    fresh--;
                    q.offer(new int[]{newR,newC,t+1});
                }
            }
        }
        return fresh==0 ? time : -1;
    }
}