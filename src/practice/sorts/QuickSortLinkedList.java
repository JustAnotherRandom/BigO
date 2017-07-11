package bigO.src.practice.sorts;

import bigO.src.practice.utils.LinkedList;
import bigO.src.practice.utils.LinkedListNode;

/**
 * Created by Stanimir on 5/30/17.
 */
public class QuickSortLinkedList {


    public static void main(String[] str) {
        LinkedList<Integer> list = new LinkedList(10);
        list.add(8);
        list.add(4);
        list.add(2);

        QuickSortLinkedList app = new QuickSortLinkedList();
        list.printList();
        System.out.println();
        app.sort(list);
        list.printList();


    }

    private void sort(LinkedList list) {
        quickSort(list.getHead(), list.getTail());
    }

    private void quickSort(LinkedListNode l, LinkedListNode h) {

        if (h!=null && l!=h && l!=h.next) {
            LinkedListNode pivot = partition(l, h);
            quickSort(l, pivot.prev);
            quickSort(pivot.next, h);

        }

    }

    private LinkedListNode partition(LinkedListNode l, LinkedListNode h) {

        LinkedListNode pivot = h;

        LinkedListNode low = l;
        LinkedListNode i = l;
        LinkedListNode high = h;
        while (low != high) {
            if (low.compareTo(high) <= 0) {
                swap(i, low);
                i = i.next;
            }
            low = low.next;
        }
        swap(i, h);
        return i;
    }

    private void swap(LinkedListNode left, LinkedListNode right) {
        Comparable temp = left.data;
        left.data = right.data;
        right.data = temp;
    }

}
