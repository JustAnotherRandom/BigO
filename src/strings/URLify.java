package bigO.src.strings;

import java.util.Arrays;

/**
 * Created by Stanimir on 2/26/17.
 */
public class URLify {

    private static final char EMPTY = ' ';

    public static char[] URILify(char[] letters, int len) {


        int spaces = calculateSpaces(letters);
        int lastIndex = letters.length - 1;
        for (int i = len - 1; i > 0; i--) {
            if (letters[i] != EMPTY) {

                letters[lastIndex--] = letters[i];
            } else {
                letters[lastIndex--] = '0';
                letters[lastIndex--] = '2';
                letters[lastIndex--] = '%';
                spaces--;

            }
        }

        return letters;
    }

    private static int calculateSpaces(char[] letters) {
        int spaces = 0;
        for (int i = 0; i < letters.length; i++) {
            int next = i + 1;
            if (letters[i] == EMPTY && ((next < letters.length) && letters[next] != EMPTY)) {
                spaces++;
            }
        }
        return spaces;
    }

    public static void main(String[] str) {
        char[] res = URLify.URILify("Mr John Smith    ".toCharArray(), 13);
        System.out.println(Arrays.toString(res));
    }
}
