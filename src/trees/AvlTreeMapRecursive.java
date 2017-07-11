package bigO.src.trees;

import bigO.common.TreePrinter;

import java.util.Comparator;

/**
 * Created by Stanimir on 6/9/17.
 */
public class AvlTreeMapRecursive<K, V> extends AbstractAVLTreeMap<K, V> {

    public AvlTreeMapRecursive() {
        super();
    }

    @Override
    public V put(K key, V value) {
        super.root = put(super.root, key, value);
        //TODO fix return
        return null;
    }

    @Override
    public V remove(Object key) {
//        Entry<K, V> e = getEntry(key);
//        if (e == null) return null;

//        V oldValue = e.value;
        K k = (K) key;
        Entry<K, V> oldValue = deleteEntry(super.root, k);
        return oldValue.getValue();

    }


    private Entry<K, V> getEntry(Object key) {
        Entry<K, V> r = super.root;

        while (r != null) {
            int cmp = compare(key, r.key);
            if (cmp < 0) {
                r = r.left;
            } else if (cmp > 0) {
                r = r.right;
            } else {
                return r;
            }

        }
        return null;
    }

    private Entry<K, V> deleteEntry(Entry<K, V> localRoot, K key) {

        int cmp = compare(key, localRoot.key);

        Entry<K, V> oldEntry = null;
        if (cmp < 0) {
            oldEntry = deleteEntry(localRoot.left, key);
        } else if (cmp > 0) {
            oldEntry = deleteEntry(localRoot.right, key);
        } else {
            //the localroot is the entry to be removed

            oldEntry = localRoot;
            if (localRoot.left == null || localRoot.right == null) {//0 or 1 children
                Entry e = localRoot.left;
                if (e == null) {
                    e = localRoot.right;
                }

                if (e == null) {//no children
                    cmp = compare(key, localRoot.parent.key);
                    if (cmp < 0) {
                        localRoot.parent.left = null;
                    } else {
                        localRoot.parent.right = null;
                    }
                }
            } else {//2 children
//                Entry<K, V> successor = successor(oldEntry);
            }


            return oldEntry;
        }
        return null;//remove
    }

    static <K, V> Entry<K, V> m(Entry<K, V> oldEntry) {
        if (oldEntry == null) return null;

        Entry parent = oldEntry.parent;


        //
        // --> leftMost(right)
        //-->right
        //--> find parent.right.leftmost

        Entry successor = leftMost(oldEntry.right);
        if (successor == null && parent != null) {
            successor = leftMost(parent.right);
            if (successor == null) {
                return parent;
            }
        }

        return null;
    }

    private static <K, V> Entry<K, V> leftMost(Entry<K, V> localRoot) {
        if (localRoot == null) return null;
        while (localRoot.left != null) {
            localRoot = localRoot.left;
        }
        return localRoot;
    }


    private Entry<K, V> put(Entry<K, V> root, K key, V value) {
        System.out.println("Before Insert: " + key);
        TreePrinter.printBinaryTree(this);
        if (key == null) throw new NullPointerException();
        if (root == null) {
            //TOOD fix paremt
            root = new Entry<>(key, value, root);
            size++;
        } else {


            int cmp = compare(key, root.key);
            if (cmp < 0) {
                Entry<K, V> e = put(root.left, key, value);
                e.parent = root;//TODO fix parent
                root.left = e;
                if (height(root.left) - height(root.right) == 2) {
                    cmp = compare(key, e.key);
                    if (cmp < 0) {
                        root = rotateWithLeftChild(root);
                    } else {
                        root = doubleRotateWithLeftChild(root);
                    }

                }
            } else if (cmp > 0) {
                Entry<K, V> e = put(root.right, key, value);
                e.parent = root;
                root.right = e;
                if (height(root.right) - height(root.left) == 2) {
                    cmp = compare(key, e.key);
                    if (cmp > 0) {
                        root = rotateWithRightChild(root);
                    } else {
                        root = doubleRotateWithRightChild(root);
                    }

                }
            } else {
                root.setValue(value);
            }

        }


        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private int compare(Object key, K nodeKey) {
        K k = (K) key;
        Comparator<? super K> comparator = super.comparator;
        if (comparator != null) {
            return comparator.compare(k, nodeKey);
        } else {
            Comparable<? super K> cmp = (Comparable<? super K>) key;
            return cmp.compareTo(nodeKey);
        }
    }

    private Entry<K, V> doubleRotateWithRightChild(Entry<K, V> k1) {
        System.out.println("doubleRotateWithRightChild: Rotate right");
        k1.right = rotateWithLeftChild(k1.right);//rotate left
        TreePrinter.printBinaryTree(this);
        return rotateWithRightChild(k1);//rotate rigth
    }

    private Entry<K, V> doubleRotateWithLeftChild(Entry<K, V> k3) {
        System.out.println("doubleRotateWithLeftChild: Rotate right");
        k3.left = rotateWithRightChild(k3.left);//rotate left
        TreePrinter.printBinaryTree(this);
        return rotateWithLeftChild(k3);//rotate right
    }

    private Entry<K, V> rotateWithRightChild(Entry<K, V> node) {
        System.out.println("rotateWithRightChild: Rotate left");
        Entry<K, V> right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = Math.max(height(node.getLeft()), height(node.getRight())) + 1;
        right.height = Math.max(height(right.getLeft()), height(right.getRight())) + 1;
        TreePrinter.printBinaryTree(this);
        return right;
    }


    /*
    *    13(node)
    *   /
    *  10(left)         10(1)
    * /              /      \
    *5(0)          5(0)    13(0)
    *
    *
    * */
    private Entry<K, V> rotateWithLeftChild(Entry<K, V> node) {//o(1)
        System.out.println("rotateWithLeftChild: Rotate right");
        Entry<K, V> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(height(node.getLeft()), height(node.getRight())) + 1;
        left.height = Math.max(height(left.getLeft()), height(left.getRight())) + 1;
        TreePrinter.printBinaryTree(this);
        return left;
    }


}
