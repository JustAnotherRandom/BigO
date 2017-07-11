package bigO.src.practice.trees;


import bigO.src.trees.algos.Node;

/**
 * Created by Stanimir on 6/2/17.
 * <p>
 * 10
 * 5       15
 * 1      7  12  18
 */
public class IsSubtreeOfAnotherTree {

    public static void main(String[] str) {
        Node root = new Node(10);
        Node node5 = new Node(5);
        root.setLeftChild(node5);
        Node node1 = new Node(1);
        node5.setLeftChild(node1);
        Node node7 = new Node(7);
        node5.setRightChild(node7);

        Node node15 = new Node(15);
        Node node18 = new Node(18);
        root.setRightChild(node15);
        node15.setRightChild(node18);

        Node node12 = new Node(12);
        node15.setLeftChild(node12);


        System.out.println(isSubTree(node15, root));
    }

    private static boolean isSubTree(Node B, Node root) {
        if (root == null && B == null) return true;
        if (root == null) return false;
        if (B == null) return false;

        boolean result = false;
        if (root.equals(B)) {
            boolean left = isSubTree(B.children[0], root.children[0]);
            boolean right = isSubTree(B.children[1], root.children[1]);
            result = left && right;
        } else {
            boolean left = isSubTree(B, root.children[0]);
            boolean right = isSubTree(B, root.children[1]);
            result = left || right;
        }


        return result;
    }

}
