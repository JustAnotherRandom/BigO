package bigO.src.dp;

/**
 * Created by Stanimir on 7/9/17.
 */
public class KnapSack {

    public static void main(String[] str) {


//        int w = 50;
//        int[] vals = new int[]{60, 100, 120};
//        int[] weigths = new int[]{10, 20, 15};
//
//
//        int val[] = new int[]{60, 100, 120};
//        int wt[] = new int[]{10, 20, 15};
//        int W = 50;
//        int n = val.length;
//            System.out.println(knapSack(W, wt, val, n));

        int W = 9;
        int val2[] = new int[]{5, 4, 3, 3, 2};
        int wt2[] = new int[]{8, 2, 3, 1, 4};

        int[] cache = new int[val2.length];
        System.out.println(knapSack(W, wt2, val2, val2.length));


//        int[] res = solve(vals, weigths, w);
//
//
//        System.out.println(Arrays.stream(res).sum());
//        System.out.println(Arrays.stream(res).reduce(0, (x, y) -> x + y));
//        System.out.println(Arrays.stream(res).reduce(0, (x, y) -> x + y));


    }

//    private static int knapSackDP(int w, int[] wt, int[] vl, int n, int[] cache) {
//        //base case
//
//        if (w == 0 || n == 0) return 0;
//
//        cache[0]+=1;
//
//        if (wt[n - 1] > w) return knapSackDP(w, wt, vl, n - 1, cache);
//
//        int incl = vl[n - 1] + knapSackDP(w - wt[n - 1], wt, vl, n - 1, cache);
//        int notIncl = knapSackDP(w, wt, vl, n - 1, cache);
//
//
//        return Math.max(incl, notIncl);
//    }

    //    private static int knapSackDP(int w, int[] wt, int[] vl, int n, int[] cache) {
//        //base case
//
//        if (w == 0 || n == 0) return 0;
//        System.out.println(n);
//
//
//        if (cache[n-1 ] == 0) {
//            if (wt[n - 1] > w) {
//                cache[n - 1] = knapSackDP(w, wt, vl, n - 1, cache);
//
//            } else {
//                int incl = vl[n - 1] + knapSackDP(w - wt[n - 1], wt, vl, n - 1, cache);
//                int notIncl = knapSackDP(w, wt, vl, n - 1, cache);
//
//                cache[n - 1] = Math.max(incl, notIncl);
//            }
//
//
//        }
//
//
//        return cache[n - 1];
//    }
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }
}
