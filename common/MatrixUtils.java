package bigO.common;

import java.util.Arrays;

/**
 * Created by Stanimir on 6/2/17.
 */
public class MatrixUtils {

    public static void main(String[] args) {
        final int[][] matrix = new int[4][4];
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .forEach(
                        (row) -> {
                            System.out.print("[");
                            Arrays.stream(row)
                                    .forEach((el) -> System.out.print(" " + el + " "));
                            System.out.println("]");
                        }
                );
    }

}
