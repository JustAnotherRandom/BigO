package bigO.src.practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Stanimir on 5/4/17.
 */
public class ModifyedFibunacii {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);

        String strIn = sc.nextLine();
        String[] inputs = strIn.split(" ");
        if (inputs.length == 3) {
            int aAsInt = Integer.valueOf(inputs[0]);
            BigInteger a = aAsInt == 0 ? BigInteger.ZERO : BigInteger.valueOf(aAsInt);

            int bAsInt = Integer.valueOf(inputs[1]);
            BigInteger b = bAsInt == 0 ? BigInteger.ZERO : BigInteger.valueOf(bAsInt);

            System.out.println(modifiedFib(a, b, Integer.valueOf(inputs[2])).toString());


            int n = Integer.valueOf(inputs[2]);
            System.out.println(topDown(n, new BigInteger[n + 1]));

        }

    }

    private static BigInteger modifiedFib(BigInteger a, BigInteger b, int n) {


        // n = a + board^2
        for (int i = 3; i <= n; i++) {
            BigInteger temp = a;
            a = b;
            b = temp.add(a.multiply(a));
        }
        return b;
    }

    static BigInteger topDown(int n, BigInteger[] memo) {
        if (n == 1) return BigInteger.ZERO;
        if (n == 2) return BigInteger.ONE;

        if (memo[n] == null) {
            memo[n] = topDown(n - 2, memo).add((topDown(n - 1, memo).multiply(topDown(n - 1, memo))));
        }

        return memo[n];
    }

}
