package bigO.tests.practice.geeksforgeeks;

import bigO.src.practice.geeksforgeeks.BoggleTrie;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/21/17.
 */
public class BoggleTrieTest {

    //    @Test
    public void testSearchWords() throws Exception {
        char[][] boggle = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };


        String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GEE"};

        BoggleTrie app = new BoggleTrie();
        List<String> res = app.searchWords(boggle, dictionary);
        System.out.println(res.stream().collect(Collectors.joining(",")));
    }

    @Test
    public void stepnum() {

        ArrayList<String> in = new ArrayList(Arrays.asList(
                "zebra",
                "dog", "duck", "dove"));
        ArrayList<String> res = prefix(in);
        System.out.println();
        res.stream().forEach(e -> System.out.print(e + " "));

    }


    public ArrayList<String> prefix(ArrayList<String> a) {

        Trie trie = buildTrie(a);
//        trie.printAll();

        ArrayList<String> res = new ArrayList<>();

        for (String s : a) {//N * m
            trie.remove(s);
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (trie.startsWith(sb.toString() )) {
                    sb.append(c);
                } else {
                    break;
                }

            }
            res.add(sb.toString());
            trie.insert(s);
        }

        return res;
    }


    private Trie buildTrie(ArrayList<String> a) {
        Trie trie = new Trie();
        for (String s : a) {
            trie.insert(s);
        }
        return trie;
    }

    static class Trie {

        Entry root = new Entry();

        boolean startsWith(String s) {
            Character[] charObjectArray =
                    s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

            List<Character> in = Arrays.asList(charObjectArray);
            Deque<Character> q = new ArrayDeque<>(in);
            return root.startsWith(q);
        }

        void insert(String s) {
            Character[] charObjectArray =
                    s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

            List<Character> in = Arrays.asList(charObjectArray);
            Deque<Character> q = new ArrayDeque<>(in);
            root.insert(q);
        }

        String remove(String s) {
            Character[] charObjectArray =
                    s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

            List<Character> in = Arrays.asList(charObjectArray);
            root.remove(new ArrayDeque<>(in));
            return s;
        }

        void printAll() {
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


        }
    }

}
