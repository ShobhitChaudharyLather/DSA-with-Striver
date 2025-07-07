class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findUPar(parent[node]); 
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int n =stones.length;
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        int totalNodes = maxRow + maxCol + 2;
        DisjointSet ds = new DisjointSet(totalNodes);

        boolean[] hasStone = new boolean[totalNodes];

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1; 
            ds.unionBySize(row, col);
            hasStone[row] = true;
            hasStone[col] = true;
        }

        int components = 0;
        for (int i = 0; i < totalNodes; i++) {
            if (hasStone[i] && ds.findUPar(i) == i) {
                components++;
            }
        }

        return n - components; 
    }
    public static void main(String[] args) {
    MostStonesRemoved sol = new MostStonesRemoved();
    int[][] stones = {
        {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
    };
    System.out.println(sol.removeStones(stones));  // Output: 5
}
}
