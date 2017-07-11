package bigO.src.trees.algos;


import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Stanimir on 5/2/17.
 */
public class BinarySearchTree<V extends Comparable> {


    Node root;
    int size = 0;


    boolean insert(Node n) {
        if (root == null) {
            root = n;
            size = 1;
            return true;
        } else {

            Node focusNode = root;
            Node parent = null;
            int cmp;

            do {
                parent = focusNode;
                cmp = n.compareTo(focusNode);
                if (cmp < 0) {
                    focusNode = focusNode.children[0];
                } else if (cmp > 0) {
                    focusNode = focusNode.children[1];
                } else {
                    //set the value
                    return true;
                }
            } while (focusNode != null);


            if (cmp < 0) {
                parent.children[0] = n;
            } else {
                parent.children[1] = n;
            }
            n.parent = parent;
            size++;

        }
        return false;
    }

    void insert(Integer value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
//            root.addFirst(value);
            insert(new Node(value));

        }
    }


    public static void main(String[] str) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(10);
        tree.insert(7);
        tree.insert(15);
                                  HashMap s;

//        VertexImpl.DFT(tree.root);
//        tree.printTree(tree.root);
        tree.displayTree();

        tree.remove(2);
        tree.displayTree();

        tree.remove(10);
        tree.displayTree();

        tree.remove(7);
        tree.displayTree();
    }

    public void remove(V v) {

        remove(root, new Node<V>(v));
    }

    private void remove(Node root, Node<V> i) {
        if (root.value.equals(i)) {
            Node temp = new Node(0);
            temp.children[0] = root;
            temp.remove(new Node(i), temp);
            root = temp.children[0];
        } else {
            Node nodeToRemove = findNode(i);
            if (nodeToRemove == null) return;

            Node parent = nodeToRemove.parent;
            //node has no children
            if (nodeToRemove.children[0] == null && nodeToRemove.children[1] == null) {
                if (nodeToRemove.isLeft()) {
                    parent.children[0] = null;
                } else {
                    parent.children[1] = null;
                }
            } else if (nodeToRemove.children[1] == null) {
                if (nodeToRemove.isLeft()) {
                    parent.children[0] = nodeToRemove.children[0];
                } else {
                    parent.children[1] = nodeToRemove.children[0];
                }
                nodeToRemove.children[0].parent = parent;

            } else if (nodeToRemove.children[0] == null) {
                if (nodeToRemove.isLeft()) {
                    parent.children[0] = nodeToRemove.children[1];
                } else {
                    parent.children[1] = nodeToRemove.children[1];
                }
                nodeToRemove.children[1].parent = parent;
            } else {
                //two children
                Node successor = successor(nodeToRemove);

                nodeToRemove.value = successor.value;

                Node successorParent = successor.parent;
                if(successor.isLeft()){
                    successorParent.children[0] =null;
                }   else {
                    successorParent.children[1] =null;
                }


            }
        }
    }

    private Node successor(Node node) {

        Node rightChild = node.children[1];
        if (rightChild != null) {
            Node minValue = rightChild.minValue();
            return minValue;
        } else if (node.parent != null) {

            if (node.isLeft()) {
                return node.parent;
            } else {
                //is right child
                Node parent = node.parent;
                return parent.parent;
            }

        }
        return null;
    }

    private Node findNode(Node n) {
        if (root.equals(n)) {
            return root;
        } else {
            return root.find(n);
        }
    }


    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while (isRowEmpty == false) {

            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.value);
                    localStack.push(temp.children[0]);
                    localStack.push(temp.children[1]);
                    if (temp.children[0] != null || temp.children[1] != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("****......................................................****");
    }


}
