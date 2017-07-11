package bigO.src.practice.google.strings;

/**
 * Created by Stanimir on 5/28/17.
 */
public class LongestContiniousSubarray {

    public static void main(String[] str) {
        int res = findLogestContiniousSubarray(new int[]{-2, -3, 4, -1, - 2,  1, 5, -3});
        System.out.println(res);
    }

    private static int findLogestContiniousSubarray(int[] arr) {
        int longestSoFar = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int newSum = longestSoFar + arr[i];
            if (newSum < 0) {
                longestSoFar = 0;
            }else{
                longestSoFar = newSum;

            }
             if (newSum > max) {
                max = newSum;
            }
        }
        return max;
    }

}
