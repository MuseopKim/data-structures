package Queue.LinkedListBasedQueue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int index = 0;

        while (!queue.isEmpty()) {
            System.out.println(++index + "번째 : " + queue.dequeue());
        }
    }
}
