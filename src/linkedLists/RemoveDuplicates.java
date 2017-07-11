package bigO.src.linkedLists;


import bigO.src.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stanimir on 2/27/17.
 */
public class RemoveDuplicates {

    public static void removeDips(Node n) {
        Set<Node> nodes = new HashSet<>();
        Node head = n;
        Node prev = null;
        while (n != null) {
            if (nodes.contains(n)) {
                prev.next = n.next;
            } else {
                nodes.add(n);
                prev = n;
            }
            n = n.next;
        }
        System.out.println("?");
    }

    public static void main(String[] str) {
        Node d = new Node("d");
        Node c = new Node("a", d);
        Node b = new Node("board", c);
        Node a = new Node("a", b);

        Node.print(a);
        System.out.println();
        RemoveDuplicates.removeDips(a);
        Node.print(a);

    }

}
