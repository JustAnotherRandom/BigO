package bigO.src.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stanimir on 2/25/17.
 */
public class KPlusExistNumberTimes {


    public int calcNumPairForDiff(int[] in, int k) {
        int count = 0;
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < in.length; i++) {
            cache.add(in[i]);
        }

        for (int i = 0; i < in.length; i++) {
            if (cache.contains(in[i] + k)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] str) {
        KPlusExistNumberTimes k = new KPlusExistNumberTimes();

        System.out.println(k.calcNumPairForDiff(new int[]{1, 7, 5, 9, 2, 12, 3}, 4));
    }
}
