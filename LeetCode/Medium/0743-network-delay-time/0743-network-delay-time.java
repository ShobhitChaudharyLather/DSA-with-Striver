class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[]{v, w});
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int w = nei[1];
                if(time + w < dist[next]){
                    dist[next] = time + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}