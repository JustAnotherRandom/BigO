package bigO.src.practice.randomCompanies;

/**
 * Created by Stanimir on 5/30/17. 4m
 */
public class TripleByte2 {

    public static void main(String[] str) {
//        System.out.println(four_letter_words("This sentence is fine"));
//        System.out.println(ascii_deletion_distance("thought", "sloughs"));
//        System.out.println(almost_palindromes("aaabbb"));
//        System.out.println(bracket_match("((())"));


        System.out.println(4&3);



    }



    //7.5, ())->1, ((())-->1, (()) - > 0
    public static int bracket_match(String str) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res++;
                }

            }
        }

        return count + res;
    }

    //7.5  abcdcaa->2
    // fox ->2 - > xof
    // abba ->0.  aaabbb->6
    public static int almost_palindromes(String str) {
        int res = 0;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == str.charAt(len - 1 - i)) {
                continue;
            } else {
                res++;
            }
        }
        return res;
    }

    //15, at,cat, 99
    // boat,got ,298
    // thought, sloughs, 674
    public static int ascii_deletion_distance(String str1, String str2) {
        String first = str1.length() >= str2.length() ? str1 : str2;
        String second = str1.length() < str2.length() ? str1 : str2;


        int secondIndex = 0;
        int res = 0;
        for (int firstIndex = 0; firstIndex < first.length(); ) {
            if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
                firstIndex++;
                secondIndex++;
            } else {
                if (secondIndex + 1 < second.length() && first.charAt(firstIndex) == second.charAt(secondIndex + 1)) {
                    res += second.charAt(secondIndex);
                    secondIndex++;
                } else if (firstIndex + 1 < first.length() && first.charAt(firstIndex + 1) == second.charAt(secondIndex)) {
                    res += first.charAt(firstIndex);
                    firstIndex++;
                } else {
                    res += second.charAt(secondIndex++);
                    res += first.charAt(firstIndex++);
                }
            }
        }
        return res;
    }

    public static int four_letter_words(String sentence) {
        int index = 0;

        int currentWordLen = 0;
        int res = 0;
        while (index < sentence.length()) {
            if (sentence.charAt(index) == ' ') {
                if (currentWordLen == 4) {
                    res++;
                }
                currentWordLen = 0;
            } else {
                currentWordLen++;
            }

            index++;
        }

        if (currentWordLen == 4) {
            res++;
        }
        return res;
    }
}
