package bigO.src.practice.fb_interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/10/17.
 */
public class MatrixGenerateDiagonals {

    public static void main(String[] str) {
        // @formatter:off

        int[][] mat = new int[][]{
                {1,  2,  3,  4,  5,  6,  7},
                {8,  9,  10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 37, 39, 40, 41, 42},
                {43, 44, 45, 46, 47, 48, 49},
        };
        ArrayList<List<Integer>> list = new ArrayList();
        for(int i = 0; i < mat.length; i++) {
             list.add(getList(mat[i]));
        }

        ArrayList<ArrayList<Integer>> res = diagonal(list);
        //  @formatter:on

        for (List<Integer> rows : res) {
            for (Integer row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> getList(int[] ints) {
//        return IntStream.of(ints).boxed().collect(Collectors.toList());
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<List<Integer>> a) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int col = 0; col < a.size(); col++) {
            int c = col;
            int r = 0;
            ArrayList<Integer> diag = new ArrayList<>();
            res.add(diag);
            for (int i = 0; i <= col; i++) {
                diag.add(a.get(r++).get(c--));
            }
        }

        for (int row = 1; row < a.size(); row++) {
            int r = row;
            int c = a.size() - 1;
            ArrayList<Integer> diag = new ArrayList<>();
            res.add(diag);
            for (int i = 0; i < (a.size() - row); i++) {
                diag.add(a.get(r++).get(c--));
            }
        }


        return res;
    }

}
