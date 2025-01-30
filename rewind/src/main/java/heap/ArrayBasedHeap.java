package heap;

import java.util.Comparator;

public class ArrayBasedHeap<T> {

    private int count;
    private Node<T>[] heapArray;
    private Comparator<Node<T>> comparator;

    @SuppressWarnings("unchecked")
    public ArrayBasedHeap(int size, Comparator<Node<T>> comparator) {
        this.count = 0;
        this.heapArray = new Node[size + 1]; // 1-based index
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    private int findParentIndex(int index) {
        return index / 2;
    }

    private int findLeftChildIndex(int index) {
        return index * 2;
    }

    private int findRightChildIndex(int index) {
        return findLeftChildIndex(index) + 1;
    }

    private int findHighPriorityChildIndex(int index) {
        int leftChildIndex = findLeftChildIndex(index);

        if (leftChildIndex > count) {
            return 0;
        }

        if (leftChildIndex == count) {
            return leftChildIndex;
        }

        int rightChildIndex = findRightChildIndex(index);

        if (rightChildIndex > count || comparator.compare(heapArray[leftChildIndex], heapArray[rightChildIndex]) <= 0) {
            return leftChildIndex;
        }

        return rightChildIndex;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (count + 1 >= heapArray.length) {
            Node<T>[] newHeapArray = new Node[heapArray.length * 2];
            System.arraycopy(heapArray, 0, newHeapArray, 0, heapArray.length);
            heapArray = newHeapArray;
        }
    }

    public void insertElement(T data) {
        ensureCapacity();

        int index = ++count;
        Node<T> element = new Node<>(data);

        while (index != 1) {
            int parentIndex = findParentIndex(index);

            if (comparator.compare(element, heapArray[parentIndex]) >= 0) {
                break;
            }

            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
        }

        heapArray[index] = element;
    }

    public T deleteElement() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        T deletedData = heapArray[1].data;
        Node<T> lastElement = heapArray[count--];

        int parentIndex = 1;
        int childIndex;

        while ((childIndex = findHighPriorityChildIndex(parentIndex)) != 0) {
            if (comparator.compare(lastElement, heapArray[childIndex]) <= 0) {
                break;
            }

            heapArray[parentIndex] = heapArray[childIndex];
            parentIndex = childIndex;
        }

        heapArray[parentIndex] = lastElement;
        return deletedData;
    }

    public static class Node<T> {

        private T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
