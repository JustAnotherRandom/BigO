package bigO.tests.sorting;

import bigO.src.sorting.FindKthSmallest;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Stanimir on 6/17/17.
 */
public class FindKthSmallestTest {

    @Test
    public void findKthSmallestUnique() {
        int[] input = {19, 7, 4, 9, 21, 3};
        int k = 2;
        int[] result = FindKthSmallest.findKthSmallest(input, k);


        Arrays.sort(result);
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            assertTrue(result[i] >= min);
            min = result[i];
        }
    }
}
