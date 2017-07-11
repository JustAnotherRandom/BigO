package bigO.src.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Stanimir on 5/21/17.
 */
public class SubsetSumProblem {

    public static void main(String[] str) {
//        System.out.println(hasSubsetSum(new int[]{1, 5, 11, 5}));
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int i = 0; i < numTests; i++) {
            int arrSize = sc.nextInt();
            int[] in = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                in[j] = sc.nextInt();
            }
            if (hasSubsetSum(in)) {
                System.out.printf("YES");
            } else {
                System.out.printf("NO");
            }

        }
        //1,5,5,11
    }

    static boolean hasSubsetSum(int[] in) {
        if (in.length < 2) return false;
        Arrays.sort(in);


        int l = 0;
        int r = in.length - 1;
        int sum1 = in[l];
        int sum2 = in[r];
        while (l < r) {

            if (sum1 == sum2) {
                return true;
            }

            if (sum1 < sum2) {
                sum1++;
            } else {
                sum2--;
            }

        }


        return false;
    }

}
