package bigO.src.practice.sorts;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/1/17.
 */
public class SortOnWaves {

    public static void main(String[] str) {
        int[] in = new int[]{2, 4, 6, 8, 10, 20};
        sort(in);
        System.out.println(Arrays.stream(in).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    public static void sort(int[] in) {
        if (in.length < 1) return;


        boolean rising = false;
        for (int i = 1; i < in.length; i++) {
            if (rising) {
                if (in[i] < in[i - 1]) {
                    swap(in, i, i - 1);
                }
                rising = !rising;
            } else {
                if (in[i] > in[i - 1]) {
                    swap(in, i, i - 1);
                }
                rising = !rising;
            }
        }
    }

    private static void swap(int[] in, int a, int b) {
        int temp = in[a];
        in[a] = in[b];
        in[b] = temp;
    }

}
