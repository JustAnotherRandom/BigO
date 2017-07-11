package bigO.src.practice.google.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Stanimir on 6/6/17.
 */
public class RemoveDuplicatesLExographicalOrder {

    public static void main(String[] str) {
        System.out.println(solve("cbadcdcbca"));//acdb
        System.out.println(solve("bcabc"));//abc
//        System.out.println(removeDuplicates("bcba"));//bca
    }

    static String removeDuplicates(String str) {
        char[] arr = str.toCharArray();

        Map<Character, Integer> cache = new HashMap<>();//o(1), 26 characters

        for (int i = 0; i < arr.length; i++) {//n
            char current = arr[i];
            Integer prevInd = cache.get(current);
            if (prevInd != null) {

                int low = prevInd != null ? prevInd : 0;
                boolean flag = false;
                for (int j = prevInd; j >= 0; j--) {
                    if (arr[j] != '-' && arr[j] < current) {
                        arr[i] = '-';

                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int j = i; j >= low; j--) {
                        if (arr[j] != '-' && arr[j] < current) {
                            arr[prevInd] = '-';
                            cache.put(current, i);
                            break;
                        }

                    }
                }
            } else {
                cache.put(current, i);
            }


        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '-') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();


    }

    //olve("cbacdcbc"));//acdb
    static String solve(String str) {
        char[] arr = str.toCharArray();


        char min = 'z';
        char max = 'a';
        int minInd = -1;
        int maxInd = -1;
        Map<Character, Integer> set = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Integer entry = set.get(c);
            if (entry == null) {
                set.put(c, 1);
            } else {
                set.put(c, entry + 1);
            }
            if (c <= min && min != c) {
                min = c;
                minInd = i;
            }
            if (c >= max) {
                max = c;
                maxInd = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            Integer count = set.get(c);
            if (count == null) continue;
            if (count == 1) {
                sb.append(c);
                set.remove(c);
            } else {
                if (i < minInd) {
                    set.put(c, --count);
                    continue;
                }
                if (i >= minInd && i <= maxInd) {
                    sb.append(c);
                    set.remove(c);
                    continue;
                }

                if (i > maxInd) {
                    System.out.println("here");
                }
            }

        }

        return sb.toString();

    }

    static class Status {
        int count = 1;
        int maxInd;
        int minInd;
        boolean hasBigger;
    }


    static String solve2(String str) {
        char[] arr = str.toCharArray();


        char min = 'z';
        char max = 'a';
        int minInd = -1;
        int maxInd = -1;

        Map<Character, Status> set = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Status entry = set.get(c);
            if (entry == null) {
                Status s = new Status();
                s.minInd = minInd;
                set.put(c, s);
            } else {
                entry.minInd = minInd;
                entry.count++;
                set.put(c, entry);
            }
            if (c <= min && min != c) {
                min = c;
                minInd = i;
            }
            if (c >= max) {
                max = c;
                maxInd = i;

            }
        }


        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Status s = set.get(c);
            if (s.count == 0) {
                //do nothing
            } else if (hasSmallerOnTheRigth(arr, i, c)) {//n
                arr[i] = '-';
            } else{

            }
        }

        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    static boolean hasSmallerOnTheRigth(char[] arr, int ind, int val) {
        for (int i = ind + 1; i < arr.length; i++) {
            if (arr[ind] < val) {
                return true;
            }
        }

        return false;
    }

    static boolean hasBiggerInRange(char[] arr, int lowIndex, int currentIndex) {
        char cmpVal = arr[currentIndex];
        int min = arr[lowIndex];
        for (int i = lowIndex + 1; i < currentIndex; i++) {
            char current = arr[i];
            if (current != cmpVal && (current > min && current < cmpVal)) {
                return true;
            }
        }

        return false;
    }

}
