package Stack.ArrayBasedStack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(100);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int index = 0;

        while (!stack.isEmpty()) {
            System.out.println(++index + "번째 : " + stack.pop());
        }
    }
}
