package Queue;

public class IntQueue {

    private int max;
    private int front;
    private int rear;
    private int count;
    private int[] queue;

    public class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {}
    }

    public class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {}
    }

    public IntQueue(int capacity) {
        count = front = rear = 0;
        max = capacity;
        try {
            queue = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public int enqueue(int element) throws OverflowQueueException {
        if (count >= max) {
            throw new OverflowQueueException();
        }
        queue[rear++] = element;
        count++;

        if (rear == max) {
            rear = 0;
        }
        return element;
    }

    public int dequeue() throws EmptyQueueException {
        if (count <= 0) {
            throw new EmptyQueueException();
        }

        int element = queue[front++];
        count--;

        if (front == max) {
            front = 0;
        }

        return element;
    }

    public int peek() throws EmptyQueueException {
        if (count <= 0) {
            throw new EmptyQueueException();
        }
        return queue[front];
    }

    public int indexOf(int target) {
        for (int i = 0; i < count; i++) {
            int index = (i + front) % max;
            if (queue[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public void clear() {
        count = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public boolean isFull() {
        return count >= max;
    }

    public void dump() {
        if (count <= 0) {
            System.out.println("Queue가 비어 있습니다.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(queue[(i + front) % max] + " ");
        }
        System.out.println();
    }
}
