package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(25);
        linkedList.insert(27);
        linkedList.insert(11);
        linkedList.insert(22);
        linkedList.insert(23);
        linkedList.insert(31);

        System.out.println("현재 저장된 데이터 수 : " + linkedList.count());

        if (linkedList.pointFirst()) {
            int currentData = linkedList.currentValue();

            System.out.println("현재 노드의 값 : " + currentData);

            StringBuilder strBuilder = new StringBuilder("저장된 모든 값 : " + currentData);

            while (linkedList.pointNext()) {
                strBuilder.append(", ")
                          .append(linkedList.currentValue());
            }

            System.out.println(strBuilder.toString());
        }

        if (linkedList.pointFirst()) {
            if (linkedList.currentValue() == 23) {
                linkedList.remove();
            }

            while (linkedList.pointNext()) {
                if (linkedList.currentValue() == 23) {
                    linkedList.remove();
                }
            }
        }
        System.out.println("현재 데이터 수 : " + linkedList.count());
    }
}
