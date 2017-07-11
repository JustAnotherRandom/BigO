package bigO.src.practice.google.sequences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Stanimir on 6/12/17.
 */
public class ReconstructLineByHEigthMine {

    public static void main(String[] str) {
        int[][] input = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] res = reconstruct(input);
//        int[][] res = input;
        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "] ");

        }
    }

    static int[][] reconstruct(int[][] in) {
        Comparator cmp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] first = (int[]) o1;
                int[] second = (int[]) o2;
                if (first[0] < second[0]) {
                    return -1;
                } else if (first[0] > second[0]) {
                    return 1;
                } else {
                    if (first[1] <= second[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }

        };
        Arrays.sort(in, cmp);

        LinkedList<int[]> sorted = new LinkedList<int[]>();
        for (int[] foo : in) {
            sorted.add(foo);
        }

        LinkedList<int[]> result = new LinkedList<>();
        result.add(sorted.removeFirst());

        while (!sorted.isEmpty()) {
            int[] first = sorted.removeFirst();

            ListIterator ri =(ListIterator) result.iterator();
            while (ri.hasNext()){
                int[] next = (int[]) ri.next();

            }

        }

        int[][] res = new int[result.size()][2];
        int i = 0;
        for (int[] e : result) {
            res[i++] = e;
        }

        return res;
    }

}
