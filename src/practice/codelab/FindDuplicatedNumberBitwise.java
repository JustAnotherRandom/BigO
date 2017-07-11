package bigO.src.practice.codelab;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Stanimir on 5/19/17.
 */
public class FindDuplicatedNumberBitwise {

    public static void main(String[] str) {
        int[] in = new int[]{493, 282, 864, 847, 902, 846, 891, 988, 582, 217, 42, 404, 439, 554, 542, 334, 569, 42, 332, 419, 251, 542, 102, 776, 309, 182, 123, 980, 334, 636, 902, 223, 814, 837, 309, 980, 776, 521, 217, 864, 553, 493, 736, 631, 84, 180, 582, 533, 533, 404, 182, 439, 289, 332, 792, 814, 251, 521, 569, 891, 970, 792, 970, 553, 974, 736, 974, 769, 445, 733, 983, 846, 733, 988, 180, 245, 570, 102, 445, 419, 983, 570, 245, 631, 84, 123, 223, 636, 769, 818, 914, 818, 282, 914, 847, 319, 319, 837, 554};
        List<Integer> input = IntStream.of(in).boxed().collect(Collectors.toList());

        System.out.printf(singleNumber(input) + "");

    }

    public static int singleNumber(final List<Integer> a) {
        int result = 0;
        System.out.println("The repeating elements are : ");


        // i ^ i = 0
        // 1 ^
        for (int i = 0; i < a.size(); i++) {

            result ^= a.get(i);


        }

        return result;
    }
}
