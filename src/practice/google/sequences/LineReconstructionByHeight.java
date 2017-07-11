package bigO.src.practice.google.sequences;


import java.util.*;

/**
 * Created by Stanimir on 6/5/17.
 */
public class LineReconstructionByHeight {

    static class Node implements Comparable {
        int h;
        int c;

        Node next;
        Node prev;

        Node(int h, int c) {
            this.h = h;
            this.c = c;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare((((Node) o).h), h);
        }

        @Override
        public String toString() {
            return "[h:" + h + " c:" + c + "]   ";
        }
    }

    public static void main(String[] str) {
        int[][] input = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        Node[] res = reconstruct(input);

//        List<int[]> res2 = reconstructLine(Arrays.stream(input).collect(Collectors.toList()));

    }

    //[(7, 0),(4, 4),(7,1), (5, 0), (6,1), (5, 2)]

    //[h:7 c:0]   [h:7 c:1]   [h:6 c:1]   [h:5 c:0]   [h:5 c:2]   [h:4 c:4]

    //[(5,0), (7,0), (5,2), (6,1), (4,4),(7,1)]
    private static Node[] reconstruct(int[][] arr) {


        Node[] nodes = new Node[arr.length];


        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i][0], arr[i][1]);
        }
        Arrays.sort(nodes); //nlog(n)
        Arrays.stream(nodes).forEach(System.out::print);
        System.out.println();

        int counter = 0; // nlog(n)
        for (int i = 1; i < nodes.length; i++) {//n
            Node current = nodes[i];
            int count = current.c;

            for (int j = 0; j < i; j++) {//n, n-1, n-2, n-3, .. 0
                Node focusNode = nodes[j];
                System.out.println("current:" + current + " count:" + count+" focusNode: "+focusNode);
                if (focusNode.h >= current.h) {
                    counter++;
                    if (count == 0) {
                        shift(nodes, j, i); // ?
                        Arrays.stream(nodes).forEach(System.out::print);
                        System.out.println("");
                        break;
                    } else {
                        count--;
                    }
                }
            }

        }

        System.out.println("counter" + counter);
        Arrays.stream(nodes).forEach(System.out::print);


        return null;
    }

    private static void shift(Node[] nodes, int j, int i) {

        for (; i > j; i--) {
            swap(nodes, i, i - 1);
        }
    }

    private static void swap(Node[] nodes, int a, int b) {
        Node temp = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = temp;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static List<int[]> reconstructLine(List<int[]> list) {
        //sort by height
        List<Integer[]> result = new ArrayList<Integer[]>();
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] nums1, int[] nums2) {
                if (nums1[0] == nums2[0]) {
                    return nums1[1] - nums2[1];
                } else {
                    return nums1[0] - nums2[0];
                }
            }
        });

//        ListIterator<int[]> i = null;
        while (!list.isEmpty()) {// n,n-1,n-2,..0

            int index = -1;
//            i = list.listIterator();
//            while (i.hasNext()) {
//                int[] entry = i.next();
////                printEntry(entry);
//                if (entry[1] <= result.size()) {
//                    result.add(Arrays.stream(entry).boxed().toArray(Integer[]::new));
//                    i.remove();
//                    break;
//                }
//            }


            for (int i = 0; i < list.size(); i++) {// n, n-1, n-2, n-3..1  -- > log(n) ?
                int[] entry = list.get(i);
                if (entry[1] <= result.size()) {
                    // System.out.println("size: " + result.size());
                    result.add(Arrays.stream(entry).boxed().toArray(Integer[]::new));
                    index = i;
                    break;
                }
            }
            list.remove(index);//o(n)
        }
        System.out.println();
        result.stream().forEach(e -> System.out.print("[h:" + e[0] + " c:" + e[1] + "]"));
        return null;
    }

    static void printEntry(int[] e) {
        System.out.print("[h:" + e[0] + " c:" + e[1] + "]");
    }
}
