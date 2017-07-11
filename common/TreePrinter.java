package bigO.common;

import bigO.src.trees.*;

import java.util.List;
import java.util.Stack;

/**
 * Created by Stanimir on 6/8/17.
 */
public class TreePrinter {


    public static <T> void printNAryTree(NAryTree<T> tree) {
        System.out.println(getString(tree.getRoot(), "", true));
    }

    private static <T> String getString(NAryNode<T> node, String prefix, boolean isTail) {
        if (node == null) return "";
        StringBuilder builder = new StringBuilder();

        builder.append(prefix + (isTail ? "└── " : "├── ") + " node={" + node.toString() + "}\n");
        List<NAryNode<T>> children = node.getChildren();

        if (children != null) {
            for (int i = 0; i < children.size() - 1; i++) {
                builder.append(getString(children.get(i), prefix + (isTail ? "    " : "│   "), false));
            }
            if (children.size() >= 1) {
                builder.append(getString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
            }
        }

        return builder.toString();
    }


    private static <T> String getString(AbstractAVLTreeMap.Entry node, String prefix, boolean isTail) {
        if (node == null) return "";
        StringBuilder builder = new StringBuilder();

        builder.append(prefix + (isTail ? "└── " : "├── ") + " node={" + node.toString() + "}\n");
        List<AbstractAVLTreeMap.Entry> children = node.getChildren();

        if (children != null) {
            for (int i = 0; i < children.size() - 1; i++) {
                builder.append(getString(children.get(i), prefix + (isTail ? "    " : "│   "), false));
            }
            if (children.size() >= 1) {
                builder.append(getString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
            }
        }

        return builder.toString();
    }

    public static void displayTree(AbstractAVLTreeMap.Entry root) {
        Stack<AbstractAVLTreeMap.Entry> globalStack = new Stack<>();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while (isRowEmpty == false) {

            Stack<AbstractAVLTreeMap.Entry> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                AbstractAVLTreeMap.Entry temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getKey() + "[" + temp.getHeight() + "]");
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("****......................................................****");
    }

    //TODO update to Navigable map
    public static void printBinaryTree(AvlTreeMapRecursive tree) {
//        AbstractAVLTreeMap.Entry<K, V> root = (AbstractAVLTreeMap.Entry<K, V>) tree.firstEntry();
        displayTree(tree.getRoot());
        System.out.printf("");

    }

    public static void printRedBlackTree(RedBlackTree tree) {
//        AbstractAVLTreeMap.Entry<K, V> root = (AbstractAVLTreeMap.Entry<K, V>) tree.firstEntry();
        printBinaryTree(tree.getRoot());
        System.out.printf("");

    }

    public static void printBinaryTree(RedBlackTree.Entry root) {
        Stack<RedBlackTree.Entry> globalStack = new Stack<>();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while (isRowEmpty == false) {

            Stack<RedBlackTree.Entry> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                RedBlackTree.Entry temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getKey() + "[" + getColor(temp) + "]");
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("****......................................................****");
    }

    private static String getColor(RedBlackTree.Entry temp) {
        return temp.isColor() ? "BLACK" : "RED";
    }
}
