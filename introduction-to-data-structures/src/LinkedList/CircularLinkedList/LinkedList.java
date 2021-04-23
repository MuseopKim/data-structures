package LinkedList.CircularLinkedList;

public class LinkedList {

    private Node tail;
    private Node current;
    private Node previous;
    private int count;

    static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.tail = null;
        this.current = null;
        this.previous = null;
        this.count = 0;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        count++;

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        count++;

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    public boolean pointFirst() {
        if (tail == null) {
            return false;
        }

        previous = tail;
        current = tail.next;
        return true;
    }

    public boolean pointNext() {
        if (tail == null) {
            return false;
        }

        if (current.next == tail.next) {
            return false;
        }

        previous = current;
        current = current.next;
        return true;
    }

    public int currentValue() {
        return current.data;
    }

    public int remove() {
        Node deleteNode = current;
        int deletedData = deleteNode.data;

        if (current == tail) {
            if (tail == tail.next) {
                tail = null;
            } else {
                tail = previous;
            }
        }

        previous.next = current.next;
        current = previous;

        deleteNode = null;
        count--;

        return deletedData;
    }

    public int count() {
        return this.count;
    }

    public String printAll() {
        StringBuilder strBuilder = new StringBuilder();
        if (pointFirst()) {
            strBuilder.append(currentValue());

            while (pointNext()) {
                strBuilder.append(", ")
                          .append(currentValue());
            }

            return strBuilder.toString();
        }

        return strBuilder.append("리스트가 비어 있습니다.").toString();
    }
}
