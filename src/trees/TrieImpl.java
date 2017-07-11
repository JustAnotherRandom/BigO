package bigO.src.trees;

import java.util.*;

/**
 * Created by Stanimir on 6/18/17.
 */
public class TrieImpl implements Trie {


    Entry root = new Entry();

    @Override
    public boolean contains(String key) {
        Character[] charObjectArray =
                key.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        List<Character> in = Arrays.asList(charObjectArray);
        Deque<Character> q = new ArrayDeque<>(in);
        return root.contains(q);
    }


    @Override
    public boolean startsWith(String key) {
        Character[] charObjectArray =
                key.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        List<Character> in = Arrays.asList(charObjectArray);
        Deque<Character> q = new ArrayDeque<>(in);
        return root.startsWith(q);
    }

    @Override
    public void insert(String s) {
        Character[] charObjectArray =
                s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        List<Character> in = Arrays.asList(charObjectArray);
        Deque<Character> q = new ArrayDeque<>(in);
        root.insert(q);
    }

    @Override
    public String remove(String s) {
        Character[] charObjectArray =
                s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        List<Character> in = Arrays.asList(charObjectArray);
        root.remove(new ArrayDeque<>(in));
        return s;
    }

    public void printAll() {
        Entry n = root;
        StringBuilder sb = new StringBuilder();
        print(sb, n);
    }

    private void print(StringBuilder sb, Entry n) {
        if (n != null) {
            sb.append(n.c);
            if (n.isEnd) {
                System.out.print(sb.toString() + " ");
            }
            for (char c2 : n.map.keySet()) {
                print(sb, n.map.get(c2));
            }

            sb.setLength(sb.length() - 1);
        }

    }

    static class Entry {
        Map<Character, Entry> map = new HashMap<>();
        boolean isEnd = false;
        char c;

        public Entry() {
        }

        public Entry(char first, boolean isEnd) {
            this.c = first;
            this.isEnd = isEnd;
        }

        void insert(Deque<Character> q) {
            if (!q.isEmpty()) {
                char first = q.removeFirst();
                Entry e = map.get(first);
                if (e == null) {
                    e = new Entry(first, q.isEmpty());
                    map.put(first, e);
                }
                e.insert(q);
            }


        }

        public boolean startsWith(Deque<Character> q) {
            char first = q.removeFirst();
            Entry e = map.get(first);
            if (e != null) {
                if (q.isEmpty()) return true;

                return e.startsWith(q);
            }
            return false;
        }

        public Entry remove(ArrayDeque<Character> q) {
            if (q.isEmpty() && isEnd && map.isEmpty()) return this;

            char first = q.removeFirst();

            Entry e = map.get(first);


            Entry res = e.remove(q);
            if (res != null && !isEnd) {
                map.remove(e.c);
            }


            return (q.isEmpty() && map.isEmpty()) == true ? this : null;
        }


        public boolean contains(Deque<Character> q) {
            char first = q.removeFirst();


            Entry e = map.get(first);
            if (e != null) {
                if (q.isEmpty()) {
                    return true;
                } else {
                    return e.contains(q);
                }

            } else {
                return false;
            }


        }
    }
}
