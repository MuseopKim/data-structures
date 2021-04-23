package LinkedList.CircularLinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);

        System.out.println(linkedList.printAll());

        if (linkedList.pointFirst()) {
            if (linkedList.currentValue() % 2 == 0) {
                linkedList.remove();
            }

            while (linkedList.pointNext()) {
                if (linkedList.currentValue() % 2 == 0) {
                    linkedList.remove();
                }
            }
        }

        System.out.println(linkedList.printAll());
    }
}
