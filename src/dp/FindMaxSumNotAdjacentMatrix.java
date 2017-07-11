package bigO.src.dp;

/**
 * Created by Stanimir on 6/18/17.
 */
public class FindMaxSumNotAdjacentMatrix {

    public static int maxSum1(int grid[][]) {
        int n = grid[0].length;
        // Sum including maximum element of first column
        int incl = Math.max(grid[0][0], grid[1][0]);

        // Not including first column's element
        int excl = 0, excl_new;

        // Traverse for further elements
        for (int i = 1; i < n; i++) {
            // Update max_sum on including or excluding
            // of previous column
            excl_new = Math.max(excl, incl);

            // Include current column. Add maximum element
            // from both row of current column
            incl = excl + Math.max(grid[0][i], grid[1][i]);

            // If current column doesn't to be included
            excl = excl_new;
        }

        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);
    }

    public static int maxSum(int[][] arr) {

        int[][] cache = new int[arr.length][arr[0].length];

        return max(arr, cache, true, 0, 0, -1, -1);

    }
   /*
    *           {1, 4, 5},
                {2, 0, 0}
    * */

    private static int max(int[][] arr, int[][] cache, boolean optional, int row, int col, int prevRow, int prevCol) {
        if (!isInBounds(arr, row, col) || cache[row][col] == -1) return 0;

        cache[row][col] = -1;


        int max = 0;
        int excluded = getMaxIncluded(arr, cache, optional, row, col, prevRow, prevCol);
        if (optional) {
            int included = arr[row][col] + getMaxIncluded(arr, cache, optional, row, col, prevRow, prevCol);

            max = Math.max(included, excluded);
        } else {
            max = excluded;
        }
        return max;
    }

    private static boolean isInBounds(int[][] arr, int row, int col) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }

    private static int getMaxIncluded(int[][] arr, int[][] cache, boolean optional, int row, int col, int prevRow, int prevCol) {
//        if (cache[row][col])

        int[][] directions = new int[8][2];

        int[] n = new int[]{row - 1, col};
        directions[0] = n;
        int[] nw = new int[]{row - 1, col - 1};
        directions[1] = nw;
        int[] ne = new int[]{row - 1, col + 1};
        directions[2] = ne;
        int[] w = new int[]{row, col - 1};
        directions[3] = w;
        int[] e = new int[]{row, col - 1};
        directions[4] = e;
        int[] s = new int[]{row + 1, col};
        directions[5] = s;
        int[] sw = new int[]{row + 1, col - 1};
        directions[6] = sw;
        int[] se = new int[]{row + 1, col + 1};
        directions[7] = se;


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < directions.length; i++) {
            int rowC = directions[i][0];
            int colC = directions[i][1];
            int current = 0;
            if (!isOneAway(rowC, colC, prevRow, prevCol)) {
                current = max(arr, cache, !optional, rowC, colC, row, col);
            } else {
                current = max(arr, cache, optional, rowC, colC, row, col);
            }

            if (current > max) max = current;
        }

        return max;
    }

    private static boolean isOneAway(int rowC, int colC, int prevRow, int prevCol) {
        if (Math.abs(rowC - prevRow) == 0 || Math.abs(colC - prevCol) == 0) return true;

        return false;
    }
}
