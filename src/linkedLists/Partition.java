package bigO.src.linkedLists;

import bigO.src.Node;

/**
 * Created by Stanimir on 2/28/17.
 */
public class Partition {

    public static void main(String[] str) {
        //a,board,c,d
        Partition r = new Partition();
        Node a7 = new Node("1");
        Node a6 = new Node("2", a7);
        Node a5 = new Node("10", a6);
        Node a4 = new Node("5", a5);
        Node a3 = new Node("8", a4);
        Node a2 = new Node("5", a3);
        Node a1 = new Node("3", a2);


//        VertexImpl a3 = new VertexImpl("1");
//        VertexImpl a2 = new VertexImpl("5", a3);
//        VertexImpl a1 = new VertexImpl("3", a2);

        Node.print(a1);
        System.out.println();
        Node res = r.partition(a1.clone(), 5);
        Node.print(res);
        System.out.println();
        Node res1 = r.partition1(a1.clone(), 5);
        Node.print(res1);


    }

    private Node partition(Node node, int x) {

        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.compareTo(new Node(String.valueOf(x))) < 0) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    private Node pNew(Node n, int x) {
        if (n == null) return n;
        Node trueHead = null;
        Node head = null;
        Node tail = null;

        while (n != null) {
            Node next = n.next;
            if (n.key.compareTo(String.valueOf(x)) < 0) {
                if (head == null) {
                    head = n;
                    trueHead = head;
                } else {
                    head.next = n;
                    head = n;
                }
            } else {
                if (tail == null) {
                    tail = n;
                } else {
                    tail.next = n;
                    tail = n;
                }
            }

            n = next;
        }
        if (head == null) {
            return tail;
        }

        head.next = tail;

        return trueHead;
    }

    public Node partition1(Node head, int x) {
        if (head == null) return head;
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.getAsInt() > x || current == head) {
                prev = current;
                current = current.next;
            } else {
                Node next = current.next;
                current.next = head;
                if (prev != null) {
                    prev.next = next;
                }
                head = current;
                current = next;
            }
        }
        return head;
    }


}
