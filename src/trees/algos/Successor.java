package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/6/17.
 */
public class Successor {

    public static void main(String[] str) {
        Node r3 = new Node(3);
        Node r1 = new Node(1);
        Node r5 = new Node(5);


        Node r8 = new Node(8);
        Node r9 = new Node(9);
        Node r10 = new Node(10);
        Node r11 = new Node(11);

        Node root = new Node(6);
        root.children[0] = r3;
        root.children[1] = r8;

        r3.children[0] = r1;
        r3.children[1] = r5;

        r8.children[1] = r9;
        r9.children[1] = r10;

        r3.parent = root;
        r1.parent = r3;
        r5.parent = r3;
        r9.parent = r5;
        r8.parent = root;
        r9.parent = r8;


        System.out.println(successor(r1));

    }

    private static Node successor(Node node) {
        if (node == null) {
            return null;
        }

        if (node.children[1] != null) {
            return leftMost(node.children[1]);
        } else {
            Node parent = node.parent;
            while (parent.children[0] != node && parent != null) {

                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    private static Node leftMost(Node node) {
        while (node.children[0] != null) {
            node = node.children[0];
        }
        return node;

    }


}
