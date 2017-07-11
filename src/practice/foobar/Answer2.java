package bigO.src.practice.foobar;

import java.util.*;

/**
 * Created by Stanimir on 5/9/17.
 * Commander Lambda uses an automated algorithm to assign minions randomly to tasks, in order to keep her minions on their toes. But you've noticed a flaw in the algorithm - it eventually loops back on itself, so that instead of assigning new minions as it iterates, it gets stuck in a cycle of values so that the same minions end up doing the same tasks over and over again. You think proving this to Commander Lambda will help you make a case for your next promotion.
 * <p>
 * You have worked out that the algorithm has the following process:
 * <p>
 * 1) Start with a bigO.src.practice.random minion ID n, which is a nonnegative integer of length k in base board
 * 2) Define x and y as integers of length k.  x has the digits of n in descending order, and y has the digits of n in ascending order
 * 3) Define z = x - y.  Add leading zeros to z to maintain length k if necessary
 * 4) Assign n = z to get the next minion ID, and go back to step 2
 * <p>
 * For example, given minion ID n = 1211, k = 4, board = 10, then x = 2111, y = 1112 and z = 2111 - 1112 = 0999. Then the next minion ID will be n = 0999 and the algorithm iterates again: x = 9990, y = 0999 and z = 9990 - 0999 = 8991, and so on.
 * <p>
 * Depending on the values of n, k (derived from n), and board, at some point the algorithm reaches a cycle, such as by reaching a constant value. For example, starting with n = 210022, k = 6, board = 3, the algorithm will reach the cycle of values [210111, 122221, 102212] and it will stay in this cycle no matter how many times it continues iterating. Starting with n = 1211, the routine will reach the integer 6174, and since 7641 - 1467 is 6174, it will stay as that value no matter how many times it iterates.
 * <p>
 * Given a minion ID as a string n representing a nonnegative integer of length k in base board, where 2 <= k <= 9 and 2 <= board <= 10, write a function answer(n, board) which returns the length of the ending cycle of the algorithm above starting with n. For instance, in the example above, answer(210022, 3) would return 3, since iterating on 102212 would return to 210111 when done in base 3. If the algorithm reaches a constant, such as 0, then the length is 1.
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
 * (string) n = "1211"
 * (int) board = 10
 * Output:
 * (int) 1
 * <p>
 * Inputs:
 * (string) n = "210022"
 * (int) board = 3
 * Output:
 * (int) 3
 */
public class Answer2 {

    public static void main(String[] str) {


        int res = answer("210022", 3);
        System.out.println("result : " + res);

//        System.out.println(answer("1211", 10)); //1


//        System.out.println(answer(7641, 10));
//
//
//        LinkedList<Integer> test = new LinkedList<>();
//        test.addFirst(19);
//        minus(test,10);


    }

    public static int answer(String n, int b) {

        int k = n.length();

        int a = Integer.valueOf(n);

        LinkedList<Integer> zeroConstant = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            zeroConstant.add(0);
        }

        int[] nRep = new int[k];
        LinkedList<Integer> input = new LinkedList<>();
        while (a > 0) {

            int digit = a % 10;
            input.addFirst(digit);
            a = a / 10;
        }

        printNumber(input, "in");
        System.out.println();
        LinkedList fast = input;
        LinkedList slow = input;

        while (true) {
            Collections.sort(fast);
            LinkedList<Integer> temp = minus(fast, b, k);
            Collections.sort(temp);
            fast = minus(temp, b, k);


            Collections.sort(slow);
            slow = minus(slow, b, k);
            if (slow.equals(zeroConstant)) {
                return 1;
            }
            printNumber(slow, "slow");
            printNumber(fast, "fast");
            System.out.println();

            if (fast.equals(slow)) {
                break;
            }
        }


        int count = 0;
        do {
            count++;
            Collections.sort(slow);
            slow = minus(slow, b, k);
        } while (!slow.equals(fast));


        System.out.println();
        return count;
    }

    public static Object[] reverse(Object[] arr) {
        List<Object> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }

    private static LinkedList<Integer> minus(LinkedList<Integer> input, int base, int k) {
        Iterator<Integer> i = input.iterator();
        Iterator<Integer> reverseI = input.descendingIterator();


        LinkedList<Integer> result = new LinkedList<>();
        int c = 0;
        while (i.hasNext()) {
            int left = i.next();
            int right = reverseI.next();
            int temp = left - right - c;

            if (temp < 0) {
                int newt = base + left - c - right;
                result.addFirst(newt);
                c = 1;
            } else {
                c = 0;
                result.addFirst(temp);
            }
        }
        if (c > 0) {
            result.add(c);
        }
        if (result.size() < k) {
            while (result.size() != k) {
                result.addFirst(0);
            }
        }

        return result;
    }


    private static void printNumber(LinkedList<Integer> result, String type) {
        Iterator i = result.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(type + " ");
        while (i.hasNext()) {
            sb.append(i.next() + " ");
        }
        System.out.println(sb.toString());
        System.out.println();
    }

}
