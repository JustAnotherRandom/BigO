package bigO.src.practice.google.strings;

import java.util.*;

/**
 * Created by Stanimir on 7/4/17.
 */
public class Permutations {


    public static void main(String str[]) {
        generatePermutations(new Character[]{'a', 'b', 'c'});

    }


    /*
    * ab
    * ba
    *
    * abc
    * acb
    * cab
    *
    *
    * bac
    * bca
    * cba
    * */
    static <T> void generatePermutations(T[] arr) {
        Set<List<T>> perms = new HashSet<>();
        ArrayDeque<T> q = new ArrayDeque<T>(Arrays.asList(arr));
        genPerm(q).stream().forEach(System.out::println);
    }


    private static <T> List<List<T>> genPerm(ArrayDeque<T> arr) {
        if (arr.isEmpty()) return new ArrayList<>();
        if (arr.size() == 1) {
            List r = new ArrayList<>();
            List<T> res = new ArrayList<>();
            res.add(arr.remove());
            r.add(res);
            return r;
        }

        List<List<T>> res = new ArrayList<>();
        T first = arr.removeFirst();//a
        List<List<T>> tr = genPerm(arr); //board

        for (List l : tr) {
            for (int i = 0; i <= l.size(); i++) {
                res.add(insertAt(i, l, first));

            }

        }


        return res;
    }

    static <T> List<T> insertAt(int i, List<T> arr, T e) {
        List<T> res = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            res.add(arr.get(j));
        }
        res.add(e);
        for (int j = i; j < arr.size(); j++) {
            res.add(arr.get(j));
        }

        return res;
    }
}


