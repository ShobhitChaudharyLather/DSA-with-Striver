import java.util.*;
class BFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u); // remove for directed graph
    }
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited){
        Queue<Integer> q= new LinkedList<>();
        q.add(node);
        visited[node]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr +" ");
            for(int neighbor : adj.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                }
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
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 4, 5);
        addEdge(adj, 7, 5);

        boolean[] visited = new boolean[n+1];
       
        System.out.print("BFS : ");
        bfs(1, adj, visited);
    }
}