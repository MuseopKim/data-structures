package Stack;

public class IntStack {

    private int max;
    private int pointer;
    private int[] stack;

    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public class OverflowStackException extends RuntimeException {
        public OverflowStackException() {}
    }

    public IntStack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            stack = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public int push(int element) throws OverflowStackException {
        if (pointer >= max) {
            throw new OverflowStackException();
        }
        return stack[pointer++] = element;
    }

    public int pop() throws EmptyStackException {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return stack[--pointer];
    }

    public int peek() throws EmptyStackException {
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return stack[pointer - 1];
    }

    public int indexOf(int target) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        pointer = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= max;
    }

    public void dump() {
        if (pointer <= 0) {
            System.out.println("Stack이 비어 있습니다.");
            return;
        }

        for (int i = 0; i < pointer; i++) {
            System.out.println(stack[i] + " ");
        }
        System.out.println();
    }
}
