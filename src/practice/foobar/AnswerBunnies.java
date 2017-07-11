package bigO.src.practice.foobar;

/**
 * Created by Stanimir on 5/16/17.
 */

import java.util.*;

class subsetComparator implements Comparator<LinkedList<Integer>> {
    @Override
    public int compare(LinkedList<Integer> a, LinkedList<Integer> b) {

        if (a.size() != b.size())
            return (b.size() - a.size());
        else {
            for (int i = 0; i < a.size(); i++) {

                if (a.get(i) < b.get(i))
                    return a.get(i) - b.get(i);

                else if (a.get(i) > b.get(i))
                    return a.get(i) - b.get(i);

            }
            return 1;
        }
    }
}

public class AnswerBunnies {

    static Set<LinkedList<Integer>> set = new HashSet<LinkedList<Integer>>();
    static LinkedList<LinkedList<Integer>> permutations = new LinkedList<LinkedList<Integer>>();

    public static void permute(LinkedList<LinkedList<Integer>> subsets, int at, int index) {

        LinkedList<Integer> subset = subsets.get(index);

        for (int i = at; i < subset.size(); i++) {

            Collections.swap(subset, i, at);

            if (!set.contains(subset)) {

                LinkedList<Integer> new_perm = new LinkedList<Integer>(subset);

                set.add(subset);
                permutations.add(new_perm);

            }
            System.out.println();
            permute(subsets, at + 1, index);

            Collections.swap(subset, at, i);
        }


    }


    public static LinkedList<LinkedList<Integer>> subsets(int bunnies) {

        LinkedList<LinkedList<Integer>> subsets = new LinkedList<LinkedList<Integer>>();

        int max = (int) Math.pow(2, bunnies) - 1;

        int maxLen = Integer.toBinaryString(max).length();

        String bin;

        for (; max >= 0; max--) {

            bin = Integer.toBinaryString(max);

            int diff = maxLen - bin.length();

            for (int l = 0; l < diff; l++)
                bin = "0" + bin;

            LinkedList<Integer> subset = new LinkedList<Integer>();

            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
//                    System.out.print(i + " ");
                    subset.add(i);
                }
            }

            subsets.add(subset);
//            System.out.println();
        }

        Collections.sort(subsets, new subsetComparator());

        return subsets;

    }


    public static int[] answer(int[][] times, int time_limit) {

        // Your code goes here.
        int len = times.length;

        LinkedList<LinkedList<Integer>> subsets = subsets(len - 2);


        int[][] min = new int[len][len];

        int src = 0;
        System.out.println();
        for (int z = 0; z < len; z++) {
            for (src = 0; src < len; src++) {
                if (z == 0) {
                    for (int i = 0; i < len; ++i) {
                        min[src][i] = Integer.MAX_VALUE;
                    }
                    min[src][src] = 0;
                }
                print(min);
                System.out.printf("");
                for (int i = 0; i < len; ++i)
                    for (int j = 0; j < len; ++j)
                        if (min[src][i] != Integer.MAX_VALUE && min[src][i] + times[i][j] < min[src][j]) {
                            min[src][j] = min[src][i] + times[i][j];
                        }
            }
        }
        print(min);
        System.out.printf("");
        for (src = 0; src < len; src++) {
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    if (min[src][i] + times[i][j] < min[src][j]) {
                        int[] cycle = new int[len - 2];

                        for (int c = 0; c < len - 2; c++)
                            cycle[c] = c;

                        return cycle;
                    }
                }
            }
        }

        // -=-

        int from;
        int time;

        for (int index = 0; index < subsets.size(); index++) {
            permute(subsets, 0, index);

            //Collections.sort(permutations, new subsetComparator());

            for (int p = 0; p < permutations.size(); p++) {

                from = 0;
                time = time_limit;

                LinkedList<Integer> perm = permutations.get(p);

                for (int i = 0; i < perm.size(); i++) {

                    time -= min[from][perm.get(i) + 1];
                    from = perm.get(i) + 1;

                }

                time -= min[from][len - 1];

                if (time >= 0) {

                    int[] result = new int[subsets.get(index).size()];

                    for (int r = 0; r < subsets.get(index).size(); r++)
                        result[r] = subsets.get(index).get(r);

                    set.clear();
                    permutations.clear();

                    return result;
                }

            }

            set.clear();
            permutations.clear();

        }

        int[] result = new int[0];

        return result;
    }

    public static void main(String[] str) {
        int[][] in = new int[][]{
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}};
        print(in);
        int[] answer = answer(in, 3);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    private static void print(int[][] res) {
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
