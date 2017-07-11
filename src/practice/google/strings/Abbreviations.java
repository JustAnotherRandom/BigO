package bigO.src.practice.google.strings;

import java.util.*;

/**
 * Created by Stanimir on 7/4/17.
 */
public class Abbreviations {

    public static void main(String str[]) {
        String input = "ABC";
        Set<String> abbreviations = new HashSet<>();
//        gen(input, abbreviations, "");
        char[] arr = input.toCharArray();

        abbreviations.stream().forEach(System.out::println);
    }

    /*
    *ABC
    * A + 1 + C
               retList.append(prefix + str(len(s[:i+1])) + s[i+1:])
            abbreviations(s[i+1:], prefix + s[i])
    * */
    private static void gen(String input, Set<String> abbreviations, String prefix) {
        if (input == null || input.length() == 0) return;

        for (int i = 0; i < input.length(); i++) {
            String abbreviation = prefix + input.substring(0, i + 1).length() + input.substring(i + 1);
            abbreviations.add(abbreviation);
            gen(new String(input.substring(i + 1)), abbreviations, prefix + input.charAt(i));
        }
    }





}
