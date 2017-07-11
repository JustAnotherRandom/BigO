package bigO.tests.trees;

import bigO.common.TreePrinter;
import bigO.src.trees.RedBlackTree;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Stanimir on 6/16/17.
 */
public class RedBlackTreeTest {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    @Test
    public void leftLeft() {// LEFT LEFT --> Single Rotate Right
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        add(13, tree);
        add(10, tree);
        add(5, tree);//rotateRight

        TreePrinter.printRedBlackTree(tree);
        RedBlackTree.Entry root = tree.getRoot();
        assertTrue((Integer) root.getKey() == 10);
        assertTrue(root.isColor() == BLACK);
        assertTrue((Integer) root.getLeft().getKey() == 5);
        assertTrue(root.getLeft().isColor() == RED);
        assertTrue((Integer) root.getRight().getKey() == 13);
        assertTrue(root.getRight().isColor() == RED);
    }

    @Test
    public void leftRight() {// LEFT RIGHT --> Rotate Left +  Rotate Right
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        add(13, tree);
        add(10, tree);
        add(1, tree);//rotateRight

        TreePrinter.printRedBlackTree(tree);
        RedBlackTree.Entry root = tree.getRoot();
        assertTrue((Integer) root.getKey() == 10);
        assertTrue(root.isColor() == BLACK);
        assertTrue((Integer) root.getLeft().getKey() == 5);
        assertTrue(root.getLeft().isColor() == RED);
        assertTrue((Integer) root.getRight().getKey() == 13);
        assertTrue(root.getRight().isColor() == RED);
    }

    @Test
    public void test() {
        Map<Integer, Integer> tree = new TreeMap<>();

        add(13, tree);
        add(10, tree);
        add(5, tree);//rotateRight

        System.out.printf("");
        Random r = null;
        r.nextInt(3);
    }

    private void add(int key, Map tree) {
        tree.put(key, null);
    }
}
