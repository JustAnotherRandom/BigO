package bigO.src.practice.trees;

import bigO.src.trees.algos.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Stanimir on 5/6/17.
 */
public class BSTSequences {

    public static void main(String[] str) {
        Node root = new Node(2);
        root.children[0] = new Node(1);
        root.children[1] = new Node(3);
        ArrayList<LinkedList<Node>> res = allSequences(root);
        for (LinkedList<Node> l : res) {
            while (!l.isEmpty()) {
                System.out.print(l.removeFirst() + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<LinkedList<Node>> allSequences(Node root) {

        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        ArrayList<LinkedList<Node>> left = allSequences(root.children[0]);
        ArrayList<LinkedList<Node>> right = allSequences(root.children[1]);

        LinkedList<Node> prefix = new LinkedList<>();
        prefix.add(root);


        for (LinkedList l : left) {
            for (LinkedList r : right) {
                ArrayList<LinkedList<Node>> weaved = new ArrayList<>();
                weave(l, r, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    private static void weave(LinkedList<Node> l, LinkedList<Node> r, ArrayList<LinkedList<Node>> weaved, LinkedList<Node> prefix) {
        if (l.isEmpty() || r.isEmpty()) {
            LinkedList<Node> res = (LinkedList<Node>) prefix.clone();
            res.addAll(l);
            res.addAll(r);
            weaved.add(res);
            return;
        }

        Node headFirst = l.removeFirst();
        prefix.addLast(headFirst);
        weave(l, r, weaved, prefix);
        prefix.removeLast();
        l.addFirst(headFirst);

        Node headSecond = r.removeFirst();
        prefix.addLast(headSecond);
        weave(l, r, weaved, prefix);
        prefix.removeLast();
        r.addFirst(headSecond);
    }

}
