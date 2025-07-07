import java.util.*;

public class ArticulationPoint {

    private int timer = 1;

    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low,
                     ArrayList<ArrayList<Integer>> adj, boolean[] isArticulation) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (!vis[it]) {
                dfs(it, node, vis, tin, low, adj, isArticulation);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && parent != -1) {
                    isArticulation[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (parent == -1 && child > 1) {
            isArticulation[node] = true;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] isArticulation = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, adj, isArticulation);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                res.add(i);
            }
        }

        if (res.isEmpty()) res.add(-1); 
        return res;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        ArticulationPoint obj = new ArticulationPoint();
        ArrayList<Integer> result = obj.articulationPoints(V, adj);

        System.out.println("Articulation Points: " + result);
    }
}
