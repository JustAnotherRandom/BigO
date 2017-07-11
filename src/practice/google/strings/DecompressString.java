package bigO.src.practice.google.strings;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Stanimir on 5/27/17.
 */
public class DecompressString {


    Set<Character> chars = Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z').collect(Collectors.toSet());

    public static void main(String[] str) {
        DecompressString app = new DecompressString();
        System.out.println(app.decompress("a3[b2[c1[d]]]e"));
    }

    private String decompress(String str) {
        if (str == null || str.length() == 0) return "";
        if (str.length() == 1) return str;
        StringBuilder sb = new StringBuilder();


        int start = 0;
        int end = str.length() - 1;

        while (start < end && chars.contains(str.charAt(start))) {
            sb.append(str.charAt(start));
            start++;
        }

        StringBuilder digit = new StringBuilder();

        while (start < end && str.charAt(start) != '[') {
            digit.append(str.charAt(start++));
        }
        int times = digit.length() > 0 ? Integer.valueOf(digit.toString()) : 0;


        StringBuilder postfix = new StringBuilder();
        while (end - postfix.length() > start && chars.contains(str.charAt(end - postfix.length()))) {
            postfix.append(str.charAt(end - postfix.length()));

        }


        if (str.charAt(start) == '[' && str.charAt(end - postfix.length()) == ']') {
            start++;

            if (postfix.length() > 0 && str.charAt(end - postfix.length()) == ']')
                end--;
            if (start < end) {
                String res = decompress(str.substring(start, end));
                for (int i = 0; i < times; i++) {
                    sb.append(res);
                }

            }
        }
        sb.append(postfix.reverse());

        return sb.toString();
    }

}
