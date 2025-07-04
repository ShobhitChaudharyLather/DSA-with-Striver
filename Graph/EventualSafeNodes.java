import java.util.*;
class EventualSafeNodes{
    public static  boolean dfsCheck(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for (int neighbor : graph[node]) {
            if (!vis[neighbor]) {
                if (dfsCheck(neighbor, graph, vis, pathVis, check)) {
                    return true; // cycle detected
                }
            } else if (pathVis[neighbor]) {
                return true; // back edge found -> cycle
            }
        }

        pathVis[node] = false;   // backtrack
        check[node] = true;      // no cycle from this node => safe
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println("Safe Nodes: " + safeNodes);
    }
}