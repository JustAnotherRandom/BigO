package bigO.src.practice.foobar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stanimir on 5/11/17.
 * Find the Access Codes
 * =====================
 * <p>
 * In order to destroy Commander Lambda's LAMBCHOP doomsday device, you'll need access to it. But the only door leading to the LAMBCHOP chamber is secured with a unique lock system whose number of passcodes changes daily. Commander Lambda gets a report every day that includes the locks' access codes, but only she knows how to figure out which of several lists contains the access codes. You need to find a way to determine which list contains the access codes once you're ready to go in.
 * <p>
 * Fortunately, now that you're Commander Lambda's personal assistant, she's confided to you that she made all the access codes "lucky triples" in order to help her better find them in the lists. A "lucky triple" is a tuple (x, y, z) where x divides y and y divides z, such as (1, 2, 4). With that information, you can figure out which list contains the number of access codes that matches the number of locks on the door when you're ready to go in (for example, if there's 5 passcodes, you'd need to find a list with 5 "lucky triple" access codes).
 * <p>
 * Write a function answer(l) that takes a list of positive integers l and counts the number of "lucky triples" of (lst[i], lst[j], lst[k]) where i < j < k.  The length of l is between 2 and 2000 inclusive.  The elements of l are between 1 and 999999 inclusive.  The answer fits within a signed 32-bit integer. Some of the lists are purposely generated without any access codes to throw off spies, so if no triples are found, return 0.
 * <p>
 * For example, [1, 2, 3, 4, 5, 6] has the triples: [1, 2, 4], [1, 2, 6], [1, 3, 6], making the answer 3 total.
 * <p>
 * Languages
 * =========
 * <p>
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit solution.java
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (int list) l = [1, 1, 1]
 * Output:
 * (int) 1
 * <p>
 * Inputs:
 * (int list) l = [1, 2, 3, 4, 5, 6]
 * Output:
 * (int) 3
 */
public class Answer4 {

    public static void main(String[] str) {
        System.out.println(answer(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int answer(int[] l) {
        int[] divs = new int[l.length];

        for (int i = 0; i < l.length; i++) {
            for (int j = i + 1; j < l.length; j++) {
                if (l[j] % l[i] == 0) {
                    divs[j] += 1;
                }

            }
        }
//        for (int i = 0; i < l.length; i++) {
//            for (int j = i + 1; j < l.length; j++) {
//                System.out.print("i=" + i + "[" + l[i] + "] j=" + j + "[" + l[j] + "]");
//                if (l[j] % l[i] == 0) {
//                    System.out.println();
//                    System.out.println("update");
//                    divs[j] += 1;
//                    print(divs, l);
//                    System.out.println();
//                } else {
//                    System.out.println();
//                    System.out.println("not divisible");
//                }
//            }
//            System.out.println();
//        }


        int count = 0;

        for (int i = l.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                System.out.print("i=" + i + "[" + l[i] + "] j=" + j + "[" + l[j] + "]");

                if (l[i] % l[j] == 0) {
                    System.out.println();
                    System.out.println("update, count =" + count + " divsV=" + divs[j]);
                    count += divs[j];
                } else {
                    System.out.println();
                    System.out.println("not divisible");
                }
            }
            System.out.println();
        }


        return count;
    }

    private static void print(int[] divs, int[] l) {
        for (int i = 0; i < divs.length; i++) {
            System.out.print(divs[i] + " ");
        }
        System.out.println();
    }

    public static int answer2(int[] l) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < l.length; i++) {

            for (int j = i + 1; j < l.length; j++) {

                if (l[j] % l[i] != 0) continue;


                for (int k = j + 1; k < l.length; k++) {
                    if (l[k] % l[j] == 0) {
                        result.add(Arrays.asList(l[i], l[j], l[k]));
                    }
                }

            }
        }

        return result.size();
    }


}
