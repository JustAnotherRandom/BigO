package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 5/27/17.
 */
public class MatrixRectangleSums {

    static int[][] in = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    int[][] sum = new int[in.length][in[0].length];

    {
        for (int row = 0; row < in.length; row++) {
            for (int col = 0; col < in[0].length; col++) {
                int top = (row > 0 ? sum[row - 1][col] : 0);
                int left = (col > 0 ? sum[row][col - 1] : 0);
                int diag = (row > 0 && col > 0 ? sum[row - 1][col - 1] : 0);
                sum[row][col] = left + top + in[row][col] - diag;

            }
        }
    }

    public static void main(String[] str) {
        MatrixRectangleSums app = new MatrixRectangleSums();

        System.out.println(app.query(1, 1, 2, 2));
        System.out.println(app.query(1, 1, 2, 1));


    }

    private int query(int row1, int col1, int row2, int col2) {
        int top = sum[row1 - 1][col2];
        int left = sum[row2][col1 - 1];
        int diag = sum[row1 - 1][col1 - 1];
        return sum[row2][col2] - top - left + diag;
    }


}
