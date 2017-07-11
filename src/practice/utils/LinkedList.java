package bigO.src.practice.utils;

/**
 * Created by Stanimir on 5/30/17.
 */
public class LinkedList<T extends Comparable> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;
    int lenght;

    public LinkedList(T data) {
        head = new LinkedListNode<>(data);
        tail = head;
    }

    public void addFirst(T data) {
        LinkedListNode focusLinkedListNode = new LinkedListNode(data);
        if (head == null) {
            head = focusLinkedListNode;
        } else {
            focusLinkedListNode.next = head;
            head = focusLinkedListNode;
        }
        lenght++;
    }

    public void add(T data) {
        LinkedListNode focusLinkedListNode = new LinkedListNode(data);
        tail.next = focusLinkedListNode;
        focusLinkedListNode.prev = tail;
        tail = focusLinkedListNode;
        lenght++;

    }

    public LinkedListNode getHead() {
        return head;
    }

    public LinkedListNode getTail() {
        LinkedListNode focusLinkedListNode = head;
        while (focusLinkedListNode.next != null) {
            focusLinkedListNode = focusLinkedListNode.next;
        }
        return focusLinkedListNode;
    }

    public void printList() {
        LinkedListNode focusLinkedListNode = head;
        StringBuilder sb = new StringBuilder();
        while (focusLinkedListNode != null) {
            sb.append(focusLinkedListNode.data + " ");
            focusLinkedListNode = focusLinkedListNode.next;
        }
        System.out.printf(sb.toString());
    }


    public int getLenght() {
        return lenght;
    }
}
