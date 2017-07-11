package bigO.src.practice.crackingthecodinginterview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Stanimir on 6/20/17.
 */

class MaxComparator implements Comparator {

    @Override
    public int compare(Object x, Object y) {

        return (int) y - (int) x;
    }
}

public class ContiniousMedian_17_20 {


    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public int addElement(int n) {

        if (maxHeap.isEmpty()) {
            maxHeap.offer(n);
            return getMedian();
        }


        int currentMedian = getMedian();
        if (n <= currentMedian) {//add to maxHeap
            if (maxHeap.size() > minHeap.size()) {//move maxHeap root to minHeap
                int oldMax = maxHeap.poll();
                maxHeap.offer(n);
                minHeap.offer(oldMax);
            } else {
                maxHeap.offer(n);
            }
        } else {//add to minHeap
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(n);
            } else {
                int oldMin = minHeap.poll();
                minHeap.offer(n);
                maxHeap.offer(oldMin);
            }
        }


        return getMedian();
    }

    private int getMedian() {
        return maxHeap.isEmpty() ? -1 : maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2;
    }
}
