package insertionsort;

import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        for (int i = 1; i < copy.length; i++) {
            int currentNumber = copy[i];
            int insertionIndex = i;

            for (int j = i - 1; j >= 0; j--) {
                if (currentNumber < copy[j]) {
                    copy[j + 1] = copy[j];
                    insertionIndex = j;
                }

                if (currentNumber >= copy[j]) {
                    break;
                }
            }

            copy[insertionIndex] = currentNumber;
        }

        return copy;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 5, 3, 6, 2};
        int[] sorted = InsertionSort.sort(array);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
