package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 3/8/17.
 */
public class NotUnion {

    public static void main(String[] str) {
        String s1 = "abc";
        String s2 = "aabcde";

        char[] res = findRes(s1, s2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static char[] findRes(String s1, String s2) {
        String longStr = s1.length() > s2.length() ? s1 : s2;
        String shortStr = s1.length() < s2.length() ? s1 : s2;
        int iRes = 0;
        char[] res = new char[Math.abs(s1.length() - s2.length())];
        for (int a = 0, b = 0; a < longStr.length(); ) {


            if ((b != shortStr.length()) && (longStr.charAt(a) == shortStr.charAt(b))) {
                a++;
                b++;
            } else {


                res[iRes++] = longStr.charAt(a++);
            }
        }
        return res;
    }

}
