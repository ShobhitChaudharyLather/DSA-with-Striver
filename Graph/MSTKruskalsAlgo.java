import java.util.*;

public class MSTKruskalsAlgo {
    static int[] parent;
    static int[] rank;

    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static int kruskalsMST(int V, int[][] edgesInput) {
        
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Convert array to Edge list
        List<Edge> edges = new ArrayList<>();
        for (int[] e : edgesInput) {
            edges.add(new Edge(e[0], e[1], e[2]));
        }

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.wt));

        // Kruskal's algorithm
        int mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                mstWeight += edge.wt;
                mstEdges.add(edge);
                union(edge.u, edge.v);
            }
        }

        // Print MST edges
        System.out.println("MST Edges:");
        for (Edge e : mstEdges) {
            System.out.println(e.u + " - " + e.v + " (weight: " + e.wt + ")");
        }

        return mstWeight;
    }

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        int totalWeight = kruskalsMST(V, edges);
        System.out.println("Total weight of MST: " + totalWeight);
    }
}
