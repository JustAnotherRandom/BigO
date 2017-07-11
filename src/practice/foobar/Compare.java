package bigO.src.practice.foobar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by Stanimir on 5/12/17.
 * Free the Bunny Prisoners
 * ========================
 * <p>
 * You need to free the bunny prisoners before Commander Lambda's space station explodes! Unfortunately, the commander was very careful with her highest-value prisoners - they're all held in separate, maximum-security cells. The cells are opened by putting keys into each console, then pressing the open button on each console simultaneously. When the open button is pressed, each key opens its corresponding lock on the cell. So, the union of the keys in all of the consoles must be all of the keys. The scheme may require multiple copies of one key given to different minions.
 * <p>
 * The consoles are far enough apart that a separate minion is needed for each one. Fortunately, you have already freed some bunnies to aid you - and even better, you were able to steal the keys while you were working as Commander Lambda's assistant. The problem is, you don't know which keys to use at which consoles. The consoles are programmed to know which keys each minion had, to prevent someone from just stealing all of the keys and using them blindly. There are signs by the consoles saying how many minions had some keys for the set of consoles. You suspect that Commander Lambda has a systematic way to decide which keys to give to each minion such that they could use the consoles.
 * <p>
 * You need to figure out the scheme that Commander Lambda used to distribute the keys. You know how many minions had keys, and how many consoles are by each cell.  You know that Command Lambda wouldn't issue more keys than necessary (beyond what the key distribution scheme requires), and that you need as many bunnies with keys as there are consoles to open the cell.
 * <p>
 * Given the number of bunnies available and the number of locks required to open a cell, write a function answer(num_buns, num_required) which returns a specification of how to distribute the keys such that any num_required bunnies can open the locks, but no group of (num_required - 1) bunnies can.
 * <p>
 * Each lock is numbered starting from 0. The keys are numbered the same as the lock they open (so for a duplicate key, the number will repeat, since it opens the same lock). For a given bunny, the keys they get is represented as a sorted list of the numbers for the keys. To cover all of the bunnies, the final answer is represented by a sorted list of each individual bunny's list of keys.  Find the lexicographically least such key distribution - that is, the first bunny should have keys sequentially starting from 0.
 * <p>
 * num_buns will always be between 1 and 9, and num_required will always be between 0 and 9 (both inclusive).  For example, if you had 3 bunnies and required only 1 of them to open the cell, you would give each bunny the same key such that any of the 3 of them would be able to open it, like so:
 * [
 * [0],
 * [0],
 * [0],
 * ]
 * If you had 2 bunnies and required both of them to open the cell, they would receive different keys (otherwise they wouldn't both actually be required), and your answer would be as follows:
 * [
 * [0],
 * [1],
 * ]
 * Finally, if you had 3 bunnies and required 2 of them to open the cell, then any 2 of the 3 bunnies should have all of the keys necessary to open the cell, but no single bunny would be able to do it.  Thus, the answer would be:
 * [
 * [0, 1],
 * [0, 2],
 * [1, 2],
 * ]
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (int) num_buns = 2
 * (int) num_required = 1
 * Output:
 * (int) [[0], [0]]
 * <p>
 * Inputs:
 * (int) num_buns = 5
 * (int) num_required = 3
 * Output:
 * (int) [[0, 1, 2, 3, 4, 5], [0, 1, 2, 6, 7, 8], [0, 3, 4, 6, 7, 9], [1, 3, 5, 6, 8, 9], [2, 4, 5, 7, 8, 9]]
 * <p>
 * Inputs:
 * (int) num_buns = 4
 * (int) num_required = 4
 * Output:
 * (int) [[0], [1], [2], [3]]
 */
public class Compare {

    public static void main(String[] str) {
//        int[][] res = answer(3, 2); // [0][0]
//        int[][] res = answer(4, 2); // [0][0]
        int[][] res = answer(5, 3); // [0][0]
//        System.out.println(answer("15"));//5
//        print(res);

//        print(res);
//        System.out.println();


    }

    public static int[][] answer(int num_buns, int num_required) {
        // Your code goes here.
        /*
          # of keys = findNumberOfKeys(n, r - 1)
          # of keys a rabit can hold = findNumberOfKeys(n - 1, r - 2)
          increasing lexicographical order of (r - 1) rabits matched with decreasing key #
        */

        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = initializeEmptyArrayList(num_buns);

        int num_keys = findNumberOfKeys(num_buns, num_required - 1);
        int num_hold = num_keys - findNumberOfKeys(num_buns - 1, num_required - 2);
        System.out.println("numb_Buns: " + num_buns + " num_required:" + num_required + " Keys: " + num_keys);
        System.out.println("Hold: " + num_hold);


        int myKeys = findKeys(num_buns, num_required);
        int mynum_hold = myKeys - findKeys(num_buns - 1, num_required - 1);
        System.out.println("numb_Buns: " + num_buns + " num_required:" + num_required + " Keys: " + myKeys);
        System.out.println("my Hold: " + num_hold);


        int[] digits = new int[myKeys];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = i;
        }


        myPermGen(digits, num_required, result);

        generatePermutations(stack, result, num_buns, num_required - 1, 0, num_keys - 1);

        print(result, num_buns);

        // reverse order of rabits in the list for each key # (low to high)
        for (int i = 0; i < num_buns; i++) {
            Collections.reverse(result.get(i));
        }
        System.out.println();
//        print(result, num_buns);
//        System.out.println();

        int[][] resultArray = convertToArray(num_buns, result, num_keys, num_hold);
        print(resultArray);

        return resultArray;
    }

    private static void myPermGen(int[] digits, int num_required, ArrayList<ArrayList<Integer>> result) {
        List<Integer> available = IntStream.of(digits).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            puppulate(row, num_required, available);
        }
    }

    private static void puppulate(List<Integer> row, int num_required, List<Integer> available) {
        Random rnd = new Random();
//        for (int i = 0; i < num_required; i++) {
//
//            int index = rnd.nextInt(available.size());
//
//            int digit = available.get(index);
//            available.remove(index);
//
//
//        }
        Collections.sort(row);
    }

    // generate all lexicographical order of findNumberOfKeys(n, r - 1), count is reversed
    public static void generatePermutations(List<Integer> stack, ArrayList<ArrayList<Integer>> arr, int num_buns, int k, int last, int count) {
        if (k == 0) {
            for (int i = 0; i < stack.size(); i++) {
                arr.get(stack.get(i) - 1).add(count);
            }
            return;
        }
        for (int i = last + 1; i <= num_buns; i++) {
            stack.add(i);
            generatePermutations(stack, arr, num_buns, k - 1, i, count);
            count -= findNumberOfKeys(num_buns - i, k - 1);
            stack.remove(stack.size() - 1);
        }
    }

    // 5! = 5! * 4! * 3! * 2! *1!
    static int factorial(int[] cache, int n) {

        if (n == 2) return 2;
        if (n == 1) return 1;

        if (cache[n] == 0) {
            cache[n] = n * factorial(cache, n - 1);
        }

        return cache[n];
    }

    static int factorial(int n) {
        int[] cache = new int[n + 1];
        return factorial(cache, n);
    }

    static int findKeys(int number_buns, int k) {
        return factorial(number_buns) / (factorial(number_buns - k) * factorial(k));
    }

    // compute combination (n, k)
    public static int findNumberOfKeys(int number_buns, int k) {
        if (k == 0) return 1;
        if (k < 0) return 0;
        int res = 1;
        for (int i = k + 1; i <= number_buns; i++) {
            res = res * i / (i - k);
        }
        return res;
    }


    private static int[][] convertToArray(int num_buns, ArrayList<ArrayList<Integer>> arr, int num_keys, int num_hold) {
        // convert to int[][], count key # that does not appear in list
        int[][] resultArray = new int[num_buns][num_hold];
        int temp, hold;
        for (int i = 0; i < num_buns; i++) {
            temp = 0;
            hold = 0;
            List<Integer> tempList = arr.get(i);
            for (int j = 0; j < num_keys; j++) {
                if (temp < tempList.size() && j == tempList.get(temp)) {
                    temp++;
                } else {
                    resultArray[i][hold++] = j;
                }
            }
        }
        return resultArray;
    }

    private static ArrayList<ArrayList<Integer>> initializeEmptyArrayList(int num_buns) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < num_buns; i++) {
            arr.add(new ArrayList<>());
        }
        return arr;
    }

    private static void print(ArrayList<ArrayList<Integer>> arr, int num_buns) {
        for (int i = 0; i < num_buns; i++) {
            System.out.print("[" + i + "]: ");
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    private static void print(int[][] res) {
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] convertToArray(ArrayList<ArrayList<Integer>> list) {
        int[][] res = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }


}
