package bigO.src.practice;


import bigO.src.Node;

/**
 * Created by Stanimir on 3/7/17.
 */
public class RemoveDupsLinkedList {

    public static void main(String[] str) {
        Node d = new Node("3");
        Node c = new Node("1", d);
        Node b = new Node("2", c);
        Node a = new Node("1", b);

        Node.print(a);
        System.out.println();
        RemoveDupsLinkedList.removeDups(a);
        Node.print(a);
    }


    public static Node removeDups(Node root) {
        if (root == null) return null;

        Node head = root;


        while (root != null) {
            removeDupsHelper(root);
            root = root.next;

        }

        return head;
    }

    private static void removeDupsHelper(Node root) {
        Node runner = root.next;
        Node prev = root;
        while (runner != null) {
            if (runner.compareTo(root) == 0) {
                prev.next = runner.next;
            } else {
                prev = runner;
            }
            runner = runner.next;
        }
    }

}
