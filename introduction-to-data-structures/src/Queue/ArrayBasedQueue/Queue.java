package Queue.ArrayBasedQueue;

public class Queue {

    private int front;
    private int rear;
    private int[] queueArray;

    public Queue() {
        this.front = 0;
        this.rear = 0;
        this.queueArray = new int[100];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    private int nextIndex(int index) {
        if (index == queueArray.length - 1) {
            return 0;
        }
        return index + 1;
    }

    public void enqueue(int data) {
        if (nextIndex(rear) == front) {
            throw new QueueMemoryException();
        }

        rear = nextIndex(rear);
        queueArray[rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new QueueMemoryException();
        }
        front = nextIndex(front);
        return queueArray[front];
    }

    public int peek() {
        if (isEmpty()) {
            throw new QueueMemoryException();
        }
        front = nextIndex(front);
        return queueArray[front];
    }
}
