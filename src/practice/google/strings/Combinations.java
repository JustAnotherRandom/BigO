package bigO.src.practice.google.strings;

import java.util.*;

/**
 * Created by Stanimir on 7/4/17.
 */
public class Combinations {
    public static void main(String str[]) {


        List<List<Character>> res = generateCombinations(new Character[]{'a', 'b', 'c','d'}, 2);
        res.stream().forEach(System.out::println);
    }

    /*
    *
    * abc
    *
    * board  c
    *
    * ac
    *
    * ab
    * */
    private static List<List<Character>> generateCombinations(Character[] characters, int r) {

        Set<List<Character>> res = new HashSet<>();
        Deque<Character> q = new ArrayDeque<>();
        combos(characters, r, 0, res, q);

        return new ArrayList(res);
    }

    static <T> void combos(T[] arr, int r, int index, Set<List<T>> res, Deque<T> q) {
        if (q.size() == r) {
            List<T> rl = new ArrayList<>(q);
            res.add(rl);
            return;
        }


        for (int i = index; i < arr.length; i++) {
            q.add(arr[i]);
            combos(arr, r, i + 1, res, q);
            q.removeLast();
        }
    }

}
