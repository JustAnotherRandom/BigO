package bigO.src.strings;

/**
 * Created by Stanimir on 2/27/17.
 */
public class Palindrome {

    public static void main(String str[]) {
//        System.out.println(isItPalindrome("tactcoapapa"));
        System.out.println(isItPalindromeOptimized("tactcoapapa"));
    }

    private static boolean isItPalindrome(String s) {
        boolean hasEven = false;
        int[] bitset = new int['z' - 'a' + 1];
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int charIndex = calcCharIndex(letters[i]);
            bitset[charIndex]++;
        }
        for (int i = 0; i < bitset.length; i++) {
            if (bitset[i] % 2 != 0) {
                if (hasEven == true) {
                    return false;
                }
                hasEven = true;
            }
        }
        return true;
    }

    private static boolean isItPalindromeOptimized(String s) {
        int countOdd = 0;
        int[] bitset = new int['z' - 'a' + 1];
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int charIndex = calcCharIndex(letters[i]);
            bitset[charIndex]++;
            if (bitset[charIndex] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        return countOdd > 1;
    }

    private static int calcCharIndex(char letter) {
        return letter - 'a';
    }
}
