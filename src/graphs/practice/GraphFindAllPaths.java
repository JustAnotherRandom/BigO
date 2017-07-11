package bigO.src.graphs.practice;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

class GraphFindAllPaths<T> implements Iterable<T> {

    /* A map from nodes in the graph to sets of outgoing edges.  Each
     * set of edges is represented by a map from edges to doubles.
     */
    private final Map<T, Map<T, Double>> graph = new HashMap<T, Map<T, Double>>();

    /**
     * Adds a new node to the graph. If the node already exists then its a
     * no-op.
     *
     * @param node Adds to a graph. If node is null then this is a no-op.
     * @return true if node is added, false otherwise.
     */
    public boolean addNode(T node) {
        if (node == null) {
            throw new NullPointerException("The input node cannot be null.");
        }
        if (graph.containsKey(node)) return false;

        graph.put(node, new HashMap<T, Double>());
        return true;
    }

    /**
     * Given the source and destination node it would addFirst an arc from source
     * to destination node. If an arc already exists then the value would be
     * updated the new value.
     *
     * @param source      the source node.
     * @param destination the destination node.
     * @param length      if length if
     * @throws NullPointerException   if source or destination is null.
     * @throws NoSuchElementException if either source of destination does not exists.
     */
    public void addEdge(T source, T destination, double length) {
        if (source == null || destination == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        /* A node would always be added so no point returning true or false */
        graph.get(source).put(destination, length);
    }

    /**
     * Removes an edge from the graph.
     *
     * @param source      If the source node.
     * @param destination If the destination node.
     * @throws NullPointerException   if either source or destination specified is null
     * @throws NoSuchElementException if graph does not contain either source or destination
     */
    public void removeEdge(T source, T destination) {
        if (source == null || destination == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        graph.get(source).remove(destination);
    }

    /**
     * Given a node, returns the edges going outward that node,
     * as an immutable map.
     *
     * @param node The node whose edges should be queried.
     * @return An immutable view of the edges leaving that node.
     * @throws NullPointerException   If input node is null.
     * @throws NoSuchElementException If node is not in graph.
     */
    public Map<T, Double> edgesFrom(T node) {
        if (node == null) {
            throw new NullPointerException("The node should not be null.");
        }
        Map<T, Double> edges = graph.get(node);
        if (edges == null) {
            throw new NoSuchElementException("Source node does not exist.");
        }
        return Collections.unmodifiableMap(edges);
    }

    /**
     * Returns the iterator that travels the nodes of a graph.
     *
     * @return an iterator that travels the nodes of a graph.
     */
    @Override
    public Iterator<T> iterator() {
        return graph.keySet().iterator();
    }
}

/**
 * Given a connected directed graph, find all paths between any two input points.
 */
class FindAllPaths<T> {

    private final GraphFindAllPaths<T> graph;

    /**
     * Takes in a graph. This graph should not be changed by the client
     */
    public FindAllPaths(GraphFindAllPaths<T> graph) {
        if (graph == null) {
            throw new NullPointerException("The input graph cannot be null.");
        }
        this.graph = graph;
    }

    private void validate(T source, T destination) {

        if (source == null) {
            throw new NullPointerException("The source: " + source + " cannot be  null.");
        }
        if (destination == null) {
            throw new NullPointerException("The destination: " + destination + " cannot be  null.");
        }
        if (source.equals(destination)) {
            throw new IllegalArgumentException("The source and destination: " + source + " cannot be the same.");
        }
    }

    /**
     * Returns the list of paths, where path itself is a list of nodes.
     *
     * @param source      the source node
     * @param destination the destination node
     * @return List of all paths
     */
    public List<List<T>> getAllPaths(T source, T destination) {
        validate(source, destination);

        List<List<T>> paths = new ArrayList<List<T>>();
        recursive(source, destination, paths, new LinkedHashSet<T>());
        return paths;
    }

    // so far this dude ignore's cycles.
    private void recursive(T current, T destination, List<List<T>> paths, LinkedHashSet<T> path) {
        path.add(current);

        if (current.equals(destination)) {
            paths.add(new ArrayList<T>(path));
            path.remove(current);
            return;
        }

        final Set<T> edges = graph.edgesFrom(current).keySet();

        for (T t : edges) {
            if (!path.contains(t)) {
                recursive(t, destination, paths, path);
            }
        }

        path.remove(current);
    }

    public static void main(String[] args) {
        GraphFindAllPaths<String> graphFindAllPaths = new GraphFindAllPaths<String>();
        graphFindAllPaths.addNode("A");
        graphFindAllPaths.addNode("B");
        graphFindAllPaths.addNode("C");
        graphFindAllPaths.addNode("D");
        graphFindAllPaths.addNode("E");

        graphFindAllPaths.addEdge("A", "B", 5);
        graphFindAllPaths.addEdge("B", "C", 4);
        graphFindAllPaths.addEdge("C", "D", 8);
        graphFindAllPaths.addEdge("D", "E", 6);

        graphFindAllPaths.addEdge("A", "D", 5);
        graphFindAllPaths.addEdge("C", "E", 2);
        graphFindAllPaths.addEdge("E", "B", 3);
        graphFindAllPaths.addEdge("A", "E", 7);

        FindAllPaths<String> findAllPaths = new FindAllPaths<String>(graphFindAllPaths);
        List<List<String>> paths = new ArrayList<List<String>>();

//        // ABD
//        List<String> path1 = new ArrayList<String>();
//        path1.addFirst("A");
//        path1.addFirst("B");
//        path1.addFirst("D");
//
//        // ABCD
//        List<String> path2 = new ArrayList<String>();
//        path2.addFirst("A");
//        path2.addFirst("B");
//        path2.addFirst("C");
//        path2.addFirst("D");
//
//        //ACD
//        List<String> path3 = new ArrayList<String>();
//        path3.addFirst("A");
//        path3.addFirst("C");
//        path3.addFirst("D");
//
//        //ABCD
//        List<String> path4 = new ArrayList<String>();
//        path4.addFirst("A");
//        path4.addFirst("C");
//        path4.addFirst("B");
//        path4.addFirst("D");
//
//        paths.addFirst(path1);
//        paths.addFirst(path2);
//        paths.addFirst(path3);
//        paths.addFirst(path4);


        List<List<String>> result = findAllPaths.getAllPaths("A", "C");

        assertEquals(paths, result);
    }
}
