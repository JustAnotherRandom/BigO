package bigO.src.practice.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/19/17.
 */
public class MultiSearch_17_17 {


    /*       String[] T = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        List<String> res = MultiSearch_17_17.searchAll("mississippi", T);
        */
    public static List<String> searchAll(String big, String[] small) {
        Map<Character, List<Integer>> mem = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {//o(k), k number of elements in Big
            char c = big.charAt(i);
            List<Integer> list = mem.get(c);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                mem.put(c, list);
            } else {
                list.add(i);
                mem.put(c, list);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < small.length; i++) { // n*k^2, n -> number of words in small
            String word = small[i];

            if (word.length() == 1 && mem.containsKey(word.charAt(0))) res.add(word);

            for (int j = 1; j < word.length(); j++) {//o(k), k number of elements in Big
                char c = word.charAt(j);
                char prev = word.charAt(j - 1);
                if (mem.get(c) != null && mem.get(prev) != null && hasTwoConsequative(mem, c, prev)) {
                    if (j + 1 == word.length()) {
                        res.add(word);
                        break;
                    }
                    continue;

                } else {
                    break;
                }
            }

        }
        return res;
    }

    private static boolean hasTwoConsequative(Map<Character, List<Integer>> mem, char second, char first) {//k^2 worst case, given the Big has all many duplicated characters// can be optimized with a map
        List<Integer> firstList = mem.get(first);
        List<Integer> secondList = mem.get(second);

        int a = 0, b = 0;
        while (a < firstList.size() && b < secondList.size()) {

            if (firstList.get(a) + 1 == secondList.get(b)) {
                return true;
            }
            if (firstList.get(a) - secondList.get(b) >= 0) {
                b++;
            } else {
                a++;
            }
        }
        return false;
    }


    public static List<List<Integer>> searchAllTrie(String big, String[] small) {

        Trie trie = new Trie();
        for (int i = 0; i < big.length(); i++) {
            trie.insert(big.substring(i), i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (String word : small) {
            List<Integer> r = trie.search(word);
            if (r != null) {
                System.out.printf("%s [%s]", word, r.stream().map(e -> e - word.length()).map(e -> e.toString()).collect(Collectors.joining(",")));
                System.out.println("");
            }


        }


        return res;
    }

    public static List<List<Integer>> searchAllTrie2(String big, String[] small) {

        Map<String, List<Integer>> res = new HashMap<>();

        Trie tree = new Trie();

        for (String s : small) {
            tree.insert(s, 0);
        }

        int start = 0;
        for (int i = start; i < big.length(); i++) {
            String pref = big.substring(start, i);
            String postfix = big.substring(i);

            String c = Character.toString(big.charAt(i));
            if (tree.startsWith(pref)) {
                List<Integer> r = tree.search(pref);
                if (r != null) {
                    List l = res.getOrDefault(pref, new ArrayList<>());
                    l.add(start);
                } else {
                    continue;
                }

            } else {
                start = i;
            }
        }
        for (String word : small) {
            List<Integer> r = res.get(word);
            if (r != null) {
                System.out.printf("%s [%s]", word, r.stream().map(e -> e - word.length()).map(e -> e.toString()).collect(Collectors.joining(",")));
                System.out.println("");
            }


        }

        return null;
    }


    static class Trie {
        Entry root = new Entry();

        void insert(String word, int index) {
            if (word == null && word.length() == 0) return;

            root.insert(word, index);
        }

        boolean contains(String word) {
            return root.contains(word);
        }

        boolean startsWith(String s) {
            return root.startsWith(s);
        }

        List<Integer> search(String word) {
            return root.search(word);
        }
    }


    static class Entry {
        Map<Character, Entry> children = new HashMap<>(27);
        char key;
        boolean isEnd = false;

        List<Integer> indixes = new ArrayList<>();


        void insert(String word, int index) {
            indixes.add(index);
            if (word != null && word.length() > 0) {
                char key = word.charAt(0);
                Entry child = children.get(key);
                if (child == null) {
                    child = new Entry();
                    children.put(key, child);
                }
                if (word.length() == 1) {
                    isEnd = true;

                }

                child.insert(word.substring(1), index + 1);

            }
        }

        public boolean contains(String word) {
            if (word != null && word.length() > 0) {
                char prefix = word.charAt(0);
                if (children.containsKey(prefix)) {
                    Entry child = children.get(prefix);

                    String postfix = word.substring(1);
                    if (postfix.length() == 0) return true;

                    return child.contains(postfix);
                }
            }


            return false;
        }

        public List<Integer> search(String word) {
            if (word.length() == 0 && isEnd) {
                return indixes;
            }

            if (word != null && word.length() > 0) {
                char prefix = word.charAt(0);
                if (children.containsKey(prefix)) {
                    Entry child = children.get(prefix);

                    String postfix = word.substring(1);


                    return child.search(postfix);
                }
            }


            return null;
        }

        public boolean startsWith(String s) {
            if (s.length() == 0) return true;
            if (children.containsKey(s.charAt(0))) {
                return children.get(s.charAt(0)).startsWith(s.substring(1));
            }
            return false;
        }
    }

}
