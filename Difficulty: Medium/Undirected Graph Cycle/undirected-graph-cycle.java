class Solution {
    public static boolean detectCycle(int src, ArrayList<ArrayList<Integer>>adj, boolean[] vis){
        vis[src]=true;
        Queue<int[]> q =new LinkedList<>();
        q.add(new int []{src,-1});
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int adjNode : adj.get(node)){
                if(!vis[adjNode]){
                    vis[adjNode]=true;
                    q.add(new int[]{adjNode, node});
                }
                else if(parent != adjNode) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(detectCycle(i,adj,vis)) return true;
            }
        }
        return false;
    }
}