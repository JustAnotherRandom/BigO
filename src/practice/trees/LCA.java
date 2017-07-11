package bigO.src.practice.trees;

/**
 * Created by Stanimir on 5/6/17.
 */
public class LCA {

    public static void main(String[] str) {

    }

    static class Node {
        int data;
        Node left;
        Node right;

    }

    static class Result {
        boolean isAncestor;
        Node node;

        public Result(Node node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    static Node lca(Node root, int v1, int v2) {
        Result r = lcaH(root, v1, v2);
        if (r.isAncestor) return r.node;

        return null;
    }

    static Result lcaH(Node root, int v1, int v2) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root.data == v1 && root.data== v2) {
            return new Result(root, true);
        }

        Result rl = lcaH(root.left, v1, v2);
        if (rl.isAncestor) {
            return rl;
        }

        Result rr = lcaH(root.right, v1, v2);
        if (rr.isAncestor) {
            return rl;
        }

        if (rl != null && rr != null) {
            return new Result(root, true);
        } else if (root.data == v1 || root.data == v2) {
            boolean isAncestor = rl != null || rr != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rl != null ? rl.node : rr.node, false);
        }

    }


}
