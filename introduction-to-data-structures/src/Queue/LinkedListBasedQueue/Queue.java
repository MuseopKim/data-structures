package Queue.LinkedListBasedQueue;

public class Queue {

    private Node front;
    private Node rear;

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        Node deleteNode = front;
        int data = front.data;
        front = front.next;
        deleteNode = null;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new QueueMemoryException();
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
