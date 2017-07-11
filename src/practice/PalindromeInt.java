package bigO.src.practice;

/**
 * Created by Stanimir on 3/8/17.
 */
public class PalindromeInt {

    public static void main(String[] str) {
        System.out.println(isPalindrome(2332));
    }

    private static boolean isPalindrome(int num) {
        int div = 1;

        int temp = num;
        while (temp > 10) {
            div = div * 10;
            temp = temp / 10;
        }

        while (div > 10) {
            int left = num / div;
            int right = num % 10;

            if (left != right) return false;

            num = num / 10;
            num = num % ((num / 10) * 10);
            div = div / 100;

        }
        return true;
    }

}
