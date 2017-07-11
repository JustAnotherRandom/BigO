package bigO.src.sorting;

/**
 * Created by Stanimir on 6/14/17.
 */
public class InsertionSort {


    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int current = i;
            int prevIndex = i - 1;


            while (prevIndex >= 0 && arr[current] < arr[prevIndex]) {
                swap(arr, prevIndex--, current--);
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
