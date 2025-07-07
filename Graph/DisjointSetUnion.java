class DisjointSetUnion{
    private static  int[] parent;
    private static int[] size;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by size
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } 
        else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
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

        DisjointSetUnion dsu = new DisjointSetUnion(n);

        // Union friendships
        for (int[] edge : friendships) {
            dsu.union(edge[0], edge[1]);
        }

        // Process queries
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            if (dsu.areConnected(u, v)) {
                System.out.println(u + " and " + v + " are friends.");
            } else {
                System.out.println(u + " and " + v + " are NOT friends.");
            }
        }
    }
}