package bigO.tests.graphs;

import bigO.src.graphs.practice.DjikstraSP;
import bigO.src.graphs.utils.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanimir on 5/8/17.
 */
public class TestDijkstraAlgorithm {

//    @Test
//    public void testExcute() {
//
//
//        Graph graph = buildGraph();
//
//        DikstraAlgorithm dijkstra = new DikstraAlgorithm(graph);
//        dijkstra.execute(graph.nodes.get(0));
//        LinkedList<Vertex> path = dijkstra.getPath(graph.nodes.get(7));
//
//        assertNotNull(path);
//        assertTrue(path.size() > 0);
//
//
//        // a, c, d, g, i
//        for (Vertex vertex : path) {
//            System.out.println(vertex);
//        }
//
//    }

    @Test
    public void practice() {
        Graph g = buildGraph();
        DjikstraSP app = new DjikstraSP(g);
        app.execute(new VertexImpl("a", "a"));
        app.shortestPAth(new VertexImpl("board", "board"));
    }

    private Graph buildGraph() {
        List<Vertex> nodes = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();


//        for (int i = 0; i < 11; i++) {
//            Vertex location = new Vertex("Node_" + i, "Node_" + i);
//            nodes.addFirst(location);
//        }

        Vertex a = new VertexImpl("a", "a");
        nodes.add(a);
        Vertex b = new VertexImpl("board", "board");
        nodes.add(b);
        Vertex c = new VertexImpl("c", "c");
        nodes.add(c);
        Vertex f = new VertexImpl("f", "f");
        nodes.add(f);
        Vertex d = new VertexImpl("d", "d");
        nodes.add(d);
        Vertex g = new VertexImpl("g", "g");
        nodes.add(g);
        Vertex h = new VertexImpl("h", "h");
        nodes.add(h);
        Vertex i = new VertexImpl("i", "i");
        nodes.add(i);
        Vertex e = new VertexImpl("e", "e");
        nodes.add(e);

        Edge _1 = new EdgeImpl("0", a, b, 10);
        edges.add(_1);
        Edge _2 = new EdgeImpl("1", a, c, 5);
        edges.add(_2);
        Edge _3 = new EdgeImpl("2", a, d, 1);
        edges.add(_3);


        Edge _4 = new EdgeImpl("3", c, b, 3);

        Edge _5 = new EdgeImpl("4", c, g, 2);
        Edge _6 = new EdgeImpl("5", d, b, 5);

        Edge _7 = new EdgeImpl("6", b, g, 2);



//        Edge _8 = new EdgeImpl("7", c, d, 1);
//
//        Edge _9 = new EdgeImpl("8", g, c, 3);
//        Edge _10 = new EdgeImpl("9", g, i, 2);
//
//
//        Edge _11 = new EdgeImpl("10", d, a, 1);
//        Edge _12 = new EdgeImpl("11", d, g, 1);
//        Edge _13 = new EdgeImpl("12", d, f, 1);
//        Edge _14 = new EdgeImpl("13", e, i, 7);

        edges.add(_4);
        edges.add(_5);
        edges.add(_6);
        edges.add(_7);
//        edges.add(_8);
//        edges.add(_9);
//        edges.add(_10);
//        edges.add(_11);
//        edges.add(_12);
//        edges.add(_13);
//        edges.add(_14);


//        addLane("Edge_0", 0, 1, 5);
//        addLane("Edge_1", 0, 2, 217);
//        addLane("Edge_2", 0, 4, 173);
//        addLane("Edge_3", 2, 6, 186);
//        addLane("Edge_4", 2, 7, 103);
//        addLane("Edge_5", 3, 7, 183);
//        addLane("Edge_6", 5, 8, 250);
//        addLane("Edge_7", 8, 9, 84);
//        addLane("Edge_8", 7, 9, 167);
//        addLane("Edge_9", 4, 9, 502);
//        addLane("Edge_10", 9, 10, 40);
//        addLane("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10

        return new Graph(nodes, edges);
    }


//
//    private void addLane(String laneId, int sourceLocNo, int destLocNo,
//                         int duration) {
//        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
//        edges.add(lane);
//    }
}
