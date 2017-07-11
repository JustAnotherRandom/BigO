package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 2/27/17.
 */
public class RemoveNthRecursive {


    class Index {
        int i = 0;

        public void increment() {
            i++;
        }

        public int getIndex() {
            return i;
        }
    }

    private Node findNth(Node n, int k) {
        if (n == null) return null;
        Node next = findNth(n, k, new Index());
        return next;
    }

    private static Node findNth(Node head, int k, Index i) {
        if (head == null) {

            return null;
        }

        Node next = findNth(head.next, k, i);

        i.increment();

        if (i.getIndex() == k) {
            return head;
        }
        return next;
    }

    public static void main(String[] str) {
        //a,board,c,d
        RemoveNthRecursive r = new RemoveNthRecursive();
        Node d = new Node("d");
        Node c = new Node("c", d);
        Node b = new Node("board", c);
        Node a = new Node("a", b);

//        VertexImpl.print(a);
        Node nth = r.findNth(a, 2);
//        VertexImpl.print(nth);
        System.out.println(nth.key);

    }


}

