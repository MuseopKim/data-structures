package Search.binary;

import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] array, int length, int target) {
        int first = 0;
        int last = length - 1;

        do {
            int currentIndex = (first + last) / 2;
            if (array[currentIndex] == target) {
                return currentIndex;
            }

            if (array[currentIndex] < target) {
                first = currentIndex + 1;
            }

            if (array[currentIndex] > target) {
                last = currentIndex - 1;
            }
        } while (first <= last);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요소의 수 : ");
        int length = stdIn.nextInt();
        int[] array = new int[length];

        System.out.println("오름차순으로 입력 하세요.");

        System.out.println("array[0] : ");
        array[0] = stdIn.nextInt();

        for (int i = 1; i < length; i++) {
            do {
                System.out.println("array[" + i +"] : ");
                array[i] = stdIn.nextInt();
            } while (array[i] < array[i - 1]);
        }

        System.out.println("검색 할 값 : ");
        int target = stdIn.nextInt();

        int index = binarySearch(array, length, target);

        if (index == -1) {
            System.out.println("검색한 값이 존재하지 않습니다.");
            return;
        }

        System.out.println(target + "은(는) " + index + "에 존재 합니다.");
    }
}
