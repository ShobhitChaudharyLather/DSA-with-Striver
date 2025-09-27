// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {
    Node top;
    int currSize;
    
    public myStack() {
        // Initialize your data members
        top = null;
        currSize = 0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return currSize == 0;
    }

    public void push(int x) {
        // Adds an element x at the rear of the queue.
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        currSize++;
    }

    public void pop() {
        // Removes the front element of the queue
        top = top.next;
        currSize--;
    }

    public int peek() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        return currSize == 0 ? -1: top.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return currSize;
    }
}
