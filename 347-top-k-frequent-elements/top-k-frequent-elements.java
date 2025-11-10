class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );
        for(int key : freq.keySet()){
            heap.add(new int[]{key,freq.get(key)});
            if(heap.size()>k) heap.poll();
        }
        int [] res = new int[k];
        int i = 0;
        while(!heap.isEmpty()){
            res[i++] = heap.poll()[0];
        }
        return res;
    }
}