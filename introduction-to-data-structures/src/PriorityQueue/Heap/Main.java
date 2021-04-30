package PriorityQueue.Heap;

import PriorityQueue.Heap.Heap.HeapElement;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Comparator<HeapElement> comparator = (firstElement, secondElement) -> {
            if (firstElement.getData() - secondElement.getData() < 0) {
                return -1;
            }

            if (firstElement.getData() - secondElement.getData() > 0) {
                return 1;
            }
            return 0;
        };

        Heap heap = new Heap(100, comparator);

        heap.insertElement(1);
        heap.insertElement(2);
        heap.insertElement(3);
        heap.insertElement(1);
        heap.insertElement(2);
        heap.insertElement(3);

        int index = 0;

        while (!heap.isEmpty()) {
            System.out.println(++index + "번째 데이터 : " + heap.deleteElement());
        }

    }
}
