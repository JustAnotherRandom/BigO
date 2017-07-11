package bigO.src.practice.hackerrank;

/**
 * Created by Stanimir on 5/5/17.
 */
public class LowestCommonAncestor {

    public static void main(String[] str) {

    }

    static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1 || root.data == v2) return root;

        Node left = lca(root.left, v1, v2);


        Node right = lca(root.right, v1, v2);

        if (left == null && right != null) {
            return right;
        } else if ((root.left == left && root.right == right) ||
                (root.right == left && root.left == right)) {
            return root;
        }else if(right == null && left != null){
            return left;
        }

        return  null;
    }

}
