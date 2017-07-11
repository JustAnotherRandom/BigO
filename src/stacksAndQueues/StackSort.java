package bigO.src.stacksAndQueues;

import java.util.Stack;

/**
 * Created by Stanimir on 3/9/17.
 */
public class StackSort {

    public static void main(String[] str) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(2);
//        stack.push(2);
//        stack.push(3);

        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void sort(Stack<Integer> stack) {
        int size = stack.size();
        Stack<Integer> temp = new Stack();

        Integer max = stack.peek();
        int count = 0;
        int times = 0;

        while (true) {
            while (!stack.isEmpty()) {
                if (max > stack.peek()) {
                    max = stack.peek();
                }
                count++;
                temp.push(stack.pop());
            }


            times = 0;
            for (int i = 0; i < count; i++) {
                if (max.equals(temp.peek())) {
                    temp.pop();
                    times++;
                } else {
                    stack.push(temp.pop());
                }
            }
            while (times > 0) {
                temp.push(max);
                times--;
            }

            if (temp.size() == size) {
                break;
            }
            count = 0;
            max = stack.peek();
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }

}
