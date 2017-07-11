package bigO.src.practice.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/1/17.
 */
public class MergeSort {

    public static void main(String[] str) {
        MergeSort app = new MergeSort();
        int[] in = new int[]{12, 11, 13, 5, 6, 13};
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        System.out.println();
        app.sortInPlace(in);
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    private void sortInPlace(int[] in) {
        mergeSortInPlace(in, 0, in.length - 1);
    }

    private void mergeSortInPlace(int[] arr, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergeSortInPlace(arr, l, m);
            mergeSortInPlace(arr, m + 1, h);
            merge(arr, l, m, h);
        }
    }

    private void merge(int[] arr, int l, int m, int h) {
        int low = l;
        int high = m + 1;
        int ir = low;

        while (low <= m || high <= h) {
            if (low <= m && high <= h) {
                if (arr[low] >= arr[high]) {
                    swap(arr, low++, high);
                }else {
                    low++;
                    high++;
                }
            }else {
                return;
            }
        }
    }

    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private int[] mergeSort(int[] in, int l, int h) {
        if (l >= h) return new int[]{in[l]};

        int m = (l + h) / 2;

        int[] left = mergeSort(in, l, m);
        int[] right = mergeSort(in, m + 1, h);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int il = 0;
        int ir = 0;
        int ires = 0;
        int[] res = new int[left.length + right.length];


        while (il < left.length || ir < right.length) {
            if (il < left.length && ir < right.length) {
                if (left[il] <= right[ir]) {
                    res[ires++] = left[il++];
                } else {
                    res[ires++] = right[ir++];
                }
            } else if (il < left.length) {
                res[ires++] = left[il++];
            } else {
                res[ires++] = right[ir++];
            }
        }

        return res;
    }

}
