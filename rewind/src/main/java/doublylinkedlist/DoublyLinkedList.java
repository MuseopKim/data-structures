package doublylinkedlist;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
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
            if (this.head != null) {
                this.head.previous = newNode;
            }
            this.head = newNode;
        } else if (index == this.count) {
            newNode.next = null;
            newNode.previous = this.tail;
            this.tail.next = newNode;
        } else {
            Node<T> current = this.head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.previous = current;
            current.next = newNode;
            newNode.next.previous = newNode;
        }

        if (newNode.next == null) {
            this.tail = newNode;
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
            if (this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.previous = null;
            }
            this.count -= 1;

            return deleteNode;
        } else if (index == this.count - 1) {
            Node<T> deletedNode = this.tail;
            this.tail.previous.next = null;
            this.tail = this.tail.previous;
            this.count -= 1;

            return deletedNode;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<T> deleteNode = current.next;
            current.next = current.next.next;
            current.next.previous = current;
            this.count -= 1;

            return deleteNode;
        }
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

    public Node<T> getLast() {
        return this.tail;
    }

    public Node<T> getFirst() {
        return this.head;
    }

    public static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }
    }
}
