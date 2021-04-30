package PriorityQueue.Heap;

import java.util.Comparator;

public class Heap {

    private int count;
    private HeapElement[] heapArray;
    private Comparator<HeapElement> comparator;

    static class HeapElement {
        private int data;

        public HeapElement(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    public Heap(int size, Comparator<HeapElement> comparator) {
        this.count = 0;
        this.heapArray = new HeapElement[size];
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int findParentIndex(int index) {
        return index / 2;
    }

    public int findLeftChildIndex(int index) {
        return index * 2;
    }

    public int findRightChildIndex(int index) {
        return findLeftChildIndex(index) + 1;
    }

    public int findHighPriorityChildIndex(int index) {
        int leftChildIndex = findLeftChildIndex(index);

        if (leftChildIndex > count) {
            return 0;
        }

        if (leftChildIndex == count) {
            return leftChildIndex;
        }

        int rightChildIndex = findRightChildIndex(index);

        if (comparator.compare(heapArray[leftChildIndex], heapArray[rightChildIndex]) > 0) {
            return rightChildIndex;
        }

        return leftChildIndex;
    }

    public void insertElement(int data) {
        int index = count + 1;
        HeapElement element = new HeapElement(data);

        while (index != 1) {
            int parentIndex = findParentIndex(index);

            if (comparator.compare(element, heapArray[parentIndex]) <= 0) {
                heapArray[index] = heapArray[parentIndex];
                index = parentIndex;
                continue;
            }

            break;
        }

        heapArray[index] = element;
        count++;
    }

    public int deleteElement() {
        int deletedData = heapArray[1].data;
        HeapElement lastElement = heapArray[count];

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
        count--;

        return deletedData;
    }
}
