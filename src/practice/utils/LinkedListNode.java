package bigO.src.practice.utils;

/**
 * Created by Stanimir on 5/30/17.
 */
public class LinkedListNode<T extends Comparable> implements Comparable {
    public T data;
    public LinkedListNode next;
    public LinkedListNode prev;

    public LinkedListNode(T data) {
        this.data = data;
    }


    @Override
    public int compareTo(Object o) {

        return data.compareTo(((LinkedListNode) o).data);
    }
}
