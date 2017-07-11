package bigO.src.practice.trees;

import bigO.src.trees.algos.Node;

/**
 * Created by Stanimir on 3/20/17.
 */
public class Successor {

    public static void main(String[] str) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        foo(10);
//        VertexImpl root = VertexImpl.createMinimalBST(array);
//        for (int i = 0; i < array.length; i++) {
//            VertexImpl node = root.find(array[i]);
//            VertexImpl next = inorderSucc(node);
//            if (next != null) {
//                System.out.println(node.value + "->" + next.value);
//            } else {
//                System.out.println(node.value + "->" + null);
//            }
//        }

    }
    static void foo(int n)
    {
        if(n!=0)
        {
            foo(--n);
        }
        System.out.print(n);
    }
    private static Node inorderSucc(Node node) {

        Node current = node;

        while (current.parent != null) {
            if (isOnTheRight(current)) {
                current = current.parent;
            } else {
                if (current.parent.children[1] == null) {
                    return current.parent;
                } else {
                    return leftMost(current.parent.children[1]);
                }
            }
        }
        return null;
    }

    private static Node leftMost(Node node) {

        while (node.children[0] != null) {
            node = node.children[0];
        }
        return node;
    }

    private static boolean isOnTheRight(Node node) {

        return node.parent.children[1].equals(node);
    }

}
