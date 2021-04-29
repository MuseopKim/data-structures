package Deque;

public class Deque {

    private Node head;
    private Node tail;

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

    public Deque() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }

        head = newNode;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new DequeMemoryException();
        }
        Node deleteNode = head;
        int data = head.data;
        head = head.next;
        deleteNode = null;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        return data;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new DequeMemoryException();
        }
        return head.data;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new DequeMemoryException();
        }
        Node deleteNode = tail;
        int data = tail.data;
        tail = tail.previous;
        deleteNode = null;

        if (tail == null) {
            head = null;
        }

        return data;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new DequeMemoryException();
        }
        return tail.data;
    }
}
