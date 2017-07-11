package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/5/17.
 */
public class BSTFromArray {

    public static void main(String[] str) {
        int[] in = new int[]{3, 5, 6, 7, 8, 9};
//        int[] in = new int[]{3, 5, 6};

        Node result = buildMinDepthBST(in);
        Node.DFT(result);
    }

    public static Node buildMinDepthBST(int[] in) {
        if (in == null || in.length == 0) return null;
        return buildMinDepthBST(in, 0, in.length - 1);
    }

    public static Node buildMinDepthBST(int[] in, int l, int r) {
        if (l > r) {
            return null;
        } else {
            //1,2
            // mid = 1
            int mid = l + (r - l) / 2;
            Node root = new Node(in[mid]);

            root.children[0] = buildMinDepthBST(in, l, mid - 1);
            root.children[1] = buildMinDepthBST(in, mid + 1, r);

            return root;
        }
    }

}
