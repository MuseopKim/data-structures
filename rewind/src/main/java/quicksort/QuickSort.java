package quicksort;

import java.util.Arrays;

public class QuickSort {

    public static int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        quickSort(copy, 0, array.length - 1);

        return copy;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = divide(array, left, right);
            quickSort(array, left, pivot - 1);  // pivot 기준 왼쪽 영역 정렬
            quickSort(array, pivot + 1, right); // pivot 기준 오른쪽 영역 정렬
        }
    }

    private static int divide(int[] array, int left, int right) {
        int pivot = array[left];
        int leftStartIndex = left + 1;
        int rightStartIndex = right;

        while (leftStartIndex < rightStartIndex) {
            // pivot보다 큰 값을 만날 때까지 오른쪽으로 이동
            while (leftStartIndex < right && pivot > array[leftStartIndex]) {
                leftStartIndex += 1;
            }

            // pivot보다 작은 값을 만날 때까지 왼쪽으로 이동
            while (rightStartIndex > (left + 1) && pivot < array[rightStartIndex]) {
                rightStartIndex -= 1;
            }

            // left (> pivot),  right (< pivot) 교환
            if (leftStartIndex < rightStartIndex) {
                swap(array, leftStartIndex, rightStartIndex);
            }
        }

        // pivot, right (< pivot) 교환
        if (array[rightStartIndex] < pivot) {
            swap(array, left, rightStartIndex);
        }

        return rightStartIndex;
    }

    private static void swap(int[] array, int one, int theOther) {
        int temp = array[one];
        array[one] = array[theOther];
        array[theOther] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 6, 2, 1, 7, 4, 8, 5};
        int[] sorted = QuickSort.sort(array);
        for (int element : sorted) {
            System.out.println(element);
        }
    }
}
