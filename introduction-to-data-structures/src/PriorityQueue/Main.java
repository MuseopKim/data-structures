package PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(100, (firstElement, secondElement) -> {
            if (firstElement.getData() - secondElement.getData() < 0) {
                return -1;
            }

            if (firstElement.getData() - secondElement.getData() > 0) {
                return 1;
            }

            return 0;
        });

        priorityQueue.enqueue(1);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(9);
        priorityQueue.enqueue(2);

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            System.out.println(++index + "번째 데이터 : " + priorityQueue.dequeue());
        }
    }
}
