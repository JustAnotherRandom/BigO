package bigO.src.practice.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/2/17.
 */
public class HeapSort {

    public static void main(String[] str) {
        int[] arr = new int[]{4, 10, 3, 5, 1};
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        HeapSort app = new HeapSort();
        app.sort(arr);
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    private void sort(int[] arr) {
        heapify(arr);
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

    }

    private void heapify(int[] arr) {
        int n = arr.length;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
