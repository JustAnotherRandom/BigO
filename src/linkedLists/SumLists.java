package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 3/17/17.
 */
public class SumLists {

    public static void main(String[] str) {
//        VertexImpl _6 = new VertexImpl("6", null);
        Node _1 = new Node("5", null);
        Node _7 = new Node("3", _1);

        Node _2 = new Node("9", null);
        Node _9 = new Node("8", _2);
        Node _5 = new Node("0", _9);

        print(_7);
        System.out.println();
        print(_5);
        System.out.println();
        Node result = sum(_7, _5);
        print(result);

    }

    private static Node print(Node node) {
        if (node != null) {
            Node temp = node;
            node = print(node.next);
            System.out.println(temp.key);

        }
        return null;

    }

    private static Node sum(Node p1, Node p2) {
        int c = 0;
        Node res = null;
        Node head = null;

        while (p1 != null || p2 != null) {
            p1 = p1 != null ? p1 : new Node("0", null);
            p2 = p2 != null ? p2 : new Node("0", null);

            int t = Integer.valueOf(p1.key) + Integer.valueOf(p2.key) + c;
            c = (t / 10 != 0) ? 1 : 0;
            Node n = new Node(String.valueOf(t % 10), null);
            if (res == null) {
                res = n;
                res.next = n;
                head = n;
            } else {
                head.next = n;
                head = n;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        if (c > 0) {
            head.next = new Node("1", null);
        }
        return res;
    }

}
