package bigO.tests.practice.crackingthecodinginterview;

import bigO.src.practice.crackingthecodinginterview.MultiSearch_17_17;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Stanimir on 6/19/17.
 */
public class MultiSearch_17_17Test {

    //    @Test
    public void testSearchAll() throws Exception {
        String[] T = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        List<String> res = MultiSearch_17_17.searchAll("mississippi", T);
//        res.stream().forEach(System.out::println);
        Set<String> helper = new HashSet<>(res);
        assertTrue(helper.contains("is"));
        assertTrue(helper.contains("ppi"));
        assertTrue(helper.contains("sis"));
        assertTrue(helper.contains("i"));
        assertTrue(helper.contains("ssippi"));
    }


    /*
    *
    * ppi
i
ssippi
*/
    @Test
    public void testTrie1() throws Exception {
        String[] T = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        List<List<Integer>> res = MultiSearch_17_17.searchAllTrie2("mississippi", T);

//        Set<String> helper = new HashSet<>(res);
//        assertTrue(helper.contains("is"));
//        assertTrue(helper.contains("ppi"));
//        assertTrue(helper.contains("sis"));
//        assertTrue(helper.contains("i"));
//        assertTrue(helper.contains("ssippi"));

    }
}
