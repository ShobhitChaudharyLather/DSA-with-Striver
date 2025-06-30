import java.util.*;
class DFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u); // remove for directed graph
    }
    public static void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        System.out.print(node +" ");
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,adj);
            }
        }
    }
    public static void main(String[] args) {
        int n=8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);
        addEdge(adj, 3, 7);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 8);
        addEdge(adj, 7, 8);

        boolean[] visited = new boolean[n+1];
       
        System.out.print("DFS : ");
        dfs(1, visited, adj);
    }
}