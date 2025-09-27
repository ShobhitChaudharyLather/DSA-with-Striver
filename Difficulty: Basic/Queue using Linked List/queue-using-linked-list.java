// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    Node start;
    Node end;
    int currSize;
    
    public myQueue() {
        // Initialize your data members
        start = null;
        end = null;
        currSize = 0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return currSize == 0;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        if(currSize == 0){
            Node newNode = new Node(x);
            start= newNode;
            end = newNode;
            currSize++;
        }
        else{
            Node newNode = new Node(x);
            end.next = newNode;
            end = newNode;
            currSize++;
        }
    }

    public void dequeue() {
        // Removes the front element of the queue
        start = start.next;
        currSize--;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        return currSize == 0 ? -1 : start.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return currSize;
    }
}
