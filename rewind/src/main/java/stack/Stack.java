package stack;

import linkedlist.LinkedList;
import linkedlist.LinkedList.Node;

public class Stack<T> {

    private LinkedList<T> linkedList;

    public Stack(LinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }

    public void push(T data) {
        this.linkedList.insertAt(0, data);
    }

    public Node<T> pop() {
        try {
            return this.linkedList.deleteAt(0);
        } catch (Exception exception) {
            return null;
        }
    }

    public Node<T> peek() {
        return this.linkedList.getNodeAt(0);
    }

    public boolean isEmpty() {
        return this.linkedList.size() == 0;
    }
}
