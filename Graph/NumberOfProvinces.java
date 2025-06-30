
class NumberOfProvinces {

    public static void dfs(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, visited, isConnected);
            }
        }
    }

    public static int numProvinces(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, isConnected);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println("No. of provinces (connected components): " + numProvinces(isConnected));
    }
}
