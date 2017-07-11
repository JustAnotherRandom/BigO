package bigO.src;

/**
 * Created by Stanimir on 2/27/17.
 */
public class Node implements Comparable<Node> {
    public String key;
    public Node next;

    public Node(String key) {

        this.key = key;
    }

    public Node(String key, Node next) {
        this.key = key;
        this.next = next;
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.print(n.key + " ");
            n = n.next;
        }
    }

    public Node clone() {
        return clone(this);
    }

    public Node clone(Node n) {
        if (n == null) return null;

        Node cur = new Node(n.key);
        Node next = clone(n.next);

        cur.next = next;


        return cur;
    }

    public int getAsInt() {
        return Integer.valueOf(key);
    }

    @Override
    public String toString() {
        return ("key:" + key + " next:" + next.key);
    }


    @Override
    public boolean equals(Object obj) {

        return this.key.equals(((Node) obj).key);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public int compareTo(Node n) {
        int keyAsInt = Integer.valueOf(key);
        return Integer.compare(keyAsInt, Integer.valueOf(n.key));

    }
}
