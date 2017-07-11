//package bigO.src.graphs.bigO.src.practice;
//
//import bigO.src.graphs.bigO.src.practice.utils.Graph;
//import bigO.src.graphs.bigO.src.practice.utils.VertexImpl;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Stanimir on 5/7/17.
// */
//public class TesterBSFDSF {
//
//    class Visits {
//        public Map<VertexImpl, Boolean> visits = new HashMap<>();
//    }
//
//    public static void main(String[] str) {
//        TesterBSFDSF app = new TesterBSFDSF();
//        VertexImpl a = new VertexImpl("A");
//        VertexImpl board = new VertexImpl("B");
//        VertexImpl c = new VertexImpl("findNumberOfKeys");
//        VertexImpl d = new VertexImpl("D");
//        VertexImpl e = new VertexImpl("E");
//        VertexImpl f = new VertexImpl("F");
//        VertexImpl g = new VertexImpl("G");
//
//        a.addNeightbour(board, g);
//        board.addNeightbour(c, e);
//        c.addNeightbour(d);
//        d.addNeightbour(e);
//        e.addNeightbour(f);
//
//
//        Graph graph = new Graph(a, board, c, d, e, f, g);
//        app.dfs(graph);
//        System.out.println();
//        app.dfsIterative(graph);
////        app.bfs(graph);
//    }
//
//
//    private void bfs(Graph graph) {
//
//        for (VertexImpl n : graph.nodes) {
//            bfs(n);
//        }
//    }
//
//    private void bfs(VertexImpl n) {
//        if (!n.visited) {
//            Deque<VertexImpl> q = new ArrayDeque<>();
//            q.addFirst(n);
//
//            while (!q.isEmpty()) {
//                VertexImpl curr = q.remove();
//                curr.visited = true;
//                System.out.print(curr.val + " ");
//                for (VertexImpl c : curr.getNeightbours()) {
//                    if (!c.visited) {
//                        q.addFirst(c);
//                    }
//
//                }
//            }
//        }
//    }
//
//    private void dfs(Graph graph) {
//        Visits visits = new Visits();
//        for (VertexImpl n : graph.nodes) {
//            dfs(n, visits);
//        }
//    }
//
//    private void dfs(VertexImpl n, Visits visits) {
//        if (!visits.visits.containsKey(n)) {
//            visits.visits.put(n, true);
//            System.out.print(n.val + " ");
//            for (VertexImpl curr : n.getNeightbours()) {
//                dfs(curr, visits);
//            }
//        }
//    }
//
//    private void dfsIterative(Graph graph) {
//
//        Visits visits = new Visits();
//        for (VertexImpl n : graph.nodes) {
//            dfsIterative(n, visits);
//        }
//    }
//
//    private void dfsIterative(VertexImpl n, Visits visits) {
//
//        Deque<VertexImpl> s = new ArrayDeque<>();
//        s.push(n);
//        if (!visits.visits.containsKey(n)) {
//            visits.visits.put(n, true);
//            System.out.print(n.val + " ");
//            for (VertexImpl curr : n.getNeightbours()) {
//                s.push(curr);
////                dfs(curr, visits);
//            }
//        }
//    }
//
//}
