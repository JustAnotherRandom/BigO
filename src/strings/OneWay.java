package bigO.src.strings;

/**
 * Created by Stanimir on 2/27/17.
 */
public class OneWay {
    static boolean oneWay(String s1, String s2) {
        if (!isOneWayPossible(s1, s2)) return false;

        boolean changed = false;
        int maxLen = Math.min(s1.length(), s2.length());
        for (int a = 0, b = 0; a < maxLen || b < maxLen; ) {
            if (s1.charAt(a) == s2.charAt(b)) {
                a++;
                b++;
            } else if (s1.length() > s2.length()) {

                if ((s1.charAt(a + 1) == s2.charAt(b) && !changed)) {
                    a++;
                    changed = true;
                } else {
                    return false;
                }
            } else if (s1.length() < s2.length()) {

                if ((s2.charAt(b + 1) == s1.charAt(a)) && !changed) {
                    b++;
                    changed = true;
                } else {
                    return false;
                }
            } else {
                if (changed) return false;
                a++;
                b++;
                changed = true;
            }
        }
        return true;
    }

    private static boolean isOneWayPossible(String s1, String s2) {
        return true;
    }

    public static void main(String[] str) {
        System.out.println(OneWay.oneWay("pale", "ple"));
        System.out.println(OneWay.oneWay("pales", "ple"));
        System.out.println(OneWay.oneWay("pale", "bale"));
        System.out.println(OneWay.oneWay("pale", "bake"));
    }
}
