package bigO.tests.dp;

import bigO.src.dp.MaxSumNotAdjacentInList;
import org.junit.Test;

/**
 * Created by Stanimir on 6/17/17.
 */
public class MaxSumNotAdjacentInListTest {

    @Test
    public void maxSum() {
        int[] in = {5, 5, 10, 100, 10, 5};
        System.out.println(MaxSumNotAdjacentInList.maxSum(in));
        System.out.println(MaxSumNotAdjacentInList.findMaxSum(in, in.length));

        System.out.println(MaxSumNotAdjacentInList.findMaxSumBottomupMine(in));

    }
}
