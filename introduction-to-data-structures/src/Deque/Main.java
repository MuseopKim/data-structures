package Deque;

public class Main {

    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);

        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        int order = 0;

        while (!deque.isEmpty()) {
            System.out.println(++order + "번째 삭제 된 데이터 : " + deque.removeLast());
        }

        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);

        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        order = 0;

        while (!deque.isEmpty()) {
            System.out.println(++order + "번째 삭제 된 데이터 : " + deque.removeFirst());
        }
    }
}
