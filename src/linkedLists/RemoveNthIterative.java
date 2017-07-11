package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 2/28/17.
 */
public class RemoveNthIterative {

    public static void main(String[] str) {
        //a,board,c,d
        RemoveNthIterative r = new RemoveNthIterative();
        Node d = new Node("d");
        Node c = new Node("c", d);
        Node b = new Node("board", c);
        Node a = new Node("a", b);

//        VertexImpl.print(a);
        Node nth = r.findNth(a, 0);
//        VertexImpl.print(nth);
        System.out.println(nth.key);

    }

    private Node findNth(Node head, int k) {
        Node first = head;
        Node second = head;

        //first = first +k
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;


    }
}
