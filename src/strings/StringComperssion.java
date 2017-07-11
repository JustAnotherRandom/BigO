package bigO.src.strings;

/**
 * Created by Stanimir on 3/9/17.
 */
public class StringComperssion {

    public static void main(String[] str) {
        System.out.println(compress("aabcccccaaaa"));
    }

    private static String compress(String str) {


        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i + 1 < str.length()) {
                char next = str.charAt(i + 1);
                if (c == next) {
                    count++;
                } else {
                    sb.append(c + "" + count);
                    count = 1;
                }
            } else {
                sb.append(c + "" + count);
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;


    }

}
