package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/5/17.
 */
public class IsBalanced {

    public static void main(String[] str) {
        int[] in = new int[]{3, 5, 6, 7, 8, 9, 10, 11, 12};
//        int[] in = new int[]{3, 5, 6};


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
//        r10.children[1] = r11;


        System.out.println(isBalancedTree(root));
    }

    private static boolean isBalancedTree(Node root) {
        if (root == null) return true;

        int leftDepth = visit(root.children[0]);
        int rigthDepth = visit(root.children[1]);
        return Math.abs(leftDepth - rigthDepth) <= 1;
    }

    private static int visit(Node root) {
        if (root == null) return 0;

        return 1 + (Math.max(visit(root.children[0]), visit(root.children[1])));

    }

}
