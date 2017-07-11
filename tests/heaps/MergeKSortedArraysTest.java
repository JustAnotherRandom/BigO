package bigO.tests.heaps;

import bigO.src.heaps.MergeKSortedArrays;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stanimir on 6/14/17.
 */
public class MergeKSortedArraysTest {

    @Test
    public void merge() {
        int k = 3, n = 4;
        int[][] input = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        int[] result = MergeKSortedArrays.merge(input);

        IntStream is = IntStream.empty();

        int[] ar = new int[]{1, 3, 5, 7, 2, 4, 6, 8, 0, 9, 10, 11};
        Arrays.sort(ar);

        for (int i = 0; i < ar.length; i++) {
            assertEquals(ar[i], result[i]);
        }
    }
}
