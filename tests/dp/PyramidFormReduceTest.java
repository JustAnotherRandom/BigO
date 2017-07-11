package bigO.tests.dp;

import bigO.src.dp.PyramidFormReduce;
import org.junit.Test;

/**
 * Created by Stanimir on 6/15/17.
 */
public class PyramidFormReduceTest {

    @Test
    public void formPyramid() {
        int[] arr = {1, 2, 3, 4, 2, 1};
        int n = arr.length;
        System.out.println(PyramidFormReduce.minPyramidCost(arr, n));

//        arr =new int[] {1, 5, 2};
//        n = arr.length;
//        System.out.println(PyramidFormReduce.minPyramidCost(arr, n));
//
//
//        arr =new int[] {1, 2, 1};
//        n = arr.length;
//        System.out.println(PyramidFormReduce.minPyramidCost(arr, n));
    }
}
