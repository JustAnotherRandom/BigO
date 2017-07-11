package bigO.src.heaps;

import java.util.PriorityQueue;

/**
 * Created by Stanimir on 6/14/17.
 * http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 */
public class MergeKSortedArrays {

    static class Entry<E extends Comparable> implements Comparable {
        E val;
        int pos;
        int arrayId;

        Entry(E val, int pos, int arrayId) {
            this.val = val;
            this.pos = pos;
            this.arrayId = arrayId;
        }

        @Override
        public int compareTo(Object o) {
            return val.compareTo(((Entry) o).val);
        }
    }

    public static int[] merge(int[][] arr) {
        if (arr == null) return null;
        if (arr.length <= 1) return arr[0];


        int n = arr.length;
        int k = arr[0].length;


        PriorityQueue<Entry<Integer>> minHeap = new PriorityQueue();


        int firstElementIndex = 0;
        for (int arrayIndex = 0; arrayIndex < n; arrayIndex++) {
            int[] array = arr[arrayIndex];
            Entry e = new Entry(array[0], firstElementIndex, arrayIndex);
            minHeap.offer(e);
        }

        int[] res = new int[n * k];

        for (int i = 0; i < n * k; i++) {
            Entry currentMin = minHeap.poll();
            res[i] = (int) currentMin.val;
            int[] array = arr[currentMin.arrayId];
            int nextPos = currentMin.pos + 1;
            if (nextPos < array.length) {
                Entry next = new Entry(array[currentMin.pos + 1], nextPos, currentMin.arrayId);
                minHeap.offer(next);
            }

        }


        return res;
    }
}
