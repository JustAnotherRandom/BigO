package bigO.tests.practice.crackingthecodinginterview;

import bigO.src.practice.crackingthecodinginterview.BuildOrder_4_7;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Stanimir on 6/27/17.
 */
public class BuildOrder_4_7Test {

    @Test
    public void testResolveBuildOrder() throws Exception {

        List<Character> projects = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        List<Character[]> dependencies = Arrays.asList(
                new Character[]{'a', 'd'},
                new Character[]{'f', 'b'},
                new Character[]{'b', 'd'},
                new Character[]{'f', 'a'},
                new Character[]{'d', 'c'}
        );

        List<Character> res = BuildOrder_4_7.resolveBuildOrder(projects, dependencies);
        res.stream().forEach(System.out::print);
        assertEquals(projects.size(), res.size());
        assertTrue('f' == res.get(0));
        assertTrue('a' == res.get(1));
        assertTrue('b' == res.get(2));
        assertTrue('d' == res.get(3));
        assertTrue('c' == res.get(4));
        assertTrue('e' == res.get(5));
    }

    @Test(expected = RuntimeException.class)
    public void testResolveBuildOrderCircularDependency() throws Exception {

        List<Character> projects = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        List<Character[]> dependencies = Arrays.asList(
                new Character[]{'a', 'd'},
                new Character[]{'f', 'b'},
                new Character[]{'b', 'd'},
                new Character[]{'d', 'b'},
                new Character[]{'f', 'a'},
                new Character[]{'d', 'c'}
        );

        List<Character> res = BuildOrder_4_7.resolveBuildOrder(projects, dependencies);
        res.stream().forEach(System.out::print);
    }
}
