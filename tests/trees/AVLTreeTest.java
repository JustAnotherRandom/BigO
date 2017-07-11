package bigO.tests.trees;

import bigO.common.TreePrinter;
import bigO.src.trees.AbstractAVLTreeMap;
import bigO.src.trees.AvlTreeMapRecursive;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Stanimir on 6/9/17.
 */
public class AVLTreeTest {

    private static final Object PRESENT = new Object();

    //    @Test
    public void rotateWithLeftChild_Insert() {//rotate rigth
        AvlTreeMapRecursive<Integer, Object> tree = new AvlTreeMapRecursive();
        add(13, tree);
        add(10, tree);
        add(5, tree);//rotateRight

        TreePrinter.printBinaryTree(tree);
        AbstractAVLTreeMap.Entry root = tree.getRoot();
        assertTrue((Integer) root.getKey() == 10);
        assertTrue((Integer) root.getLeft().getKey() == 5);
        assertTrue((Integer) root.getRight().getKey() == 13);


    }

    //    @Test
    public void doubleRotateWithLeftChild_Insert() {
        boolean debug = false;
        AvlTreeMapRecursive<Integer, Object> tree = new AvlTreeMapRecursive();
        add(13, tree);
        add(15, tree);
        add(10, tree);
        add(16, tree);
        add(11, tree);
        add(5, tree);
        add(4, tree);
        add(6, tree);


        if (debug)
            TreePrinter.printBinaryTree(tree);
        add(7, tree);
        if (debug)
            TreePrinter.printBinaryTree(tree);

    }

    //    @Test
    public void rotateWithRightChild_Insert() {//rotate left
        AvlTreeMapRecursive<Integer, Object> tree = new AvlTreeMapRecursive();
        add(30, tree);
        add(5, tree);
        add(35, tree);
        add(32, tree);
        add(40, tree);
        add(45, tree);//Rotate left

        TreePrinter.printBinaryTree(tree);

        AbstractAVLTreeMap.Entry root = tree.getRoot();
        assertTrue((Integer) root.getKey() == 35);
        assertTrue(root.getHeight() == 2);
        assertTrue((Integer) root.getLeft().getKey() == 30);
        assertTrue(root.getLeft().getHeight() == 1);
        assertTrue((Integer) root.getLeft().getLeft().getKey() == 5);
        assertTrue((Integer) root.getLeft().getRight().getKey() == 32);

        assertTrue((Integer) root.getRight().getKey() == 40);
        assertTrue(root.getRight().getHeight() == 1);
        assertTrue((Integer) root.getRight().getRight().getKey() == 45);
    }

    @Test
    public void leftLeft_Remove() {
        AvlTreeMapRecursive<Integer, Object> tree = new AvlTreeMapRecursive();
        add(20, tree);
        add(25, tree);
        add(15, tree);
        add(30, tree);
        add(17, tree);
        add(10, tree);
        add(5, tree);
        add(12, tree);
        TreePrinter.printBinaryTree(tree);

        tree.remove(30);
        TreePrinter.printBinaryTree(tree);
    }

    private <K, V> void add(K key, Map<K, Object> map) {
        map.put(key, PRESENT);
    }
}
