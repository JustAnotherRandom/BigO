package bigO.src.dp;

import java.util.Arrays;

/**
 * Created by Stanimir on 6/17/17.
 */
public class MaxSumNotAdjacentInList {

    public static int maxSum(int[] arr) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);
        return max(arr, 0, cache);
    }

    private static int max(int[] arr, int i, int[] cache) {
        if (i >= arr.length || i < 0) return 0;

        int c = cache[i];
        if (c >= 0) {
            System.out.println("hit:" + i);
            return c;
        }
        System.out.println("work: " + i);

        int incl = arr[i] + max(arr, i + 2, cache);
        int notInc = max(arr, i + 1, cache);

        cache[i] = Math.max(incl, notInc);

        return cache[i];
    }

    public static int findMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }


    public static int findMaxSumBottomupMine(int[] arr) {

        int maxSum = 0;
        for (int i = 0; i < arr.length; ) {
            int val = arr[i];
            int sum1 = val + getOrZero(arr, i + 2);
            int sum2 = val + getOrZero(arr, i + 3);
            int sumB = getOrZero(arr, i + 1) + getOrZero(arr, i + 3);

            if (sum1 >= sumB || sum2 >= sumB) {
                i += 2;
                maxSum += val;

            } else {
                i++;
            }

        }
        return maxSum;
    }

    static int getOrZero(int[] arr, int i) {
        if (i < 0 || i >= arr.length) return 0;
        return arr[i];
    }
}
