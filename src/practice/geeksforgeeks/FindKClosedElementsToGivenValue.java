package bigO.src.practice.geeksforgeeks;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/1/17.
 */
public class FindKClosedElementsToGivenValue {

    public static void main(String[] str) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};

        int[] res = solution(arr, 4, 35);
        System.out.println(Arrays.stream(res).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }


    static class Entry implements Comparable {
        int delta = 0;
        int value;

        Entry(int delta, int v) {
            this.delta = delta;
            this.value = v;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(((Entry) o).delta, delta);
        }
    }

    private static int[] solution(int[] arr, int k, int x) {
        int m = 0;

        int[] res = new int[k];
        while (m < arr.length && arr[m] < x) {
            m++;
        }
        if (m == arr.length) {
            int ir = 0;
            for (int i = m - 1; i >= arr.length - k; i--) {
                res[ir++] = arr[i];
            }
            return res;
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        int l = m - 1;
        int h = m + 1;


        for (int i = arr[m] == x ? m + 1 : m; i < arr.length && i < m + 4; i++) {
            int d = Math.abs(x - arr[i]);
            pq.add(new Entry(d, arr[i]));
            fixSize(k, pq);

        }
        for (int i = m - 1; i >= 0 && i > m - 4; i--) {
            int d = Math.abs(x - arr[i]);
            pq.add(new Entry(d, arr[i]));
            fixSize(k, pq);
        }
        return pq.stream().mapToInt(e -> e.value).toArray();
    }

    private static void fixSize(int k, PriorityQueue<Entry> pq) {
        if (pq.size() == k + 1) {
            pq.remove();
        }
    }

}
