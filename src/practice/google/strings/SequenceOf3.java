package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 5/27/17.
 */
public class SequenceOf3 {

    public static void main(String[] str) {
        System.out.println(verify("11122233") + "");
    }

    private static int verify(String seq) {
//        char[] charSeq = seq.toCharArray();
        int realSum = 3 * Character.getNumericValue(seq.charAt(1));
        int sum = Character.getNumericValue(seq.charAt(0));

        int index = 1;
        for (int i = 1; i < seq.length(); i++) {
            int digit = Character.getNumericValue(seq.charAt(i));
            sum += digit;
            if (i - index == 3) {
                int add = 3 * digit;
                realSum += add;
                index = i;
            }
        }
        return realSum - sum;
    }

}
