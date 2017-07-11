package bigO.src.practice.geeksforgeeks;

import java.util.Comparator;
import java.util.PriorityQueue;


class MaxComparator implements Comparator {

    @Override
    public int compare(Object x, Object y) {

        return (int) y - (int) x;
    }
}

class MedianInRunningStream {


    public static int getMedian(int ip, int m, PriorityQueue l_heap, PriorityQueue r_heap) {

        int diff = l_heap.size() - r_heap.size();
        //System.out.println("\n\nip : " + ip);

        switch (diff) {

            case 0:
                if (ip <= m) {

                    l_heap.offer(ip);
                    m = (int) l_heap.peek();
                } else {

                    r_heap.offer(ip);
                    m = (int) r_heap.peek();
                }
                break;

            case 1:
                if (ip <= m) {

                    r_heap.offer(l_heap.poll());
                    l_heap.offer(ip);
                } else {
                    r_heap.offer(ip);
                }
                m = ((int) l_heap.peek() + (int) r_heap.peek()) / 2;
                break;

            case -1:
                if (ip > m) {

                    l_heap.offer(r_heap.poll());
                    r_heap.offer(ip);
                } else {
                    l_heap.offer(ip);
                }
                m = ((int) l_heap.peek() + (int) r_heap.peek()) / 2;
                break;
        }

        //System.out.println("l_heap : " + l_heap);
        //System.out.println("r_heap : " + r_heap);
        return m;
    }

    public static void printMedian(int[] arr, int n) {

        MaxComparator max_comparator = new MaxComparator();
        PriorityQueue<Integer> l_heap = new PriorityQueue<Integer>(n / 2, max_comparator);
        PriorityQueue<Integer> r_heap = new PriorityQueue<Integer>();
        int m = 0;


        int size = 4;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n / 2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n / 2, max_comparator);

        for (int i = 0; i < n; i++) {

            addNumber(arr[i], size / 2, minHeap, maxHeap);
//            System.out.println("My Median: " + getMedian(minHeap, maxHeap));

            m = getMedian(arr[i], m, l_heap, r_heap);
            System.out.println("Added " + arr[i] + ". Median : " + m + " My Median: " + getMedian(minHeap, maxHeap));
        }
    }

    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.isEmpty()) return 0;
        if (minHeap.size() == maxHeap.size()) {
            return (Double.valueOf(minHeap.peek()) + Double.valueOf(maxHeap.peek())) / 2;
        } else {
            return maxHeap.peek();
        }
    }


    private static void addNumber(int n, int maxSize, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == maxHeap.size()) {
            if (!minHeap.isEmpty() && n > minHeap.peek()) {// if n < median --> maxHeap
                maxHeap.offer(minHeap.poll());
//                add(minHeap, maxSize, n);
                minHeap.add(n);
            } else {
                maxHeap.offer(n);
            }
        } else {
            if (n < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.add(n);
            } else {
                minHeap.offer(n);
            }
        }
    }

    static void add(PriorityQueue pq, int maxSize, int entry) {
        if (pq.size() == maxSize) {
            pq.remove(pq.size());
        } else {
            pq.offer(entry);
        }
    }

    public static void main(String[] args) {

//        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        int[] arr = {4, 8, 6, 2, 10, 12};
        int n = arr.length;
        printMedian(arr, n);
    }


}
