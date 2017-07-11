package bigO.src.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanimir on 5/16/17.
 */
public class StringPermutations {

    public static void main(String[] str) {
        List<String> permutations = generatePermutations("a,board,c");
    }

    private static List<String> generatePermutations(String s) {
        String[] chars = s.split(",");
        List<String> result = new ArrayList<>();
        result = permutate(chars, chars.length - 1);
        return result;
    }

    private static List<String> permutate(String[] chars, int end) {
        List<String> seq;
        if (end < 0) {
            seq = new ArrayList<>();
            return seq;
        } else {
            seq = permutate(chars, end - 1);
            String item = chars[end];

            List<String> temp  = new ArrayList<>();
            for (String s :seq) {
                for (int i = 0; i <= s.length(); i++) {
                    temp.add(s.substring(0,i) + item + s.substring(i,s.length()));
                }
            }
            if(temp.isEmpty()){
                temp.add(item);
            }
            return temp;
        }
    }

}
