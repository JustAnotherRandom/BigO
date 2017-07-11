package bigO.src.practice.geeksforgeeks;

import java.util.stream.Stream;

/**
 * Created by Stanimir on 5/30/17.
 */
public class MatrixReplaceXWithO {
    public static final char NEW = 'X';
    public static final char OLD = 'O';
    public static final char TEMP = '-';

    public static void main(String[] str) {
        char[][] mat = new char[][]{
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
        };
        Stream.of(mat).flatMap(Stream::of).forEach(System.out::println);

        resolve(mat);
        System.out.println("");
        Stream.of(mat).flatMap(Stream::of).forEach(System.out::println);
    }

    private static void resolve(char[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                fill(mat, row, col, OLD, TEMP);
            }
        }


        for (int i = 0; i < mat[0].length; i++) {
            fill(mat, 0, i, TEMP, OLD);
        }
        for (int i = 0; i < mat[0].length; i++) {
            fill(mat, mat.length - 1, i, TEMP, OLD);
        }
        for (int i = 0; i < mat.length; i++) {
            fill(mat, i, 0, TEMP, OLD);
        }
        for (int i = 0; i < mat.length; i++) {
            fill(mat, i, mat.length - 1, TEMP, OLD);
        }

        for (int row = 1; row < mat.length; row++) {
            for (int col = 1; col < mat[0].length; col++) {
                fill(mat, row, col, TEMP, NEW);
            }
        }
    }

    public static void fill(char[][] mat, int row, int col, char oldC, char newC) {
        if (!isInBounds(mat, row, col)) return;
        if (mat[row][col] != oldC) return;

        mat[row][col] = newC;
        fill(mat, row - 1, col, oldC, newC);
        fill(mat, row + 1, col, oldC, newC);
        fill(mat, row, col - 1, oldC, newC);
        fill(mat, row, col + 1, oldC, newC);
    }


    private static boolean isInBounds(char[][] mat, int row, int col) {
        return row >= 0 && col >= 0 && row < mat.length && col < mat[0].length;
    }

}
