package bigO.src.dp;

/**
 * Created by Stanimir on 5/4/17.
 */
public class TopDownFib {

    public static void main(String[] str) {

        int n = 6;
        int res = topDownFib(n, new int[n + 1]);
        System.out.println(res);
    }

    private static int topDownFib(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == 0) {
            memo[n] = topDownFib(n - 1, memo) + topDownFib(n - 2, memo);
        }

        return memo[n];
    }

}
