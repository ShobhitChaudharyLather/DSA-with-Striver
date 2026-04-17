class Solution {
    public void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[node][j] == 1 && !vis[j]){
                dfs(j, vis, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, vis, isConnected);
                count++;
            }
        }
        return count;
    }
}