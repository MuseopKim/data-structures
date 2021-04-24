package LinkedList.DoublyLinkedList;

public class LinkedList {

    private Node head;
    private Node current;
    private int count;

    static class Node {
        private int data;
        private Node previous;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.current = null;
        this.count = 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        }

        head = newNode;
        count++;
    }

    public boolean pointFirst() {
        if (head == null) {
            return false;
        }

        current = head;
        return true;
    }

    public boolean pointNext() {
        if (current.next == null) {
            return false;
        }

        current = current.next;
        return true;
    }

    public boolean pointPrevious() {
        if (current.previous == null) {
            return false;
        }

        current = current.previous;
        return true;
    }

    public int currentValue() {
        return current.data;
    }

    public int count() {
        return this.count;
    }
}
