package heap;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Comparator<Integer> comparator = (one, other) -> {
            if (one < other) {
                return -1;
            }

            if (one == other) {
                return 0;
            }

            return 1;
        };

        Heap<Integer> heap = new Heap<>(comparator);
        heap.insert(4);
        heap.insert(2);
        heap.insert(5);
        heap.insert(7);
        heap.insert(1);
        heap.insert(1);

        heap.getRoot().inOrderTraversal(heap.getRoot());
        System.out.println(heap.getRoot().getData());

        System.out.println("====== remove =====");
        System.out.println(heap.remove().getData());
    }
}
