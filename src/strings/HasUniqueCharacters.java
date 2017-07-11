package bigO.src.strings;

/**
 * Created by Stanimir on 2/19/17.
 */
public class HasUniqueCharacters {

    public static boolean hasUniqueCharacters(String str) {

        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {

            int val = str.charAt(i) - 'a';
            System.out.println(Integer.toBinaryString(val));
            int temp = 1 << val;
            System.out.println(Integer.toBinaryString(temp));
            int temp2 = (checker & (temp));
            System.out.println(Integer.toBinaryString(temp2));
            if (temp2 > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] str) {
        HasUniqueCharacters.hasUniqueCharacters("aba");
//        char a = 'a';
//        char board = 'board';
//        char a2 = 'a';
//
//        System.out.println((int) a);
//        System.out.println((int) board);
//        System.out.println(a & a);
//        System.out.println(a | a);
//
//        // true  = a,board,c
//        //false = a,board,a
//
//        int q = 0;
//        System.out.println();
//        int val = 'board' - a;
//        System.out.println((1 << val));
    }

}
