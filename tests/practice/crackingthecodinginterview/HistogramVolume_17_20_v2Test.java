package bigO.tests.practice.crackingthecodinginterview;

import bigO.src.practice.crackingthecodinginterview.HistogramVolume_17_20_v2;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stanimir on 6/20/17.
 */
public class HistogramVolume_17_20_v2Test {

    @Test
    public void testCalculateVolume() throws Exception {
        HistogramVolume_17_20_v2 app = new HistogramVolume_17_20_v2();
        int[] his = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0}; //46
        assertEquals(46, app.calculateVolume(his));
        int[] his2 = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}; //26
        assertEquals(26, app.calculateVolume(his2));
        System.out.println(app.calculateVolume(his));
    }
}
