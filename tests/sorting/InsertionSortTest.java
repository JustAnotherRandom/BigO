package bigO.tests.sorting;

import bigO.src.sorting.InsertionSort;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stanimir on 6/14/17.
 */
public class InsertionSortTest {

    @Test
    public void sort() {
        int[] arr = {2, 6, 3, 12, 56, 8};
        InsertionSort.sort(arr);
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }
}
