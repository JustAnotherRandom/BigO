package bigO.src.practice.trees;

import bigO.src.practice.trees.utils.BinarySearchTree;

/**
 * Created by Stanimir on 5/26/17.
 */
public class TreeLevelTraversal {

    public static void main(String[] str) {
        /*
        *           5
        *       3           10
        *   1       4   7       12
        *
        * Queue-->
        *  queue.addFirst(root)
        *
        * while(!queue.isEmpty())
        *  current  = queue.remove()
        *  process(current)
        *  addChildren--> A,B
        *
        *
        *  Root,A,B,C.D,E.F
        * */

        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(10);
        tree.addNode(1);
        tree.addNode(4);
        tree.addNode(7);
        tree.addNode(12);
        tree.print();

    }

}
