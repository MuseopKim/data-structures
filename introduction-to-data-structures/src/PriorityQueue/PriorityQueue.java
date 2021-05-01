package PriorityQueue;

import PriorityQueue.Heap.Heap;
import PriorityQueue.Heap.Heap.HeapElement;

import java.util.Comparator;

public class PriorityQueue {

    private Heap heap;

    public PriorityQueue(int size, Comparator<HeapElement> comparator) {
        this.heap = new Heap(size, comparator);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void enqueue(int data) {
        heap.insertElement(data);
    }

    public int dequeue() {
        return heap.deleteElement();
    }
}
