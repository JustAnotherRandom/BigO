package bigO.src.arrays;

/**
 * Created by Stanimir on 3/29/17.
 */
public class SubSort {

    public static void main(String[] str) {
        int[] array = {1, 9, 4, 3, 5};
//        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        findUnsortedSequence(array);
    }

    private static void findUnsortedSequence(int[] arr) {
        if (arr == null || arr.length <= 1) System.out.println("null");

        int l = 0;
        int h = arr.length - 1;
        while (l + 1 < arr.length && arr[l + 1] > arr[l]) {
            l++;
        }
        while (h - 1 >= 0 && arr[h - 1] < arr[h]) {
            h--;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = l; i <= h; i++) {
            int num = arr[i];
            if (num < min) min = num;
            if (num > max) max = num;
        }
        while (l - 1 >=0 && arr[l - 1] > min) l--;
        while (h + 1 <arr.length && arr[h + 1] < max) h++;

        if (validate(arr, l, h)) {
            System.out.println("TRUE: " + l + " " + h);
        } else {
            System.out.println("FALSE: " + l + " " + h);
        }
    }

    public static boolean validate(int[] array, int left_index, int right_index) {
        int[] middle = new int[right_index - left_index + 1];
        for (int i = left_index; i <= right_index; i++) {
            middle[i - left_index] = array[i];
        }
        java.util.Arrays.sort(middle);
        for (int i = left_index; i <= right_index; i++) {
            array[i] = middle[i - left_index];
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
