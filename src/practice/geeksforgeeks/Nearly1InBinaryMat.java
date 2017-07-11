package bigO.src.practice.geeksforgeeks;

import bigO.common.MatrixUtils;
import bigO.src.practice.utils.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stanimir on 6/2/17.
 */
public class Nearly1InBinaryMat {

    public static void main(String[] str) {
        int[][] mat = new int[][]{{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}};

        MatrixUtils.printMatrix(mat);
        System.out.println();

        int[][] res = solve(mat);

        MatrixUtils.printMatrix(res);
    }

    private static int[][] solve(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];


        Set<Point> visited = new HashSet<>();
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (res[row][col] == 0 && mat[row][col] != 1) {
                    nearlest(mat, res, row, col, visited);
                }
            }
        }

        return res;
    }

    private static int nearlest(int[][] mat, int[][] res, int row, int col, Set<Point> visited) {

        if (!isInBounds(row, col, mat)) return -1;
        if (visited.contains(new Point(row, col))) return Integer.MAX_VALUE;
        if (res[row][col] != 0) return res[row][col] + 1;


        if (mat[row][col] == 1) return 1;
        visited.add(new Point(row, col));

        int top = nearlest(mat, res, row - 1, col, visited);
        int left = nearlest(mat, res, row, col - 1, visited);
        int right = nearlest(mat, res, row, col + 1, visited);
        int down = nearlest(mat, res, row + 1, col, visited);

        int result = min(top, left, right, down);
        res[row][col] = result;
        return result + 1;
    }

    private static boolean isInBounds(int row, int col, int[][] mat) {
        return row >= 0 && col >= 0 && row < mat.length && col < mat[0].length;
    }

    public static Integer min(Integer... vals) {

        Integer ret = null;
        for (Integer val : vals) {
            if (val >= 0) {
                if (val == 0) return 0;
                if (ret == null || (val != null && val < ret)) {
                    ret = val;
                }
            }
        }
        return ret;
    }

}
