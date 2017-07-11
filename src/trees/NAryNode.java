package bigO.src.trees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stanimir on 6/8/17.
 */
public class NAryNode<T> implements Serializable {

    private T val;
    private List<NAryNode<T>> children;

    public NAryNode(T val) {
        this.val = val;
    }


    public NAryNode addChild(T val) {
        NAryNode<T> child = new NAryNode(val);
        add(child);
        return child;
    }

    private void add(NAryNode<T> child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public void addChild(NAryNode<T> child) {
        add(child);
    }

    public List<NAryNode<T>> getChildren() {
        return children;
    }

    public T getVal() {
        return val;
    }

    public boolean isEmpty() {
        return children == null || children.size() == 0;
    }

    @Override
    public String toString() {

        return val.toString();
    }
}
