import java.util.*;

public class BipartiteGraphBFS {

    public boolean check(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraphBFS obj = new BipartiteGraphBFS();

        // Sample bipartite graph
        int[][] graph1 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        // Sample non-bipartite graph (contains odd cycle)
        int[][] graph2 = {
            {1, 2},
            {0, 2},
            {0, 1}
        };

        System.out.println("Graph1 is Bipartite: " + obj.isBipartite(graph1)); // true
        System.out.println("Graph2 is Bipartite: " + obj.isBipartite(graph2)); // false
    }
}
