package bigO.tests.practice.crackingthecodinginterview;

import bigO.lib.AssortedMethods;
import bigO.src.practice.crackingthecodinginterview.WordRectangle17_25;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Stanimir on 6/23/17.
 */
public class WordRectangle17_25Test {

    @Test
    public void testFindMaxRectangle() throws Exception {
        String[] words = AssortedMethods.getListOfWords();

        WordRectangle17_25 app = new WordRectangle17_25();
        WordRectangle17_25.Rectangle maxRectangle = app.findMaxRectangle(words);
        assertNotNull(maxRectangle);
    }
}
