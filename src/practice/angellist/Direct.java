package bigO.src.practice.angellist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Stanimir on 5/15/17.
 * <p>
 * <p>
 * <p>
 * [{"id":1,"name":"San Francisco Bay Area","parent_id":null},{"id":2,"name":"San Jose","parent_id":3},{"id":3,"name":"South Bay","parent_id":1},{"id":4,"name":"San Francisco","parent_id":1},{"id":5,"name":"Manhattan","parent_id":6},{"id":6,"name":"New York","parent_id":null}]
 */
public class Direct {


    static class Entry implements Comparable {
        String id;
        String name;
        String parentId;
        PriorityQueue<Entry> children = new PriorityQueue<>();

        public Entry() {

        }

        @Override
        public String toString() {
            return id + " " + name + " " + parentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(name, entry.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Object o) {
            return this.name.compareTo(((Entry) o).name);
        }
    }


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();



        Entry root = parseJson(input);//alternative to using json parsing library such as   Jackson


        for (Entry e : root.children) {
            print(e, 0);
        }

    }

    private static Entry parseJson(String input) {

        String trimmed = input.substring(1, input.length() - 1);
        String[] splitted = trimmed.split(",");


        Entry root = new Entry();

        Map<String, Entry> map = new HashMap<>();

        Deque<Entry> remaining = new ArrayDeque<>();
        for (int i = 0; i < splitted.length; i = i + 3) {
            Entry e = new Entry();
            e.id = splitted[i].split(":")[1];
            e.name = splitted[i + 1].split(":")[1].substring(1, splitted[i + 1].split(":")[1].length() - 1);
            e.parentId = splitted[i + 2].split(":")[1].substring(0, splitted[i + 2].split(":")[1].length() - 1);

            map.put(e.id, e);
            if (e.parentId.equals("null")) {
                root.children.add(e);
            } else if (map.containsKey(e.parentId)) {
                Entry parent = map.get(e.parentId);
                parent.children.add(e);
            } else {
                remaining.add(e);
            }
        }

        while (!remaining.isEmpty()) {
            Entry e = remaining.remove();
            Entry parent = map.get(e.parentId);
            if (parent != null) {
                parent.children.add(e);
            }
        }
        return root;
    }

    private static void print(Entry entry, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }
        sb.append(entry.name);
        System.out.println(sb.toString());

        for (Entry e :
                entry.children) {
            print(e, level + 1);
        }

    }

//    public static void main(String[] str) {
//
//        boolean a = true;
//        boolean board = !a;
//        System.out.println((a && board) || (!a && !board));
//
//
//        int i = 4;
//        int j = 1;
//        int[] res =merge(new int[]{1,2}, new int[]{2,3});
//        int k = 0;
////        for ( i = 0; i < 3; i++) {
////            k += j;
////            j = 1 - j;
////        }
//
////        mystery(new int[
////                ]{1,2,3});
////        System.out.println( mystery(new int[
////                ]{5,2,6}));
//    }
//    static int mystery(int a[]) {
//        int m = a[0];
//        int index = 0;
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] < m) {
//                index = i;
//                m = a[i];
//            }
//        }
//        return index;
//    }
//
//    public static int[] merge(int[] a, int[] board) {
//        int[] result = new int[a.length + board.length];
//        int i = 0, j = 0, k = 0;
//        while (i < a.length && j < board.length) {
//            if (a[i] < board[j]) {
//                result[k] = a[i];
//                i++;
//            }
//            else {
//                result[k] = board[j];
//                j++;
//            }
//            k++;
//        }
//        return result;
//    }

}
