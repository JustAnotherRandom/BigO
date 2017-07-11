package bigO.src.practice.fb_interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/10/17.
 */
public class StepNext {

    public static void main(String[] str) {
        stepnum(10, 20);
    }

    public static ArrayList<Integer> stepnum(int a, int b) {
//check
        List<Integer> low = getAsArray(a);
        List<Integer> high = getAsArray(b);

        ArrayList<Integer> result = new ArrayList<>();
        stepNum(result, low.get(0), 0, new LinkedList<>(), low, high);
        result.stream().forEach(e -> System.out.print(e + " "));
        return null;

    }

    private static List<Integer> getAsArray(int a) {
        String[] charArr = String.valueOf(a).split("");
        return Arrays.asList(charArr).stream().map(Integer::valueOf).collect(Collectors.toList());
//        return Arrays.asList(Integer.valueOf(a).toString().split("")).stream().map(e->Integer.valueOf(e));
//        List<Integer> number = new ArrayList<>();
//        int remainder = -1;
//        while (a >= 10) {
//            remainder = a % 10;
//            number.add(a - remainder);
//            a = remainder;
//            // 123 % 10 = 23 %10 =3
//        }
//        if (remainder >= 0)
//            number.add(remainder);
//        return number;
    }

    public static void stepNum(List<Integer> res, int current, int index, LinkedList<Integer> number, List<Integer> low, List<Integer> high) {
        if (index == low.size()) return;
        number.add(current);
        if (index + 1 == low.size()) {

            res.add(collapse(number));
            return;
        }
        for (int curr = current; current <= high.get(index); current++) {
            int prev = curr - 1;
            int next = curr + 1;
            int nextInd = index + 1;


            if (prev >= low.get(nextInd)) {
                if (nextInd == low.size()) {
                    number.add(prev);
                    res.add(collapse(number));

                } else {
                    stepNum(res, prev, index + 1, number, low, high);
                    number.removeLast();
                }

            }
            if (next <= high.get(nextInd) || high.get(index) - low.get(index) > 0) {
                if (index + 1 == low.size()) {
                    number.add(next);
                    if (!number.isEmpty())
                        number.removeLast();

                } else {
                    stepNum(res, next, index + 1, number, low, high);
                    if (!number.isEmpty())
                        number.removeLast();
                }

            }
            if (index + 1 == low.size()) return;
            if (!number.isEmpty())
                number.removeLast();
        }

    }

    private static Integer collapse(LinkedList<Integer> number) {
        return Integer.valueOf(number.stream().map(String::valueOf).collect(Collectors.joining()));
    }


}
