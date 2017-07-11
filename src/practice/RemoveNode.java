package bigO.src.practice;

import bigO.src.Node;

/**
 * Created by Stanimir on 3/7/17.
 */
public class RemoveNode {

    public static void main(String[] str) {
        Node d = new Node("d");
        Node c = new Node("c", d);
        Node b = new Node("board", c);
        Node a = new Node("a", b);

        Node.print(a);
        System.out.println();
        RemoveNode.removeNode(b);
        Node.print(a);
    }

    private static void removeNode(Node prev) {
        if (prev == null) return; // (( throw ex)

        Node next = prev.next;

        while (next != null) {
            prev.key = next.key;
            if (next.next == null) {
                prev.next = null;
            } else {

                prev = next;
            }
            next = next.next;
        }
        prev.next = null;

    }


}
