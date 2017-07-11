package bigO.src.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Stanimir on 2/19/17.
 */
public class HasUniqueCharactersTest {

    @Test
    public void testHasUniqueCharacters1() {
        assertFalse(HasUniqueCharacters.hasUniqueCharacters("aa"));
        assertTrue(HasUniqueCharacters.hasUniqueCharacters("abc"));
        assertFalse(HasUniqueCharacters.hasUniqueCharacters("abca"));
        assertFalse(HasUniqueCharacters.hasUniqueCharacters("aabc"));
    }


}
