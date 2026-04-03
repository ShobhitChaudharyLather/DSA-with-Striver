class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int x : nums2){
            while(!st.isEmpty() && st.peek() < x){
                mp.put(st.pop(),x);
            }
            st.push(x);
        }
        int i = 0;
        for(int x : nums1){
            res[i] = mp.getOrDefault(nums1[i],-1);
            i++;
        }
        return res;
    }
}