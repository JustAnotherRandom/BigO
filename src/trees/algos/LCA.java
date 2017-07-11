package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/18/17.
 */
public class LCA {

    public static void main(String[] str) {
        Node root = BSTFactory.buildBST();

        Node lca = findLca(root, 5, 1);
//        System.out.println(lca.isLCA);
//        System.out.println(lca.node.value);

        System.out.println(lca.value);
    }

    private static Node findLca(Node root, int A, int B) {
        if (root == null) return root;

        Node left = findLca(root.children[0], A, B);
        Node rigth = findLca(root.children[1], A, B);

        if (root.equals(A) || root.equals(B)) {
            return root;
        }

        if ((left != null && left.equals(A)) || (rigth != null && rigth.equals(B))) {
            return root;
        }

        return left != null ? left : rigth != null ? rigth : null;

    }


}
