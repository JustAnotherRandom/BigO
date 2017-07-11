package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 3/7/17.
 */
public class LoopDetector {

    public static void main(String[] str) {

        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        e.next = c;
        Node b = new Node("board", c);
        Node a = new Node("a", b);

        b.next = a;


        System.out.println(loopDetection(a));
    }

    private static Node loopDetection(Node node) {
        if (node == null) return null;

        Node first = node;
        Node second = node;

        while (second != null) {


            second = second.next;
            if (first.next != null && first.next.next != null) {
                first = first.next.next;
            } else {
                return null;
            }
            if (first == second) break;
        }
        first = node;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

}
