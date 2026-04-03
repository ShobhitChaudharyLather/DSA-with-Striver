class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek()[0] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0;
            }
            else{
                res[i] = st.peek()[1] - i;
            }
            st.push(new int[]{temperatures[i],i});
        }
        return res;
    }
}