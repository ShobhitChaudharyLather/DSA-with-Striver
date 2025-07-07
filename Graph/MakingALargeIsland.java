import java.util.*;
class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if(parent[node] != node) {
            parent[node] = findUPar(parent[node]);
        }
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu == pv) return;

        if(size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public int getSize(int node) {
        return size[findUPar(node)];
    }
}

class MakingALargeIsland {
    private static boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;

                for(int i = 0; i < 4; i++) {
                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) continue;

                HashSet<Integer> components = new HashSet<>();
                for(int i = 0; i < 4; i++) {
                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int node = newr * n + newc;
                        components.add(ds.findUPar(node));
                    }
                }

                int sizeTotal = 1; 
                for(int parent : components) {
                    sizeTotal += ds.size[parent];
                }
                mx = Math.max(mx, sizeTotal);
            }
        }

        for(int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size[ds.findUPar(cellNo)]);
        }

        return mx;
    }
    public static void main(String[] args) {
        MakingALargeIsland obj = new MakingALargeIsland();

        int[][] grid1 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("Max connection (grid1): " + obj.largestIsland(grid1)); // Output: 3

        int[][] grid2 = {
            {1, 1},
            {1, 0}
        };
        System.out.println("Max connection (grid2): " + obj.largestIsland(grid2)); // Output: 4
    }
}