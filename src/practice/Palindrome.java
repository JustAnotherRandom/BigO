package bigO.src.practice;

/**
 * Created by Stanimir on 3/3/17.
 */
public class Palindrome {

    public static void main(String[] str) {


        int num = 3433;
        int div = 1;
        int temp = num;
        while (temp >= 10) {
            temp = temp / div;
            div *= 10;
        }


        while (num != 0) {
            int l = num / div; // 3443/100 = 3;
            int r = num % 10;// 3443 % 10 = 3
            if (l != r) System.out.println(false);

            // 3443 -> 44
            // f(3443) = 44 ,
            num = (num % div) / 10;
            div = div / 100;
        }
        System.out.println(true);
    }

}
