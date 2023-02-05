package bubblesort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (copy[j] > copy[j + 1]) {
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        return copy;
    }
}
