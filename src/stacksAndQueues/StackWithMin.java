package bigO.src.stacksAndQueues;

/**
 * Created by Stanimir on 3/1/17.
 */
public class StackWithMin {

    private class Node {
        Node next;
        Node min;
        int val;

        public Node(int val, Node min) {
            this.val = val;
            this.min = min;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    Node top;

    void push(int v) {
        Node newNode = new Node(v, null);
        if (top == null) {
            top = newNode;
        } else {
            Node temp = top;
            top = newNode;
            top.next = temp;


            if (temp.min != null)
                top.min = top.val < temp.min.val ? top : temp.min;
            else
                top.min = top.val < temp.val ? top : temp;

        }

    }

    Node pop() throws Exception {
        if (top == null) throw new Exception();

        Node res = top;
        top = top.next;
        return res;
    }

    int getMin() {
        return top.min.val;
    }

    public static void main(String[] str) throws Exception {
        //a,board,c,d
        StackWithMin r = new StackWithMin();
        r.push(5);
        r.push(6);
        r.push(3);
        r.push(7);
        System.out.println(r.getMin());
        r.pop();
        System.out.println(r.getMin());
        r.pop();
        System.out.println(r.getMin());
    }
}
