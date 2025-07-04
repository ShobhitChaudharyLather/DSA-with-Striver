// Topological sort (Kahn's Algorithm BFS)
import java.util.*;
class TopologicalSortBFS{
    public static List<Integer> topo(int V, int [][] edges){
        // create adjList from edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        // calculate indegree of every node
        int [] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }
        // if indegree is 0 of any node add it to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
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