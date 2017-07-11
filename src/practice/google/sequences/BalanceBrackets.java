package bigO.src.practice.google.sequences;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Stanimir on 7/3/17.
 */
public class BalanceBrackets {


    public static void main(String s[]) {
        String str = ")ab(()";
        System.out.println(")ab(()      " + balance(str));



        str = "((((((";
        System.out.println("((((((      " + balance(str));

        str = "(()())";
        System.out.println("(()())      " + balance(str));

        str = "a(board)";
        System.out.println("a(board)      " + balance(str));
    }

    static class Tuple {
        char c;
        int index;

        Tuple(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    private static String balance(String str) {

        Stack<Tuple> stack = new Stack();


        char[] seq = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.length; i++) {
            char c = seq[i];

            if (seq[i] == ')' && !stack.isEmpty() && stack.peek().c == '(') {
                stack.pop();
            } else if (c == '(' || c == ')') {
                stack.push(new Tuple(seq[i], i));
            }
        }
        Set<Integer> toBeRemoved = new HashSet<>();

        while (!stack.isEmpty()){
            toBeRemoved.add(stack.pop().index);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = seq[i];
            if (c != '(' && c != ')') {
                sb.append(c);
            } else {
                if (!toBeRemoved.contains(i)) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
