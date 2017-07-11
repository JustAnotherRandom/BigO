package bigO.src.trees;

import java.util.Comparator;

/**
 * Created by Stanimir on 6/9/17.
 */
public class AvlTreeMapIterative<K, V> extends AbstractAVLTreeMap<K, V> {

    @Override
    public V put(K key, V value) {
        Entry<K, V> r = root;
        if (r == null) {
            root = new Entry<>(key, value, null);
            size = 1;
            root.height = 1;
            return null;
        }

        int cmp;
        Entry<K, V> parent;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = r;
                cmp = cpr.compare(key, r.key);
                if (cmp < 0) {
                    r = r.left;
                } else if (cmp > 0) {
                    r = r.right;
                } else {
                    return r.setValue(value);
                }
            } while (r != null);
        } else {
            if (key == null) throw new NullPointerException();
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = r;
                cmp = k.compareTo(r.key);
                if (cmp < 0) {
                    r = r.left;
                } else if (cmp > 0) {
                    r = r.right;
                } else {
                    return r.setValue(value);
                }
            } while (r != null);
        }

        Entry<K, V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);
        size++;

        return null;
    }

    private void fixAfterInsertion(Entry<K, V> e) {
    }


}
