package bigO.src.trees;

import java.util.*;

/**
 * Created by Stanimir on 6/9/17.
 */
//TODO Add modcount
public abstract class AbstractAVLTreeMap<K, V> extends AbstractMap<K, V> {

    protected final Comparator<? super K> comparator;

    protected Entry<K, V> root;

    protected transient int size = 0;


    public AbstractAVLTreeMap() {
        comparator = null;
    }

    private transient EntrySet entrySet;

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet es = entrySet;
        return (es != null) ? es : (entrySet = new EntrySet());
    }

    public AbstractAVLTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }


    protected int height(Entry<K, V> e) {
        return e == null ? -1 : e.height;
    }

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        //TODO
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    //TODO remove, impelment navigable MAP
    public Entry<K, V> getRoot() {
        return root;
    }

    public static final class Entry<K, V> implements Map.Entry<K, V> {//public to simplify testing

        K key;
        V value;
        int height;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;


        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
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
            return this.value = value;
        }

        public Entry<K, V> getLeft() {
            return left;
        }

        public Entry getRight() {
            return right;
        }

        public Entry getParent() {
            return parent;
        }

        @Override
        public String toString() {
            return key.toString();
        }

        //TODO implement KeySet
        public List<Entry> getChildren() {
            Entry[] arr = new Entry[]{left, right};
            return Arrays.asList(arr);
        }

        public int getHeight() {
            return height;
        }
    }

}
