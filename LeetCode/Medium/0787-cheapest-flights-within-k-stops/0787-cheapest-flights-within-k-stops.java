class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f : flights){
            int u = f[0];
            int v = f[1];
            int price = f[2];
            adj.get(u).add(new int[]{v,price});
        }
        int [] minCost = new int [n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0}); // node, cost, stops

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if(stops > k){
                continue;
            }
            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int price = nei[1];
                if(cost + price < minCost[next]){
                    minCost[next] = cost + price;
                    q.offer(new int[]{next, minCost[next], stops + 1});
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}