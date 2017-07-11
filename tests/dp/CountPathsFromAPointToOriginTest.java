package bigO.tests.dp;

import bigO.src.dp.CountPathsFromAPointToOrigin;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stanimir on 6/14/17.
 */
public class CountPathsFromAPointToOriginTest {

    @Test
    public void countTopDownDP() {
        assertEquals(84, CountPathsFromAPointToOrigin.topDownDP(3, 6));

    }

    @Test
    public void countBottomUpDP() {
        assertEquals(84, CountPathsFromAPointToOrigin.bottomUpDP(3, 6));
    }
}
