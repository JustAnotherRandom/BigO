package bigO.tests.trees;

import bigO.src.trees.util.PriorityQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Stanimir on 6/13/17.
 */
public class PriorityQueueTest {


    @Test
    public void heap() {

        List<Integer> collection = new ArrayList<>(Arrays.asList(new Integer[]{16, 15, 4, 12,
        }));
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for (int i : collection) {
            queue.offer(i);
        }
//        while (!queue.isEmpty()) {
//            System.out.printf(queue.poll() + " ");
//        }

        assertTrue(4 == queue.poll());
        assertTrue(12 == queue.poll());
        assertTrue(15 == queue.poll());
        assertTrue(16 == queue.poll());
        assertTrue(queue.isEmpty());


    }

    @Test
    public void convertToMaxHeap() {
        List<Integer> collection = new ArrayList<>(Arrays.asList(new Integer[]{16, 15, 4, 12,
        }));
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for (int i : collection) {
            queue.offer(i);
        }
        queue.convertToMaxHeap();

//
//        while (!queue.isEmpty()) {
//            System.out.printf(queue.poll() + " ");
//        }


        assertTrue(16 == queue.poll());
        assertTrue(15 == queue.poll());
        assertTrue(12 == queue.poll());
        assertTrue(4 == queue.poll());
        assertTrue(queue.isEmpty());


    }

}
