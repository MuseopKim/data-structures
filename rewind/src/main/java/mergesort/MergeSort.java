package mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        mergeSort(copy, 0, copy.length - 1);

        return copy;
    }

    private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftAreaIndex = leftIndex;
        int rightAreaIndex = middleIndex + 1;

        int[] tempArray = new int[rightIndex + 1];
        int tempArrayIndex = leftIndex;

        while (leftAreaIndex <= middleIndex && rightAreaIndex <= rightIndex) {
            if (array[leftAreaIndex] <= array[rightAreaIndex]) {
                tempArray[tempArrayIndex] = array[leftAreaIndex];
                leftAreaIndex += 1;
            } else if (array[leftAreaIndex] > array[rightAreaIndex]) {
                tempArray[tempArrayIndex] = array[rightAreaIndex];
                rightAreaIndex += 1;
            }

            tempArrayIndex += 1;
        }

        if (leftAreaIndex > middleIndex) {
            for (int i = rightAreaIndex; i <= rightIndex; i++) {
                tempArray[tempArrayIndex] = array[i];
                tempArrayIndex += 1;
            }
        } else if (rightAreaIndex > rightIndex) {
            for (int i = leftAreaIndex; i <= middleIndex; i++) {
                tempArray[tempArrayIndex] = array[i];
                tempArrayIndex += 1;
            }
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 6, 2, 1, 7, 4, 8, 5};
        int[] sorted = MergeSort.sort(array);
        for (int element : sorted) {
            System.out.println(element);
        }
    }
}
