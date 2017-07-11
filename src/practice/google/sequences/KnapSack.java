package bigO.src.practice.google.sequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 */
public class KnapSack {

    public static void main(String[] str) {


        int w = 50;
        int[] vals = new int[]{60, 100, 120};
        int[] weigths = new int[]{10, 20, 15};


        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 15};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));


        int[] cache = new int[n];
        System.out.println(knapSackDP(W, wt, val, n, cache));


//        int[] res = solve(vals, weigths, w);
//
//
//        System.out.println(Arrays.stream(res).sum());
//        System.out.println(Arrays.stream(res).reduce(0, (x, y) -> x + y));
//        System.out.println(Arrays.stream(res).reduce(0, (x, y) -> x + y));

    }

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        int nMin1 = wt[n - 1];
        if (nMin1 > W) {
            return knapSack(W, wt, val, n - 1);
        } else {

            // Return the maximum of two cases:
            // (1) nth item included
            int included = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
            // (2) not included
            int notIncluded = knapSack(W, wt, val, n - 1);


            return max(included, notIncluded);
        }

    }

    static int knapSackDP(int W, int wt[], int val[], int n, int[] cache) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution

        int v = cache[n - 1];
        if (v > 0) {
            return v;
        } else {
            int tr = 0;
            int nMin1 = wt[n - 1];
            if (nMin1 > W) {
                tr = knapSackDP(W, wt, val, n - 1, cache);
            } else {

                // Return the maximum of two cases:
                // (1) nth item included
                int included = val[n - 1] + knapSackDP(W - wt[n - 1], wt, val, n - 1, cache);
                // (2) not included
                int notIncluded = knapSackDP(W, wt, val, n - 1, cache);


                tr = max(included, notIncluded);
            }

            cache[n - 1] = tr;
            return tr;
        }


    }

    private static int[] solve(int[] vals, int[] weigths, int w) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            cache.put(weigths[i], vals[i]);
        }

        Arrays.sort(weigths);

        int n = vals.length;
        int l = n - 1;
        int h = l;

        int max = weigths[h];
        int maxl = h;
        int maxh = h;

        int current = weigths[h];

        while (l > 0) {


            if (current > w) {
                h--;
                current -= weigths[h];
            } else {
                l--;
                current += weigths[l];
            }

            if (current > max && current <= w) {
                max = current;
                maxh = h;
                maxl = l;
            }

            if (max == w) break;
        }
        int[] res = new int[maxh - maxl + 1];
        int ind = 0;
        while (maxl <= maxh) {
            res[ind++] = cache.get(weigths[maxl++]);
        }


        return res;

    }

}
