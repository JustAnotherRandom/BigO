package bigO.src.practice.crackingthecodinginterview;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/3/17.
 */
public class HistogramVolume17_20_Solution {

    public static void main(String[] str) {
        int[] his = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0}; //46
//        int[] his = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}; //26
        System.out.println(computeVolume(his));
    }

    private static int computeVolume(int[] his) {
        if (his.length <= 2) return 0;
        int[] leftIndixes = new int[his.length];
        int leftMax = his[0];
        for (int i = 1; i < his.length; i++) {
            leftMax = Math.max(leftMax, his[i]);
            leftIndixes[i] = leftMax;
        }

        System.out.println(Arrays.stream(leftIndixes).mapToObj(Integer::toString).collect(Collectors.joining(" ")));


        int sum = 0;
        int rightMax = his[his.length - 1];
        for (int i = his.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, his[i]);
            int secondTallest = Math.min(rightMax, leftIndixes[i]);

            if (secondTallest > his[i]) {
                sum += secondTallest - his[i];
            }
        }


        return sum;
    }

}
