class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean [] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, -1, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int src, int parent, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;
        
        for(int neigh : adj.get(src)){
            if(!vis[neigh]){
                if(dfs(neigh, src, adj, vis)){
                    return true;
                }
            }
            else if(neigh != parent){
                return true;
            }
        }
        return false;
    }
}