package Stack.LinkedListBasedStack;

public class Stack {

    private Node head;

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        Node deleteNode = head;
        int data = head.data;
        head = head.next;
        deleteNode = null;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new StackMemoryException();
        }
        return head.data;
    }
}
