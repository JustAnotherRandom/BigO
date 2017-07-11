package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/5/17.
 */
public class ValiateBST {

    public static void main(String[] str) {
        Node r3 = new Node(4);
        Node r1 = new Node(1);
        Node r5 = new Node(5);


        Node r8 = new Node(8);
        Node r9 = new Node(9);
        Node r10 = new Node(10);
        Node r11 = new Node(11);

        Node root = new Node(6);
        root.children[0] = r3;
        root.children[1] = r8;

//        r3.children[0] = r1;
//        r3.children[1] = r5;
//
//        r8.children[1] = r9;
//        r9.children[1] = r10;

        System.out.println(validate(root));
    }

    private static boolean validate(Node root) {
        if (root == null) return true;

        if (root.children[0] != null && (root.children[0].compareTo(root)) > 0) return false;
        if (root.children[1] != null && (root.children[1].compareTo(root)) < 0) return false;
        return validate(root.children[0]) && validate(root.children[1]);
    }

}
