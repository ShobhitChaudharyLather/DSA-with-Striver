class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(arr[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<>(n);
        
        for (int x : res) result.add(x);
        return result;
    }
}