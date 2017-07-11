package bigO.src.dp;

/**
 * Created by Stanimir on 3/10/17.
 */
public class TripleStep {

    public static void main(String[] str) {
        System.out.println(calc(30));
//        System.out.println(calcD(30));
    }

    private static int calcD(int step) {

        int[] cache = new int[step + 1];
        return calcD(cache, step);
    }

    private static int calcD(int[] cache, int step) {
        if (step < 0) {
            return 0;
        } else if (step == 1) {
            return 1;
        } else {
            if (cache[step] > 0) {
                return cache[step];
            } else {
                cache[step] = calcD(cache, step - 1) + calcD(cache, step - 2) + calcD(cache, step - 3);
                return cache[step];
            }
        }
    }

    private static int calc(int step) {

        if (step < 0) {
            return 0;
        } else if (step == 1) {
            return 1;
        } else {
            return calc(step - 1) + calc(step - 2) + calc(step - 3);
        }
    }


}
