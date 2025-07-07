public class DisjointSet {
    private static  int[] parent;
    private static int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public static void union(int x, int y) {
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

    // Check if two nodes are in the same set
    public static boolean areConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] friendships = {
            {0, 1},
            {1, 2},
            {3, 4}
        };

        int[][] queries = {
            {0, 2},  // yes
            {1, 3},  // no
            {3, 4},  // yes
            {2, 5}   // no
        };


        // Union friendships
        for (int[] edge : friendships) {
            union(edge[0], edge[1]);
        }

        // Process queries
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            if (areConnected(u, v)) {
                System.out.println(u + " and " + v + " are friends.");
            } else {
                System.out.println(u + " and " + v + " are NOT friends.");
            }
        }
    }

}
