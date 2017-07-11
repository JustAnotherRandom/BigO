package bigO.src.practice.randomCompanies;

import java.util.ArrayDeque;

/**
 * Created by Stanimir on 5/14/17.
 */
public class TripleByte {

    public static void main(String[] str) {
        System.out.println(4 & 3);
//        System.out.println(almost_palindromes("abcdcaa"));

//        System.out.println(ascii_deletion_distance("thought", "sloughs"));

//        System.out.println(bracket_match("((())"));


//        System.out.println(number4LetterWords("Sdf4 236"));

    }




    public static int almost_palindromes(String str) {
        char[] temp = str.toCharArray();

        int coumnt = 0;


        int low = 0;
        int high = temp.length - 1;
        while (low <= high) {
            if (temp[low] != temp[high]) {
                coumnt++;
            } else {

            }
            low++;
            high--;
        }
        if (temp.length % 2 != 0) {
            coumnt = coumnt * 2;
        }
        return coumnt;
    }

    public static int ascii_deletion_distance(String str1, String str2) {
        int count = 0;


        int ind1 = 0;
        int ind2 = 0;


        while (ind1 < str1.length() && ind2 < str2.length()) {

            char s1 = str1.charAt(ind1);
            char s2 = str2.charAt(ind2);


            if (s1 == s2) {
                ind1++;
                ind2++;
            } else {

                if (ind1 + 1 < str1.length() && str1.charAt(ind1 + 1) == s2) {
                    ind1++;
                    count += s1;
                } else if (ind2 + 1 < str2.length() && str2.charAt(ind2 + 1) == s1) {
                    ind2++;
                    count += s2;
                } else {
                    ind1++;
                    ind2++;
                    count += s1;
                    count += s2;
                }
            }
        }


        return count;


    }

    public static int bracket_match(String bracket_string) {
        int count = 0;


        char leftB = '(';
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < bracket_string.length(); i++) {
            if (bracket_string.charAt(i) == leftB) {
                stack.push(bracket_string.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    char t = bracket_string.charAt(i);
                    if (t == stack.pop()) {
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            count++;
        }

        return count;
    }

    private static int number4LetterWords(String in) {
        int count = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < in.length()) {

            char temp = in.charAt(index);
            if (temp != ' ') {
                sb.append(temp);
            } else {
                if (sb.toString().length() == 4) {
                    count++;
                }
                sb.setLength(0);
            }
            index++;
        }
        if (sb.length() == 4) {
            count++;
        }

        return count;
    }

}
