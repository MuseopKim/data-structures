package binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static int search(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (array[middle] > target) {
            return search(array, target, start, middle - 1);
        }

        if (array[middle] < target) {
            return search(array, target, middle + 1, end);
        }

        return middle;
    }
}
