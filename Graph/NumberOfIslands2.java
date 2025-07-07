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
}

public class NumberOfIslands2 {

    private static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int[] op : operators) {
            int row = op[0];
            int col = op[1];

            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int adjr = row + dr[i];
                int adjc = col + dc[i];

                if (isValid(adjr, adjc, n, m) && vis[adjr][adjc] == 1) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = adjr * m + adjc;

                    if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfIslands2 obj = new NumberOfIslands2();

        int n = 4, m = 5;
        int[][] operators = {
            {1, 1}, {0, 1}, {3, 3}, {3, 4}
        };

        List<Integer> result = obj.numOfIslands(n, m, operators);
        System.out.println("Islands after each operation: " + result);
    }
}
