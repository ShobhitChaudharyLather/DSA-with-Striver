
import java.util.LinkedList;
import java.util.Queue;

class RottenOranges{
    public static int orangesRotting(int[][] grid){
        int n= grid.length;
        int m= grid[0].length;

        Queue<Pair> q =new LinkedList<>();
        int [][] vis = new int[n][m];
        int cntFresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }

        int time=0;
        int cnt=0;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c= q.peek().col;
            int t = q.peek().time;

            time = Math.max(time,t);
            q.remove();

            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                    q.add(new Pair(nRow, nCol, t+1));
                    vis[nRow][nCol]=2;
                    cnt++;
                }
            }

        }
        return cntFresh==cnt ? time : -1;
    }
    public static void main(String[] args) {
        int [][] grid ={{2,1,1},
                        {1,1,0},
                        {0,1,1}};
        int [][] grid2 ={{2,1,1},
                        {0,1,1},
                        {1,0,1}};
        System.out.println("Time taken to rot all oranges(if possible): "+orangesRotting(grid2));
    }
    public static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}