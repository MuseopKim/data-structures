package Stack.ArrayBasedStack;

public class Stack {

    private int topIndex;
    private int[] stackArray;

    public Stack(int length) {
        this.topIndex = -1;
        this.stackArray = new int[length];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == stackArray.length - 1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new MemoryException();
        }
        topIndex += 1;
        stackArray[topIndex] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new MemoryException();
        }
        return stackArray[topIndex--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new MemoryException();
        }
        return stackArray[topIndex];
    }
}
