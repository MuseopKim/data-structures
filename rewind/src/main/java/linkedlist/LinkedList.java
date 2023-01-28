package linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private int count;

    public void printAll() {
        Node<T> current = this.head;
        StringBuilder textBuilder = new StringBuilder("[");

        while (current != null) {
            textBuilder.append(current.data);
            current = current.next;

            if (current != null) {
                textBuilder.append(current.data);
            }
        }

        textBuilder.append("]");
        System.out.println(textBuilder);
    }

    public void clear() {
        this.head = null;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public void insertAt(int index, T data) {
        if (index > this.count || index < 0) {
            throw new RuntimeException();
        }

        Node<T> newNode = new Node(data);
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node<T> current = this.head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        this.count += 1;
    }

    public void insertLast(T data) {
        this.insertAt(this.count, data);
    }

    public Node<T> deleteAt(int index) {
        if (index >= this.count || index < 0) {
            throw new RuntimeException();
        }

        Node<T> current = this.head;

        if (index == 0) {
            Node<T> deleteNode = this.head;
            this.head = this.head.next;
            this.count -= 1;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<T> deleteNode = current.next;
            current.next = current.next.next;
            this.count -= 1;

            return deleteNode;
        }

        return null;
    }

    public Node<T> deleteLast() {
        return this.deleteAt(this.count - 1);
    }

    public Node<T> getNodeAt(int index) {
        if (index >= this.count || index < 0) {
            throw new RuntimeException();
        }

        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
