package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 6/13/17.
 */
public class IsSubsequence {

    public static void main(String[] str) {
        String p = "nano";
        String s = "nematode knowledge";
        System.out.println(isSubsequence(s, p, 0, 0));
    }

    private static boolean isSubsequence(String s, String p, int si, int pi) {
        if (pi >= p.length() || si >= s.length()) return false;


        if (s.charAt(si) == p.charAt(pi)) {
            if (pi == p.length() - 1) {
                return true;
            } else {
                return isSubsequence(s, p, si + 1, pi + 1);
            }
        } else {
            return isSubsequence(s, p, si + 1, pi);
        }
    }

}
