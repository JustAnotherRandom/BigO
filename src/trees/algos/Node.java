package bigO.src.trees.algos;

/**
 * Created by Stanimir on 3/5/17.
 */
public class Node<V extends Comparable> implements Comparable<V> {
    public Node[] children = new Node[2];
    //    public V[] children =  (V[])new Object[2];;
    public V value;
    public Node parent;

    public Node(V v) {
        this.value = v;
    }


    public static void DFT(Node root) {
        if (root != null) {

            DFT(root.children[0]);
            System.out.println(root.value);
            DFT(root.children[1]);
        }
    }

    public static void printTree(Node root) {

    }

    boolean insert(V n) {
        if (this.compareTo(n) == 0) {
            return true;
        } else if (this.compareTo(n) < 0) {
            if (this.children[0] != null) {
                this.children[0].insert(n);
            } else {
                this.children[0] = (Node) n;
            }

            return true;
        } else {
            if (this.children[1] != null) {
                this.children[1].insert(n);
            } else {
                this.children[1] = (Node) n;
            }
            return true;
        }

    }

    Node remove(Node node, Node parent) {
        Node old = node;
        if (this.children[0] == null && this.children[1] == null) {
            if (this.equals(parent.children[0])) {
                parent.children[0] = null;
            } else {
                parent.children[1] = null;
            }
        }

        return old;
    }


    public Node find(V d) {
        if (d == null) return null;

        if (this.equals(d)) {
            return this;
        } else if (d.compareTo(this) >= 0) {
            return children[1] != null ? children[1].find(d) : null;
        } else {
            return children[0] != null ? children[0].find(d) : null;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(((Node) obj).value);
    }

    @Override
    public int compareTo(V o) {
        return value.compareTo(((Node) o).value);
    }


    private static Node createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.setLeftChild(createMinimalBST(arr, start, mid - 1));
        n.setRightChild(createMinimalBST(arr, mid + 1, end));
        return n;
    }

    public static Node createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public void setLeftChild(Node leftChild) {
        this.children[0] = leftChild;
        if (leftChild != null) {
            leftChild.parent = this;
        }
    }

    public void setRightChild(Node rightChild) {
        this.children[1] = rightChild;
        if (rightChild != null) {
            rightChild.parent = this;
        }
    }

//    public void addFirst(V value){
//        addFirst(new VertexImpl(value),this);
//    }
//
//    public void addFirst(V node, V parent) {
//        int cmp = this.compareTo(node);
//        if (this.value.equals(value)) {
//            //do nothing
//        } else if (this.compareTo(node) < 0) {
//            if (children[0] != null) {
//                children[0].addFirst(value);
//            } else {
//                children[0] = new VertexImpl((value));
//            }
//
//        } else {
//            if (children[1] != null) {
//                children[1].addFirst(value);
//            } else {
//                children[1] = new VertexImpl((value));
//            }
//        }
//    }

    public Node minValue() {
        Node focusNode = this;
        while ((focusNode.children[0]) != null) {
            focusNode = (focusNode.children[0]);
        }
        return focusNode;
    }

    public boolean isLeft() {
        Node parent = this.parent;
        return parent.children[0] != null && parent.children[0].equals(this) ? true : false;
    }
}
