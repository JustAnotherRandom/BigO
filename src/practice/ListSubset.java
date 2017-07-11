package bigO.src.practice;

/**
 * Created by Stanimir on 3/3/17.
 */
public class ListSubset {

    public static void main(String str[]) {
        int[] l1 = new int[]{1, 2, 3, 6};
        int[] l2 = new int[]{2, 5, 6, 7};
        int[] leftSub = leftSub(l1, l2);
        for (int i = 0; i < leftSub.length; i++) {
            System.out.println(leftSub[i]);
        }
    }

    private static int[] leftSub(int[] l1, int[] l2) {
        int[] res = new int[l1.length];
        int resI = 0;
        int i = 0;
        for (int j = 0; i < l1.length; ) {
            if (j == l2.length) {
                while (i < l1.length) {
                    res[resI++] = l1[i++];
                }
                break;
            }

            if (l1[i] == l2[j]) {
                i++;
                j++;
            } else if (l1[i] < l2[j]) {
                res[resI++] = l1[i++];
            } else {
                j++;
            }
        }

        return res;
    }
}
