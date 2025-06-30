import java.util.*;
class ConnectedComponents{
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u); // remove for directed graph
    }
    public static void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,adj);
            }
        }
    }
    public static void main(String[] args) {
        int n=5, m=3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);

        boolean[] visited = new boolean[n+1];
        int count=0;

        for (int i = 1; i <=n; i++) {
            if(!visited[i]){
                count++;
                dfs(i, visited, adj);
            }
        }
        System.out.println("No. of connected components : "+count);
    }
}