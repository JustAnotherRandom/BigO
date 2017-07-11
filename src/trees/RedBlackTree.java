package bigO.src.trees;

import bigO.common.TreePrinter;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Stanimir on 6/16/17.
 */
public class RedBlackTree<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable {


    private transient Entry<K, V> root;

    private final Comparator<? super K> comparator;

    private transient int size = 0;

    public RedBlackTree() {
        comparator = null;
    }

    @Override
    public V put(K key, V value) {
        checkNull(key);
        if (root == null) {
            Entry<K, V> e = new Entry<>(key, value, null);
            root = e;
            return null;
        }


        Entry<K, V> r = root;
        int cmp = 0;
        Entry<K, V> parent = null;
        while (r != null) {
            parent = r;
            cmp = compare(key, r.key);
            if (cmp < 0) {
                r = r.left;

            } else if (cmp > 0) {
                r = r.right;

            } else {
                V oldValue = r.value;
                r.value = value;
                return oldValue;
            }
        }

        Entry<K, V> n = new Entry<>(key, value, parent);
        if (cmp < 0) {
            parent.left = n;
        } else {
            parent.right = n;
        }

        balanceTree(n);
        size++;
        return null;
    }

    private void balanceTree(Entry<K, V> x) {
        x.color = RED;
        TreePrinter.printBinaryTree(root);
        while (x != null && x != root && x.parent.color == RED) {

            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {//leftOf
                if (colorOf(parentOf(parentOf(x))) == RED) {//the color of the uncle
                    x = parentOf(parentOf(x));
                    flipColor(parentOf(parentOf(x)));
                    flipColor(leftOf(parentOf(parentOf(x))));
                    flipColor(rightOf(parentOf(parentOf(x))));
                } else {


                    parentOf(parentOf(x)).color = RED;
                    parentOf(x).color = BLACK;
                    rotateRight(parentOf(parentOf(x)));
                    x = parentOf(x);

                }

            }
        }
        root.color = BLACK;

    }

    /*
    *
    * parent                       parent
    *      \                            \
    *       \                           \
    *        x                           t
    *      /   \                        /  \
    *     t      c                   t.l     x
    *   /    \                             /   \
    * T.L   t.r                          t.r   c
    *
    * */
    private void rotateRight(Entry<K, V> p) {

        if (p != null) {
            Entry l = p.left;

            p.left = l.right;
            if (l.right != null) l.right.parent = p;

            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else {
                if (p == rightOf(parentOf(p))) {
                    parentOf(p).right = l;
                } else {
                    parentOf(p).left = l;
                }
            }

            l.right = p;
            p.parent = l;
        }


    }

    private void flipColor(Entry<K, V> x) {
        x.color = !x.color;
    }

    private boolean colorOf(Entry<K, V> x) {
        return x == null ? BLACK : x.color;
    }


    private Entry<K, V> parentOf(Entry<K, V> x) {
        if (x == null) return x;
        return x.parent;
    }

    private Entry<K, V> leftOf(Entry<K, V> x) {
        if (x == null) return x;
        return x.left;
    }

    private Entry<K, V> rightOf(Entry<K, V> x) {
        if (x == null) return x;
        return x.right;
    }

    private int compare(K key1, K key2) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        } else {
            Comparable<K> k = (Comparable<K>) key1;
            return k.compareTo(key2);
        }
    }

    private void checkNull(K key) {
        if (key == null) throw new NullPointerException();
    }


    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    @Override
    public Map.Entry<K, V> lowerEntry(K key) {
        return null;
    }

    @Override
    public K lowerKey(K key) {
        return null;
    }

    @Override
    public Map.Entry<K, V> floorEntry(K key) {
        return null;
    }

    @Override
    public K floorKey(K key) {
        return null;
    }

    @Override
    public Map.Entry<K, V> ceilingEntry(K key) {
        return null;
    }

    @Override
    public K ceilingKey(K key) {
        return null;
    }

    @Override
    public Map.Entry<K, V> higherEntry(K key) {
        return null;
    }

    @Override
    public K higherKey(K key) {
        return null;
    }

    @Override
    public Map.Entry<K, V> firstEntry() {
        Entry<K, V> focusNode = root;
        while (focusNode.left != null) {
            focusNode = focusNode.left;
        }
        return focusNode;
    }

    @Override
    public Map.Entry<K, V> lastEntry() {
        Entry<K, V> focusNode = root;
        while (focusNode.right != null) {
            focusNode = focusNode.right;
        }
        return focusNode;
    }

    @Override
    public Map.Entry<K, V> pollFirstEntry() {
        return null;
    }

    @Override
    public Map.Entry<K, V> pollLastEntry() {
        return null;
    }

    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }

    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super K> comparator() {
        return comparator;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    @Override
    public K firstKey() {
        return firstEntry().getKey();
    }

    @Override
    public K lastKey() {
        return lastEntry().getKey();
    }

    public Entry<K, V> getRoot() {
        return root;
    }

    public static class Entry<K, V> implements Map.Entry<K, V> { //TODO visible for testing

        K key;
        V value;
        Entry left;
        Entry right;
        Entry parent;

        public Entry getLeft() {
            return left;
        }

        public Entry getRight() {
            return right;
        }

        public boolean isColor() {
            return color;
        }

        boolean color = BLACK;

        Entry(K key, V val, Entry<K, V> parent) {
            this.key = key;
            this.value = val;
            this.parent = parent;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

}
