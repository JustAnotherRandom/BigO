package bigO.src.practice.foobar;

import java.math.BigInteger;

/**
 * Created by Stanimir on 5/11/17.
 * Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP - and maybe sneak in a bit of sabotage while you're at it - so you took the job gladly.
 * <p>
 * Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake. You need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time.
 * <p>
 * The fuel control mechanisms have three operations:
 * <p>
 * 1) Add one fuel pellet
 * 2) Remove one fuel pellet
 * 3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)
 * <p>
 * Write a function called answer(n) which takes a positive integer as a string and returns the minimum number of operations needed to transform the number of pellets to 1. The fuel intake control panel can only display a number up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.
 * <p>
 * For example:
 * answer(4) returns 2: 4 -> 2 -> 1
 * answer(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1
 * <p>
 * <p>
 * Languages
 * =========
 * <p>
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit solution.java
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (string) n = "4"
 * Output:
 * (int) 2
 * <p>
 * Inputs:
 * (string) n = "15"
 * Output:
 * (int) 5
 */
public class fuel_injection_perfection_6 {

    public static void main(String[] str) {
        System.out.println(answer("4"));//2
        System.out.println(answer("15"));//5
    }

    public static final BigInteger valueOfTwo = BigInteger.valueOf(2);
    public static final BigInteger valueOfThree = BigInteger.valueOf(3);

    public static int answer(String n) {
        BigInteger in = new BigInteger(n, 10);

        if (in.equals(valueOfThree))
            return 2;


        int c = 0;
        while (!in.equals(BigInteger.ONE)) {

            if (in.equals(valueOfThree)) {
                c += 2;
                break;
            }

            if (in.mod(valueOfTwo).equals(BigInteger.ZERO)) {
                in = in.divide(valueOfTwo);
            } else {

                if (isNextDivisible(in.add(BigInteger.ONE))) {
                    in = in.add(BigInteger.ONE);
                } else {
                    in = in.subtract(BigInteger.ONE);
                }
            }
            c++;
        }
        return c;
    }

    private static boolean isNextDivisible(BigInteger c) {
        BigInteger temp = c.divide(valueOfTwo);
        return temp.mod(valueOfTwo).equals(BigInteger.ZERO);
    }

}
