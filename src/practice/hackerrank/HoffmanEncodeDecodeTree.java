package bigO.src.practice.hackerrank;

/**
 * Created by Stanimir on 5/5/17.
 */
public class HoffmanEncodeDecodeTree {



    public static void main(String[] str) {
        HoffmanEncodeDecodeTree app = new HoffmanEncodeDecodeTree();
        Node root = new Node(INT_NODE_VAL);
        root.right = new Node('A');
        root.left = new Node(INT_NODE_VAL);
        root.left.left = new Node('B');
        root.left.right = new Node('C');


        LevelOrderTraversal.LevelOrder(root);
//        app.decode("1001011", root);
    }

    public static char INT_NODE_VAL = 'ϕ';


    class Index {
        int pos = 0;

        public void increment() {
            pos++;
        }

        public void move(int p) {
            pos += p;
        }

        @Override
        public String toString() {
            return "Index{" +
                    "pos=" + pos +
                    '}';
        }
    }

    void decode(String S, Node root) {
        StringBuilder sb = new StringBuilder();
        Index pos = new Index();

        while (pos.pos < S.length()) {
            decode(S, root, pos, sb);
        }

        System.out.println(sb.toString());
    }

    private void decode(String s, Node root, Index pos, StringBuilder sb) {


        if (root.data != INT_NODE_VAL) {
//            sb.append(root.data);
            System.out.print(root.data);
            return;
        }

        if (s.charAt(pos.pos) == '0' && root.left != null) {
            pos.increment();
            decode(s, root.left, pos, sb);
        } else if (s.charAt(pos.pos) == '1' && root.right != null) {
            pos.increment();
            decode(s, root.right, pos, sb);
        }

    }
}
