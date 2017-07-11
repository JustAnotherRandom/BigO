package bigO.src.strings;

/**
 * Created by Stanimir on 2/27/17.
 */
public class PalindromeBitVector {


    static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;

        /*
        check if the bit is on or off
        e.g.:
        bitVector =0001;
        index = 2, 2 = 0010;
        mask= 1<<0010 = 0100;
        bitVector & mask = 0001 &0100 = 0101
        */
        if ((bitVector & mask) == 0) {
            /*Case A: Bit is not on
                    0001 & 0100 = 0000
            *
            * */

            //bit not toggled
            bitVector |= mask; //toggles the bit, 0001 | 0100 = 0101
        } else {
            //bit is toggled

            bitVector &= ~mask; // zeroes the bit in defined by the mask, ~mask inverts all the bits in the mask,
        }


        return bitVector;
    }

    public static void main(String[] str) {
//        System.out.println(Integer.toBinaryString(0));
//        int bitVector = PalindromeBitVector.toggle(0, 0);
//        System.out.println(Integer.toBinaryString(bitVector));
//        System.out.println(isItPalindrom("tactcoapapa"));


        System.out.println(isPalindrome3(3443));
    }

    public static boolean v2(int num) {
        assert (num >= 0);   // for non-negative integers only.
        int rev = 0;
        int temp = num;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return temp == rev;
    }

    static boolean isPalindrome(int x, int y) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (isPalindrome(x / 10, y) && (x % 10 == y % 10)) {
            y /= 10;
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalindrome3(int x) {
        return isPalindrome(x, x);
    }

    static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        //353
        //4422
        //435  no

        int counter = 0;
        // 11%10 = 1
        int bitCount = Integer.toBinaryString(x).length();
        for (int i = 0; i < bitCount; i++) {
            counter = counter ^ (x % x / 10);
            // 0000 & 0011 = 0011
            x = x / 10;
        }

        boolean isEven = ((bitCount % 2) == 0);

        if (isEven && counter > 0)

        {
            return false;
        } else if (!isEven && counter > 1)

        {
            return false;
        }

        return true;
    }

    private static boolean isItPalindrom(String str) {

        int bitVector = 0;
        for (Character c : str.toCharArray()) {
            int charRep = extractRep(c);
            if (charRep < 0) return false;
            bitVector = toggle(bitVector, charRep);
        }
        return hasOnlyOneBitSet(bitVector);
    }

    private static boolean hasOnlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int extractRep(Character c) {
        if (!('z' - c >= 0)) return -1;
        return c - 'a';
    }
}
