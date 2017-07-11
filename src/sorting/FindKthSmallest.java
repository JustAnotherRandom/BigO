package bigO.src.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/17/17.
 */
public class FindKthSmallest {


    //{19, 7, 4, 9, 21, 3};

    /*
    *
    * select pivot
    * partition so left of the pivot has only elements <= than the pivot
    * if 9 is the pivot
    * 7,4,3  9  21,19
    *
    * return the elements on the left
    *
    * */
    public static int[] findKthSmallest(int[] arr, int k) {
        if (k < 0 || k > arr.length) throw new IllegalArgumentException();
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        int threashHold = rank(arr, k - 1);
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        int[] res = new int[k];
        int c = 0;
        for (int a :
                arr) {
            if (a <= threashHold) {
                res[c++] = a;
            }
        }
        System.out.println(Arrays.stream(res).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        return res;
    }

    private static int rank(int[] arr, int rank) {
        return rank(arr, 0, arr.length - 1, rank);
    }

    private static int rank(int[] arr, int left, int right, int rank) {
        int pivot = findPivot(left, right);

        int leftEnd = partition(arr, left, right, pivot);
        int leftSize = leftEnd - left + 1;

        if (leftSize - 1 == rank) {
            return max(arr, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(arr, left, leftEnd, rank);
        } else {
            return rank(arr, leftEnd + 1, right, rank - leftSize);
        }
    }

    private static int max(int[] arr, int low, int high) {

        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int partition(int[] arr, int l, int h, int pivot) {
        System.out.println("pivot" + arr[pivot] + "left:" + l + " right:" + h);

        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        //place the pivot at the rigth spot
        swap(arr, i + 1, pivot);
        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(",")));

        return i + 1;
    }

    private static void swap(int[] arr, int low, int high) {
        int t = arr[low];
        arr[low] = arr[high];
        arr[high] = t;
    }

    private static int findPivot(int low, int high) {
        Random r = new Random();
        return r.nextInt(high + 1 - low) + low;
    }
}
