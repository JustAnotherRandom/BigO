package bigO.src.trees.util;

import java.util.*;

/**
 * Created by Stanimir on 6/13/17.
 */
public class PriorityQueue<E> extends AbstractQueue<E> {


    private transient Object[] queue;
    private transient int size;

    private Comparator<? super E> comparator;//not final for reverse order method


    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    public PriorityQueue() {
        queue = new Object[DEFAULT_INITIAL_CAPACITY];
        comparator = null;
    }

    //TODO super or extends
    /*
    * Bottorn-Up Heap Construction.
    * Initializes the heap from existing collection. Takes O(n) time. Null elements not permited.
    * The entries must be comparable.
    * */
    public PriorityQueue(Collection<? super E> c) {
        queue = new Object[c.size()];
        comparator = null;
        initFromCollection(c);
    }

    private void initFromCollection(Collection<? super E> collection) {
        Object[] c = collection.toArray();

        int index = 0;

        int coef = 2;
        while (index < c.length) {
            int levelEntries = (c.length + 1) / coef;
            coef *= 2;

            for (; index < index + levelEntries && index < c.length; index++) {
                Object o = c[index];
                checkNull(o);
                queue[index] = c[index];
                size++;
                heapify();
            }
        }
    }

    private void checkNull(Object o) {
        if (o == null) throw new NullPointerException();
    }

    private int leftChildIndex(int parent) {
        int childIndex = parent * 2 + 1;
        return childIndex;
    }

    private int rightChildIndex(int parent) {
        int childIndex = parent * 2 + 2;
        return childIndex;
    }

    private void grow() {
        int newSize = size * 2;
        queue = Arrays.copyOf(queue, newSize);
    }

    int getParent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void heapify() {

        for (int i = (size / 2) - 1; i >= 0; i--) {
            siftDown(i, (E) queue[i]);
        }


    }

    private void swap(int index, int leftChild) {
        E temp = (E) queue[index];
        queue[index] = queue[leftChild];
        queue[leftChild] = temp;
    }

    private int compare(E localRoot, E leftChild) {
        Comparator<? super E> comparator = this.comparator;
        int cmp;
        if (comparator != null) {
            cmp = comparator.compare(localRoot, leftChild);
        } else {
            Comparable<? super E> key = (Comparable<? super E>) localRoot;
            cmp = key.compareTo(leftChild);

        }
        return cmp;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(Object o) {
        checkNull(o);

        if (size == queue.length) {
            grow();
        }


        queue[size++] = o;

        if (size > 1)
            siftUp(lastIndex(), o);

        return true;
    }

    private void siftUp(int i, Object o) {
        int parentIndex = getParent(i);
        E parent = (E) queue[parentIndex];
        int cmp = compare((E) o, parent);
        if (cmp < 0) {
            swap(i, parentIndex);
            siftUp(parentIndex, o);
        }
    }

    @Override
    public E poll() {
        if (size == 0) return null;
        E polled = (E) queue[0];


        int lastIndex = --size;
        E last = (E) queue[lastIndex];
        swap(0, lastIndex);
        queue[lastIndex] = null;

        siftDown(0, last);


        return polled;
    }

    private void siftDown(int i, E localRoot) {
        int half = size / 2;//last parent location
        while (i < half) {// sift down a particular branch
            int child = leftChildIndex(i);
            E o = (E) queue[child];//start with the left child
            int r = rightChildIndex(i);

            if (r < size && compare(o, (E) queue[r]) > 0) {
                child = r;
            }

            int cmp = compare(localRoot, o);
            if (cmp <= 0) {
                break;
            }
            swap(i, child);
            i = child;
        }

    }

    public void convertToMaxHeap() {
        comparator = Collections.reverseOrder();
        heapify();
    }

    private int lastIndex() {
        return size - 1;
    }

    @Override
    public E peek() {
        return size == 0 ? null : (E) queue[0];
    }
}
