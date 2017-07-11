package bigO.tests.dp;

import bigO.src.dp.FindMaxSumNotAdjacentMatrix;
import org.junit.Test;

/**
 * Created by Stanimir on 6/18/17.
 */
public class FindMaxSumNotAdjacentMatrixTest {

    @Test
    public void test() {
        int[][] in = {
                {1, 4, 5},
                {2, 0, 0}
        };
        System.out.println(FindMaxSumNotAdjacentMatrix.maxSum1(in));
    }
}
