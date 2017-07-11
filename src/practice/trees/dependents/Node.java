package bigO.src.practice.trees.dependents;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanimir on 3/23/17.
 */
public class Node<T> {
    private T value;
    private List<Node> nieghtbor = new ArrayList<>();
    private int dependents = 0;

    public Graph.State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "VertexImpl{" +
                "value=" + value +
                '}';
    }

    public void setState(Graph.State state) {
        this.state = state;
    }

    private Graph.State state = Graph.State.Blank;

    public Node(T val) {
        value = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return value != null ? value.equals(node.value) : node.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public List<Node> getNieghtbor() {
        return nieghtbor;
    }

    public void addNieghtbor(Node n) {
        this.nieghtbor.add(n);
    }


    public T getValue() {
        return value;
    }

    public void incrementDependents() {
        dependents++;
    }

    public void decrementDependents() {
        dependents--;
    }

    public int getDependents() {
        return dependents;
    }
}
