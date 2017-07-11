package bigO.tests.practice.crackingthecodinginterview;

import bigO.src.practice.crackingthecodinginterview.ContiniousMedian_17_20;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stanimir on 6/20/17.
 */
public class ContiniousMedianTest {
    @Test
    public void test() {
        ContiniousMedian_17_20 app = new ContiniousMedian_17_20();

        int[] numbers = {4, 8, 6, 2, 10, 12};
        int[] expectedResults = {4, 6, 6, 5, 6, 7};
        for (int i = 0; i < numbers.length; i++) {
            assertEquals(expectedResults[i], app.addElement(numbers[i]));
        }
    }
}
