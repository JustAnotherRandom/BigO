package bigO.src.arrays;

/**
 * Created by Stanimir on 3/9/17.
 */
public class MatrixRotation {

    public static void main(String[] str) {
        int[][] square = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        print(square);
        transpose(square);
        print(square);
        verticalReflection(square);
        print(square);

    }

    private static void verticalReflection(int[][] square) {
        int len = (square.length ) - 1;
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length / 2; j++) {
                int temp = square[len - j][i];
                square[len - j][i] = square[j][i];
                square[j][i] = temp;
            }
        }
    }

    private static void transpose(int[][] square) {

        for (int i = 0; i < square.length; i++) {
            for (int j = i; j < square[0].length; j++) {
                int temp = square[i][j];
                square[i][j] = square[j][i];
                square[j][i] = temp;

            }
        }
    }

    private static void print(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int findDigits(int num) {
        int res = 1;
        while (num >= 10) {
            num /= 10;
            res++;
        }
        return res;
    }
}
