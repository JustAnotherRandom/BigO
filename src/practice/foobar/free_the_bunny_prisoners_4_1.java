package bigO.src.practice.foobar;

/**
 * Created by Stanimir on 5/12/17.
 * Free the Bunny Prisoners
 * ========================
 * <p>
 * You need to free the bunny prisoners before Commander Lambda's space station explodes! Unfortunately, the commander was very careful with her highest-value prisoners - they're all held in separate, maximum-security cells. The cells are opened by putting keys into each console, then pressing the open button on each console simultaneously. When the open button is pressed, each key opens its corresponding lock on the cell. So, the union of the keys in all of the consoles must be all of the keys. The scheme may require multiple copies of one key given to different minions.
 * <p>
 * The consoles are far enough apart that a separate minion is needed for each one. Fortunately, you have already freed some bunnies to aid you - and even better, you were able to steal the keys while you were working as Commander Lambda's assistant. The problem is, you don't know which keys to use at which consoles. The consoles are programmed to know which keys each minion had, to prevent someone from just stealing all of the keys and using them blindly. There are signs by the consoles saying how many minions had some keys for the set of consoles. You suspect that Commander Lambda has a systematic way to decide which keys to give to each minion such that they could use the consoles.
 * <p>
 * You need to figure out the scheme that Commander Lambda used to distribute the keys. You know how many minions had keys, and how many consoles are by each cell.  You know that Command Lambda wouldn't issue more keys than necessary (beyond what the key distribution scheme requires), and that you need as many bunnies with keys as there are consoles to open the cell.
 * <p>
 * Given the number of bunnies available and the number of locks required to open a cell, write a function answer(num_buns, num_required) which returns a specification of how to distribute the keys such that any num_required bunnies can open the locks, but no group of (num_required - 1) bunnies can.
 * <p>
 * Each lock is numbered starting from 0. The keys are numbered the same as the lock they open (so for a duplicate key, the number will repeat, since it opens the same lock). For a given bunny, the keys they get is represented as a sorted list of the numbers for the keys. To cover all of the bunnies, the final answer is represented by a sorted list of each individual bunny's list of keys.  Find the lexicographically least such key distribution - that is, the first bunny should have keys sequentially starting from 0.
 * <p>
 * num_buns will always be between 1 and 9, and num_required will always be between 0 and 9 (both inclusive).  For example, if you had 3 bunnies and required only 1 of them to open the cell, you would give each bunny the same key such that any of the 3 of them would be able to open it, like so:
 * [
 * [0],
 * [0],
 * [0],
 * ]
 * If you had 2 bunnies and required both of them to open the cell, they would receive different keys (otherwise they wouldn't both actually be required), and your answer would be as follows:
 * [
 * [0],
 * [1],
 * ]
 * Finally, if you had 3 bunnies and required 2 of them to open the cell, then any 2 of the 3 bunnies should have all of the keys necessary to open the cell, but no single bunny would be able to do it.  Thus, the answer would be:
 * [
 * [0, 1],
 * [0, 2],
 * [1, 2],
 * ]
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (int) num_buns = 2
 * (int) num_required = 1
 * Output:
 * (int) [[0], [0]]
 * <p>
 * Inputs:
 * (int) num_buns = 5
 * (int) num_required = 3
 * Output:
 * (int) [[0, 1, 2, 3, 4, 5], [0, 1, 2, 6, 7, 8], [0, 3, 4, 6, 7, 9], [1, 3, 5, 6, 8, 9], [2, 4, 5, 7, 8, 9]]
 * <p>
 * Inputs:
 * (int) num_buns = 4
 * (int) num_required = 4
 * Output:
 * (int) [[0], [1], [2], [3]]
 */
public class free_the_bunny_prisoners_4_1 {

    public static void main(String[] str) {
        int[][] res = answer(3, 2); // [0][0]
//        int[][] res = answer(5, 3);
        /*[[0, 1, 2, 3, 4, 5],
         [0, 1, 2, 6, 7, 8],
         [0, 3, 4, 6, 7, 9],
         [1, 3, 5, 6, 8, 9],
         [2, 4, 5, 7, 8, 9]]*/
//        int[][] res = answer(4, 4);//[0][1][2][3]


        print(res);
    }

    private static void print(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] answer(int num_buns, int num_required) {
        //4,2
        //0,1,2,3
        int numberKeys = findNumberOfKeys(num_buns, num_required);
        int[] digits = new int[numberKeys];
        for (int i = 0; i < numberKeys; i++) {
            digits[i] = i;
        }
        int[][] res = new int[numberKeys][num_required];
        generatePerm(digits, res, new int[num_required], 0, digits.length , 0, new Index());
        System.out.println();
        print(res);

        /*
        * [
        *   [],
        *
        *
        * ]
        *
        * */


        return new int[][]{};
    }

    static class Index {
        int index;
    }

    //0,1,2
    private static void generatePerm(int[] digits, int[][] res, int[] temp,
                                     int start, int end, int index, Index resI) {
        int r = temp.length;
        if (index == r) {
            for (int i = 0; i < temp.length; i++) {
                res[resI.index][i] = temp[i];
            }
            resI.index++;
            return;
        }

//  r-index< end -i +1
        // r-index + i -1 < end
        for (int i = start; i < end && end - i + 1 > r - index; i++) {
            temp[index] = digits[i];
            generatePerm(digits, res, temp, i + 1, end, index + 1, resI);
        }

    }


    // 5! = 5! * 4! * 3! * 2! *1!
    static int factorial(int[] cache, int n) {

        if (n == 2) return 2;
        if (n == 1) return 1;

        if (cache[n] == 0) {
            cache[n] = n * factorial(cache, n - 1);
        }

        return cache[n];
    }

    static int factorial(int n) {
        int[] cache = new int[n + 1];
        return factorial(cache, n);
    }

    //combinations formula
    static int findNumberOfKeys(int number_buns, int k) {
        return factorial(number_buns) / (factorial(number_buns - k) * factorial(k));
    }

}
