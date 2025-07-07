import java.util.*;
class StronglyConnectedComponents {
    private void dfs1(int node, boolean [] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfs1(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    private void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for (Integer it : adjT.get(node)) {
            if (!vis[it]) {
                dfs2(it, vis, adjT);
            }
        }
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

       
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs1(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i); 
            }
        }

        Arrays.fill(vis, false);
        int scc = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                scc++;
                dfs2(node, vis, adjT);
            }
        }

       return scc;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        StronglyConnectedComponents sol = new StronglyConnectedComponents();
        int result = sol.kosaraju(adj);
        System.out.println("SCC Count: " + result); // Output: 3
    }
}