package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 5/27/17.
 */
public class IsToeplitzMAtrix {

    public static void main(String[] str) {
        int[][] mat = new int[][]
                {
                        {6, 7, 8, 9},
                        {4, 6, 7, 8},
                        {1, 4, 6, 7},
                        {0, 1, 4, 6},
                        {2, 0, 1, 4}
                };
        System.out.printf(verify(mat) + "");
    }


    static boolean verify(int[][] m) {
        for (int row = 1; row < m.length; row++) {
            for (int col = 1; col < m[0].length; col++) {
                int diag = m[row - 1][col - 1];
                if (diag != m[row][col]) {
                    return false;
                }

            }
        }
        return true;
    }


}
