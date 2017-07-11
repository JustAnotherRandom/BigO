package bigO.src.practice.google.strings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/28/17.
 */
public class MaxSumRectangle2DMatrix {

    public static void main(String[] args) throws java.lang.Exception {
        PriorityQueue pq;
        findMaxSubMatrix(new int[][]{
                {1,   2,-1, -4, -20},
                {-8, -3, 4,  2,  1},
                {3,   8, 10, 1,  3},
                {-4, -1, 1,  7,  -6}
        });
    }

    /**
     * To find maxSum in 1d array
     * <p>
     * return {maxSum, left, right}
     */
    public static int[] kadane(int[] a) {

        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                localStart = i + 1;
            } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }

        //all numbers in a are negative
        if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(" ")) + " sum:" + result[0]);
        System.out.println();
        return result;
    }

    /**
     * To find and print maxSum, (left, top),(right, bottom)
     */
    public static void findMaxSubMatrix(int[][] a) {
        int cols = a[0].length;
        int rows = a.length;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;

        for (int leftCol = 0; leftCol < cols; leftCol++) {
            int[] tmp = new int[rows];

            for (int rightCol = leftCol; rightCol < cols; rightCol++) {

                for (int i = 0; i < rows; i++) {
                    tmp[i] += a[i][rightCol];
                }
                int[] currentResult = kadane(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    left = leftCol;
                    top = currentResult[1];
                    right = rightCol;
                    bottom = currentResult[2];
                }
            }
        }
        System.out.println("MaxSum: " + maxSum +
                ", range: [(" + left + ", " + top +
                ")(" + right + ", " + bottom + ")]");
    }

}
