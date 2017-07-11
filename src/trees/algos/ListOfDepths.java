package bigO.src.trees.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Stanimir on 3/5/17.
 */
public class ListOfDepths {

    public static void main(String[] str) {
        int[] in = new int[]{3, 5, 6, 7, 8, 9};
        Node root = BSTFromArray.buildMinDepthBST(in, 0, in.length - 1);

        List<List<Node>> res = createLevelLinkedList(root);
        System.out.println(res.size());
    }

    private static List<List<Integer>> listOfDepths(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        build(res, root, 0);
        return res;
    }

    private static void build(List<List<Integer>> res, Node root, int level) {

        if (root != null) {
            List ll = null;
            if (res.size() == level) {
                ll = new LinkedList<>();
                res.add(ll);
            } else {
                ll = res.get(level);
            }

            ll.add(root);
            build(res, root.children[0], level + 1);
            build(res, root.children[1], level + 1);
        }
    }

    static List<List<Node>> createLevelLinkedList(Node root) {
        ArrayList<List<Node>> result = new ArrayList<>();

        List<Node> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (!current.isEmpty()) {
            result.add(current);
            List<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.children[0] != null) {
                    current.add(parent.children[0]);
                }
                if (parent.children[1] != null) {
                    current.add(parent.children[1]);
                }
            }
        }
        return result;
    }

}
