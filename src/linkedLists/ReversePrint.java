package bigO.src.linkedLists;

/**
 * Created by Stanimir on 5/6/17.
 */
public class ReversePrint {

    public static void main(String[] str) {
        ReversePrint app = new ReversePrint();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next=b;
        b.next=c;
        app.ReversePrint(a);
    }

    static class Node {
        int data;
        Node next;
        Node(int v){
            this.data=v;
        }
    }


    void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null) return;

        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            if(next == null) head = current;

            prev = current;
            current=next;
        }

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }


    }

}
