package LinkedList.SinglyLinkedList;

public class LinkedList {

    private Node head;
    private Node current;
    private Node before;
    private int count;

    public LinkedList() {
        this.head = new Node();
        this.count = 0;
    }

    private static class Node {

        private int data;
        private Node next;

        public Node() {}

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        // 새로운 노드를 생성한다.
        Node newNode = new Node(data);
        // 더미 노드가 가리키던 노드를 새로 생성한 노드에 연결한다.
        newNode.next = head.next;
        // 더미 노드에 새로운 노드를 연결한다.
        head.next = newNode;
        // 카운트를 증가 시킨다.
        count += 1;
    }

    public boolean pointFirst() {
        if (head.next == null) {
            // 아무런 노드가 존재하지 않으면 false를 반환한다.
            return false;
        }
        // 노드가 1개 이상 존재하면 before 포인터는 더미노드를 가리킨다.
        before = head;
        // current 포인터는 첫 노드를 가리킨다.
        current = head.next;
        // current 포인터가 첫 노드를 가리키는 것에 성공하면 true 반환한다.
        return true;
    }

    public boolean pointNext() {
        if (current.next == null) {
            // 다음 노드가 존재하지 않으면 false를 반환한다.
            return false;
        }
        // before 포인터는 현재 노드를 가리킨다.
        before = current;
        // current 포인터는 다음 노드를 가리킨다.
        current = current.next;
        // next노드를 가리키는 것에 성공하면 true를 반환한다.
        return true;
    }

    public int currentValue() {
        return current.data;
    }

    public int remove() {
        // 현재 노드를 임시 포인터로 가리킨다.
        Node pointer = current;
        // 현재 노드의 값을 복사 한다.
        int deletedData = pointer.data;
        // 현재 노드의 이전 노드를 다음 노드와 연결한다.
        before.next = current.next;
        // 삭제 될 노드를 가리키고 있는 포인터가 이전 노드를 가리키게 한다.
        current = before;
        // 임시 포인터가 가리키고 있는 현재 노드를 삭제 한다.
        pointer = null;
        // 현재 리스트의 카운터를 1 감소 시킨다.
        count--;
        // 삭제 된 데이터를 반환한다.
        return deletedData;
    }

    public int count() {
        return this.count;
    }
}


