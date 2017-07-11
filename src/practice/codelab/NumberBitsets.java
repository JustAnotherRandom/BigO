package bigO.src.practice.codelab;

/**
 * Created by Stanimir on 5/19/17.
 */
public class NumberBitsets {

    public static void main(String[] str) {
        System.out.printf(answer(11L) + "");
    }

    private static int answer(long i) {
        int count = 0;

        for (int j = 0; j < 64; j++) {
            if (isSet(i, j)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSet(long i, int j) {
        long mask = 1L << j;
        return (i & mask) != 0;
    }

}
