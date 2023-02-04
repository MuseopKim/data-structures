package selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public static int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[i] > copy[j]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }

        return copy;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 4, 5, 7, 6};
        int[] sorted = SelectionSort.sort(array);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
