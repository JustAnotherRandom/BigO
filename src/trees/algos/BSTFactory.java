package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/18/17.
 */
public class BSTFactory {

    public static Node buildBST() {
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

        r8.children[0] = r9;
        r8.children[1] = r10;

        r3.parent = root;
        r1.parent = r3;
        r5.parent = r3;
        r9.parent = r5;
        r8.parent = root;
        r9.parent = r8;
        return root;
    }

}
