public class GraphAdjMatrix {
    static int[][] adj;
    
    static void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1; // Remove this line if it's a directed graph
    }

    public static void main(String[] args) {
        int N = 3; 
        adj = new int[N + 1][N + 1]; 

        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(1, 3);

        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
