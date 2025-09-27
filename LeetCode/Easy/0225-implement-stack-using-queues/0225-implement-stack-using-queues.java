class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int size;
    public MyStack() {
        size = q.size();
    }
    
    public void push(int x) {
        q.offer(x);
        for(int i=1; i<=size; i++){
            q.offer(q.remove());
        }
        size++;
    }
    
    public int pop() {
        size--;
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */