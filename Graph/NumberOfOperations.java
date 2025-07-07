public class NumberOfOperations {

    static int[] parent;
    static int[] rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
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

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; 

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int extra = 0;

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            if (find(u) == find(v)) {
                extra++;
            } else {
                union(u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) components++;
        }

        int opsNeeded = components - 1;
        return (extra >= opsNeeded) ? opsNeeded : -1;
    }

    public static void main(String[] args) {
        NumberOfOperations obj = new NumberOfOperations();

        int n1 = 6;
        int[][] connections1 = {
            {0, 1}, {0, 2}, {0, 3}, {1, 2},{1,3}
        };
        int result1 = obj.makeConnected(n1, connections1);
        System.out.println("Test Case 1 : " + result1); // Output: 2

        int n2 = 4;
        int[][] connections2 = {
            {0, 1}, {0, 2}, {1, 2}
        };
        int result2 = obj.makeConnected(n2, connections2);
        System.out.println("Test Case 2 : " + result2); // Output: 1
    }
}
