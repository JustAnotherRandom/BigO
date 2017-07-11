package bigO.src.practice.foobar;

import java.util.*;

/**
 * Created by Stanimir on 5/8/17.
 */
public class Area {

    public static void main(String[] str) {
//        int area = 12;
//        //3,1,1,1
//
//
//        int area2 = 15324;
//        //15129, 169, 25, 1
//
//        int[] res = answer(1000000);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i] + " ");
//        }

//        int res = answer(210022, 3);
//        System.out.println("result : " + res);
//        System.out.println(answer(210111, 3));
        System.out.println(answer(1211, 10));
//        System.out.println(answer(7641, 10));
//
//
//        LinkedList<Integer> test = new LinkedList<>();
//        test.addFirst(19);
//        minus(test,10);


    }

    public static int[] answer(int area) {
        if (area < 1) return new int[]{};
        double tempSideAsDouble = 0;

        List<Integer> tempResult = new ArrayList<>();
        while (area > 1) {
            tempSideAsDouble = Math.floor(Math.sqrt(area));


            int squareSide = Double.valueOf(tempSideAsDouble).intValue();
            int squareArea = squareSide * squareSide;
            tempResult.add(squareArea);

            area = area - squareArea;
        }
        if (area == 1) {
            tempResult.add(area);
        }


        int[] result = new int[tempResult.size()];


        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }

        return result;
    }

    public static int answer(int a, int b) {
        String in = String.valueOf(a);
        int k = in.length();


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
        int i = 15;
        while (true) {
            Collections.sort(fast);
            LinkedList<Integer> temp = minus(fast, b);
            Collections.sort(temp);
            fast = minus(temp, b);


            Collections.sort(slow);
            slow = minus(slow, b);
            if (slow.equals(zeroConstant)) {
                return 1;
            }
//            fast = minus(fast,board);
            System.out.println();
            printNumber(slow, "slow");
            printNumber(fast, "fast");
            System.out.println();

            if (fast.equals(slow)) {
                break;
            }
        }

        slow = input;

        int count = 0;
        while (!slow.equals(fast)) {
            count++;
            Collections.sort(slow);
            slow = minus(slow, b);
            Collections.sort(fast);
            fast = minus(fast, b);
        }

        System.out.println();
        return count;
    }

    private static LinkedList<Integer> minus(LinkedList<Integer> input, int base) {
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

    public static Object[] reverse(Object[] arr) {
        List<Object> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }


    public static int minus(int[] num, int base) {


        int[] res = new int[num.length];
        int c = 0;
        int r = 0;
        int ir = num.length - 1;
        for (int i = 0, j = num.length - 1; i < num.length; i++, j--) {
            c += num[i] - num[j] >= 0 ? 0 : 1;
            if (num[i] - num[j] + c < 0) {
                c++;
                res[ir--] = base - num[i] - num[j];
            }

            r = num[i] - num[j];
        }

        return 0;
    }
}
