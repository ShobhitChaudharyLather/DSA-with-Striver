import java.util.*;
class ShortestPathDAG {
    // Topological sort using DFS
    public void topoSort(int node, ArrayList<ArrayList<int[]>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(int[] neighbor : adj.get(node)){
            int v = neighbor[0];
            if(!vis[v]){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Relax edges in topological order
        while(!st.isEmpty()){
            int node = st.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for(int[] neighbor : adj.get(node)){
                    int v = neighbor[0];
                    int wt = neighbor[1];
                    if(dist[node] + wt < dist[v]){
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        ShortestPathDAG sp = new ShortestPathDAG();

        int V = 6, E = 7;
        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {1, 2, 3},
            {4, 2, 2},
            {2, 3, 6},
            {4, 5, 4},
            {5, 3, 1}
        };

        int[] result = sp.shortestPath(V, E, edges);
        System.out.println("Shortest path from node 0:");
        System.out.println(Arrays.toString(result));
    }
}
