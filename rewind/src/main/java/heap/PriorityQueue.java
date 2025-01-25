package heap;

import java.util.Comparator;

public class PriorityQueue<T> {

    private final Heap<T> heap;

    public PriorityQueue(Comparator<T> comparator) {
        this.heap = new Heap<>(comparator);
    }

    public void enqueue(T data) {
        this.heap.insert(data);
    }

    public BinaryTree<T> dequeue() {
        return this.heap.remove();
    }
}
