package LinkedList.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);

        if (linkedList.pointFirst()) {
            StringBuilder strBuilder = new StringBuilder().append(linkedList.currentValue());

            while (linkedList.pointNext()) {
                strBuilder.append(", ")
                          .append(linkedList.currentValue());
            }

            while (linkedList.pointPrevious()) {
                strBuilder.append(", ")
                          .append(linkedList.currentValue());
            }

            System.out.println(strBuilder.toString());
        }
    }
}
