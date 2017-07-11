package bigO.src.graphs.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/8/17.
 */
public class Graph {
    //    public final List<Vertex> nodes;
    public Map<String, Vertex> nodes;
    public final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
//        nodes = vertexes.stream().collect(Collectors.toMap((e)->Vertex::getId,e));

        nodes = vertexes.stream().collect(HashMap<String, Vertex>::new,
                (m, c) -> m.put(c.getId(), c),
                (m, u) -> {
                });
        edges.stream().forEach(e -> addNeightbour(e.getSource(), e.getDestination()));


        this.edges = edges;
    }

    private void addNeightbour(Vertex source, Vertex destination) {
        nodes.get(source.getId()).addNeightbour(destination);
    }

    public List<Vertex> getNodes() {
        return nodes.values().stream().collect(Collectors.toList());
    }

    public List<Edge> getEdges() {
        return edges;
    }


    public Vertex getVertex(String id) {
        return nodes.get(id);
    }
}
