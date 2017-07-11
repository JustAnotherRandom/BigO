package bigO.src.practice.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/30/17.
 */
public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }

    private int partition(int[] arr, int l, int h) {

        int pivot = arr[h];
        int i = l-1;

        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        //place the pivot at the rigth spot
        swap(arr, i+1, h);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] str) {
        QuickSort app = new QuickSort();
        int[] in = new int[]{12, 11, 13, 5, 6};
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        System.out.println();
        app.sort(in);
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

}
