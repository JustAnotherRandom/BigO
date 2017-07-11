package bigO.src.trees.algos;

/**
 * Created by Stanimir on 4/9/17.
 */
public class MerkleTree {

    Node root;

    private static class Node {

        int key;
        int data;
        long hash;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            calculateHash();
        }

        private void calculateHash() {
            this.hash = hashCode();
            System.out.println(this.hashCode());
        }


    }


    void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {

            Node parent = null;
            Node focusNode = root;
            boolean isLeft = false;
            while (focusNode != null) {
                parent = focusNode;
                parent.hash += newNode.hash;
                if (newNode.data < focusNode.data) {
                    focusNode = focusNode.left;
                    isLeft = true;
                } else if (newNode.data >= focusNode.data) {
                    focusNode = focusNode.right;
                    isLeft = false;
                }

            }
            if (isLeft == true) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;

        }
    }




    public static void main(String str[]){
        MerkleTree app = new  MerkleTree();


        app.insert(5);
        app.insert(10);
        app.insert(3);


        System.out.println(app.root.hash);
    }
}
