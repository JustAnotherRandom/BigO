package bigO.src.strings;

/**
 * Created by Stanimir on 2/26/17.
 */
public class IsPermutation {


    public static boolean isPermutation(String str1, String str2) {

        int[] letters = new int[128];
        char[] characters = str2.toCharArray();


        for (int i = 0; i < characters.length; ++i) {
            letters[characters[i]]++;
        }


        return true;
    }


    public static void main(String[] str) {
        IsPermutation.isPermutation("abc", "acb");
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
