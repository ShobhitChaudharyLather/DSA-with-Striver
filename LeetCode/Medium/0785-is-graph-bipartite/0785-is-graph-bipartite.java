class Solution {
    public boolean dfs(int node, int[][] graph, int [] color){
        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                color[neighbor] = 1 - color[node];
                if (!dfs(neighbor, graph, color)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                color[i] = 0;
                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}