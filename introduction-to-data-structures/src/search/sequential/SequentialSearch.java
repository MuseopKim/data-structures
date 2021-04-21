package search.sequential;

import java.util.Scanner;

public class SequentialSearch {

    static int sequentialSearch(int[] array, int length, int target) {
        int index = 0;

        array[length] = target;

        while (true) {
            if (array[length] == target) {
                break;
            }
            index++;
        }
        return index == length ? -1 : index;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요소의 수 : ");
        int length = stdIn.nextInt();
        int[] array = new int[length + 1];

        for (int i = 0; i < length; i++) {
            System.out.println("array[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        System.out.println("검색할 값 : ");
        int target = stdIn.nextInt();
        int index = sequentialSearch(array, length, target);

        if (index == -1) {
            System.out.println("검색 값이 존재하지 않습니다.");
            return;
        }

        System.out.println(target + "은(는) 인덱스 " + index + "에 존재 합니다.");
    }
}
