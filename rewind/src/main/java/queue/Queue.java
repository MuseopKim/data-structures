package queue;

import doublylinkedlist.DoublyLinkedList;
import doublylinkedlist.DoublyLinkedList.Node;

public class Queue<T> {

    private DoublyLinkedList<T> linkedList = new DoublyLinkedList<>();

    public void enqueue(T data) {
        this.linkedList.insertAt(0, data);
    }

    public Node<T> dequeue(T data) {
        try {
            return this.linkedList.deleteLast();
        } catch (Exception e) {
            return null;
        }
    }

    public Node<T> front() {
        return this.linkedList.getLast();
    }

    public boolean isEmpty() {
        return this.linkedList.size() == 0;
    }
}
