package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 2/28/17.
 */
public class RemoveMiddleRecursive {

    public static void main(String[] str) {
        //a,board,c,d
        RemoveMiddleRecursive r = new RemoveMiddleRecursive();
        Node d = new Node("d");
        Node c = new Node("c", d);
        Node b = new Node("board", c);
        Node a = new Node("a", b);

        Node.print(a);
        System.out.println();
        r.removeNode(c);
        Node.print(a);


    }

    private boolean removeNode(Node head) {
        if (head == null || head.next == null) return false;
        Node next = head.next;

        head.next = next.next;
        head.key = next.key;
        return true;
    }
}


