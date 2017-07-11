package bigO.src.practice.trees.utils;

/**
 * Created by Stanimir on 5/26/17.
 */
public class Node<T extends Comparable> {

    public T id;
    public Node[] children = new Node[2];

    public Node(T id, Node left, Node right) {
        this.id = id;
        children[0] = left;
        children[1] = right;
    }

    public Node(T id) {
        this.id = id;
    }

    public Node left(){
        return children[0];
    }
    public Node right(){
        return children[1];
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
