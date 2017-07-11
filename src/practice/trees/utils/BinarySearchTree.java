package bigO.src.practice.trees.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Stanimir on 5/26/17.
 */
public class BinarySearchTree<T extends Comparable> {

    public Node root;
    private static String SPACE = " ";


    /*
        *           5
        *       3           10
        *   1       4   7       12
    *  */
    public void addNode(T id) {
        if (root == null) {
            root = new Node(id);
        } else {

            insert(root, id);
        }
    }

    private void insert(Node root, T id) {
        Node parent = root;
        Node focusNode = root;
        boolean isLeft = false;
        while (focusNode != null) {
            parent = focusNode;
            int cmp = id.compareTo(focusNode.id);
            if (cmp < 0) {
                isLeft = true;
                focusNode = focusNode.left();
            } else if (cmp > 0) {
                isLeft = false;
                focusNode = focusNode.right();
            } else {
                // already exist
                return;
            }
        }
        Node newNode = new Node(id);
        if (isLeft) {
            parent.children[0] = newNode;
        } else {
            parent.children[1] = newNode;
        }
    }

    /*
        *           5
        *       3           10
        *   1       4   7       12
    *  */
    public void print() {

        StringBuilder sb = new StringBuilder();
        int treeHeight = findTreeHeight(root);
//        System.out.println(treeHeight);

        Deque<Node> q = new ArrayDeque<>();
        q.add(root);

        int elementsInLevel = 1;

        int level = 1;
        while (!q.isEmpty()) {
            for (int index = 1; index <= elementsInLevel; index++) {
                appendSpaces(sb, index, treeHeight, level);
                Node element = q.remove();
                sb.append(element);
                addChildren(q, element);
            }
            sb.append("\n");
            elementsInLevel *= 2;
            level++;
        }
        System.out.println(sb.toString());
    }

    private void appendSpaces(StringBuilder sb, int index, int treeHeight, int level) {
        //2
        //1

        int floor = treeHeight - level;
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;


        int spaces = index == 1 ? firstSpaces : betweenSpaces;

        for (int i = 0; i < spaces; i++) {
            sb.append(SPACE);
        }
    }


    private void addChildren(Deque<Node> q, Node element) {
        if (element.left() != null) q.add(element.left());
        if (element.right() != null) q.add(element.right());
    }

    private int findTreeHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = findTreeHeight(root.left());
        int rightHeight = findTreeHeight(root.right());

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
