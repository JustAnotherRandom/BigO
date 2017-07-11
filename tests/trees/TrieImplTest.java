package bigO.tests.trees;

import bigO.src.trees.Trie;
import bigO.src.trees.TrieImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Stanimir on 6/29/17.
 */
public class TrieImplTest {


    @Test
    public void testStartsWith() throws Exception {
        Trie trie = buildTree();
        assertTrue(trie.contains("dov"));
        assertFalse(trie.contains("dova"));
    }

    @Test
    public void testInsertAndContains() throws Exception {
        Trie trie = buildTree();
        assertTrue(trie.contains("zebra"));
        assertTrue(trie.contains("dog"));
        assertTrue(trie.contains("duck"));
        assertTrue(trie.contains("dove"));


    }

    private Trie buildTree() {
        Trie trie = new TrieImpl();
        trie.insert("zebra");
        trie.insert("dog");
        trie.insert("duck");
        trie.insert("dove");
        return trie;
    }

    @Test
    public void testRemove() throws Exception {
        Trie trie = buildTree();
        assertTrue(trie.contains("zebra"));
        trie.remove("zebra");
        assertFalse(trie.contains("zebra"));
    }
}
