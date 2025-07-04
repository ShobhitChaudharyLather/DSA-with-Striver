import java.util.*;
class TopologicalSort{
    public static void dfs(int node, boolean [] vis,  ArrayList<ArrayList<Integer>> adj, Stack<Integer> s){
        vis[node] =true;
        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                dfs(neighbor, vis, adj, s);
            }
        }
        s.push(node);
    }
    public static List<Integer> topo(int V, int [][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        boolean [] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, adj, s);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        List<Integer> topoOrder = topo(V, edges);
        System.out.println("Topological Sort Order: " + topoOrder);
    }
}