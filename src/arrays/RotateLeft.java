package bigO.src.arrays;

import java.util.Scanner;

/**
 * Created by Stanimir on 5/7/17.
 */
public class RotateLeft {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] numbs = new int[n];
        String strIn = sc.nextLine();
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
        }
        // 0 ->0
        // 1 ->1
        // 2 ->2
        // 3 ->3
        // 4 ->4
        // 5 ->0
        // 6 ->1

        d = d < n ? n - d : (n - d) % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {

            int displaced = (i + n - (n-d)) % n;
            swap(numbs, i, displaced);


//            res[i] = numbs[displaced];
        }


        for (int i = 0; i < n; i++) {
            System.out.print(numbs[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
