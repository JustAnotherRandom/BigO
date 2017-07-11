package bigO.src.practice.crackingthecodinginterview;

import java.util.PriorityQueue;

/**
 * Created by Stanimir on 6/3/17.
 */
public class HistogramVolume17_20 {

    static class Result {
        public void append(Node segment) {
//            if (segment.volume == 0) return;
            if (head == null) {
                head = segment;
                tail = segment;
            } else {
                segment.prev = tail;
                tail.next = segment;
                tail = segment;
            }

        }

        public Node removeLast() {
            if (tail == null) return null;
            Node removed = tail;
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
            return removed;
        }

        static class Node {
            int volume;
            int index;

            Node next;
            Node prev;

            public Node(int i, int volume) {
                this.index = i;
                this.volume = volume;
            }

            void append(Node n) {
                n.prev = this;
                next = n;
            }

        }

        Node head;
        Node tail;

        boolean isEmpty() {
            return head == null;
        }

        int collapse() {
            Node focusNode = head;
            int result = 0;
            while (focusNode != null) {
                result += focusNode.volume;
                focusNode = focusNode.next;
            }
            return result;
        }

        Node getPrev() {
            return tail;
        }
    }

    static class Point implements Comparable {
        int[] his;

        Point(int[] his, int index) {
            this.his = his;
            this.index = index;
        }

        int index;

        int getValue() {
            return (his.length > 0 && index < his.length) ? his[index] : 0;
        }

        int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(((Point) o).getValue(), getValue());
        }
    }


    public static void main(String[] str) {
        int[] his = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0}; //45
//        int[] his = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}; //26
        System.out.println(computeVolume(his));
    }

    private static int computeVolume(int[] his) {

        Result result = new Result();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(his.length);

        for (int i = 0; i < his.length; i++) {
            if (his[i] > 0) {
                Result.Node segment = build(i, his, maxHeap, result);

                maxHeap.offer(new Point(his, i));
            }
        }

        System.out.println();
        return result.collapse();
    }

    private static Result.Node build(int i, int[] his, PriorityQueue<Point> maxHeap, Result res) {
        if (maxHeap.isEmpty()) return null;

        Result.Node currentRes = null;

        Point overallMax = maxHeap.peek();
        Point current = new Point(his, i);

        Result.Node prevRes = res.tail;
        if (prevRes != null && prevRes.index != overallMax.index) {
            Result.Node tail = res.tail;

            int obstacles = 0;

            int previousIndex = 0;
            if (current.getValue() >= his[res.tail.index] && res.tail.volume != 0) {
                previousIndex = overallMax.index;


            } else {
                previousIndex = prevRes.index;
            }


            while (res.tail.index > previousIndex) {
                Result.Node section = res.removeLast();
                System.out.println("remove: " + section.volume);
                obstacles += his[section.index];
            }
            while (res.tail.volume == 0) {
                obstacles += his[res.tail.index];
                res.removeLast();
            }

            int volume = calcValue(i, overallMax, current, res.tail) - obstacles;
            currentRes = new Result.Node(i, volume);

        } else {

            if (!res.isEmpty()) {
                int steps = i - prevRes.index - 1;
                int volume = Math.min(his[overallMax.index], his[i]) * steps;
                currentRes = new Result.Node(i, volume);
            } else {
                int steps = i - overallMax.index - 1;
                int volume = Math.min(his[overallMax.index], his[i]) * steps;
                currentRes = new Result.Node(i, volume);
            }

        }

        System.out.println(currentRes.volume);
        res.append(currentRes);

        return currentRes;
    }

    private static int calcValue(int i, Point overallMax, Point currentBorder, Result.Node prev) {
        Point p = null;

        if (currentBorder.getValue() < overallMax.getValue()) {
            p = currentBorder;
            int prevI = prev.index;
            return p.getValue() * (i - prevI - 1);
        } else {
            p = overallMax;
            int prevI = p.index;
            return p.getValue() * (i - prevI - 1);
        }


    }

}
