package bigO.src.practice.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/30/17.
 * Better than Merge and QS in almost sorted bigO.src.arrays, (n) compared to nLog(n)
 */
public class InsertionSort {


    public void sort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            int key = in[i];
            int j = i - 1;

            while (j >= 0 && key < in[j]) {
                int temp = in[j];
                in[j] = in[j + 1];
                in[j + 1] = temp;
                System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
                j--;
            }
            in[j+1] = key;
        }
    }

    public static void main(String[] str) {
        InsertionSort app = new InsertionSort();
        int[] in = new int[]{12, 11, 13, 5, 6};
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        System.out.println();
        app.sort(in);
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

}
